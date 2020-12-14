(ns gql.test-runner
  (:require [gql.gql-queries :as q]
            [gql.generation :as g]
            [gql.base-specifications :as b]
            [clj-http.client :as http]
            [clojure.data.json :as json]
            [gql.schema-utils :as gu]
            [malli.generator :as mg]
            [clojure.test.check :as tc]
            [clojure.test.check.properties :as prop]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Result storage

(def result-db (atom []))
(def generation-db (atom []))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn run-query
  [url query-str]
  (let [reply (http/post url {:form-params      {"query" query-str}
                              :throw-exceptions false})
        body  (when (:body reply) (json/read-str (:body reply) :key-fn keyword))]
    (merge
     {:status-code (:status reply)}
     {:body body})
    ))

(defn run-test [url query]
  (if (= query "{}")
    {:status-code 400}
    (let [result (run-query url query)]
      (swap! result-db conj [query result])
      result)))

(defn make-property
  [query-gen url]
  (prop/for-all
   [generated query-gen]
   (let [gql-str (gu/make-gql-string (:fields generated))
         result  (run-test url gql-str)]
     (swap! generation-db conj generated)
     (not= (:status-code result) 500))))

(defn query-schema!
  [url]
  (let [schema-query-response (run-query url q/graphiQL)]
    (-> schema-query-response :body :data :__schema)))

(defn run-test-on-generator
  [generator n url]
  (reset! result-db [])
  (let [test-result (tc/quick-check n (make-property generator url))]
    (if (:pass? test-result)
      test-result
      ;;test-result
      {:failing-example
       (gu/make-gql-string (:fields (first (:smallest (:shrunk test-result)))))}
      )))

(defn permutate-query
  [query]
  (let [query-fields
        (second (second query))]
    (reduce
     (fn [acc field-node]
       (conj acc [:map [:fields [:map (into [] (remove :optional field-node))]]]))
     []
     (rest query-fields))))

(defn run-test-generation
  [url size recursion-limit]
  ;; get query and mutation type
  (try
    (let [gql-schema         (query-schema! url)
          query-type-name    (:name (:queryType gql-schema))
          mutation-type-name (:name (:mutationType gql-schema))]
      (if query-type-name
        (do
          (println (str "Query Type Found : " query-type-name))
          (println "Creating Generators..")
          (let [query-node-map  (g/object-node->specification-map
                                 (gu/find-type gql-schema query-type-name))
                query-generator (mg/generator
                                 (first (vals query-node-map))
                                 {:registry
                                  (g/generation-registry
                                   b/base-registry (:types gql-schema))
                                  :malli.generator/recursion-limit recursion-limit})] 
            ;;(spit "bahn-schema.edn" query-node-map)
            (println "Running generators..")
            (let [test-result
                  (run-test-on-generator query-generator size url)]
              (println "Test generation done.")
              (println test-result))
            (println "Running single field generators..")
            (let [permutated-generators
                  (map
                   (fn [node]
                     (mg/generator
                      node
                      {:registry
                       (g/generation-registry b/base-registry (:types gql-schema))
                       :malli.generator/recursion-limit recursion-limit}))
                   (permutate-query (first (vals query-node-map))))]
              (mapv #(run-test-on-generator % size url) permutated-generators)
              )))
        (println "No Query node found"))
      )
    (catch Exception e
      (str "Exception: " (.getMessage e))))
  )

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Coverage

(defn gql-fields
   [gql-nodes]
   (reduce
    (fn [acc gql-node]
      (let [node-name  (first gql-node)
            node-value (second gql-node)
            node-type  (:type node-value)
            node-args  (:args node-value)]
        ;; value can be vector
        (if (vector? node-type)
          (let [fields (mapcat (fn [field] (gql-fields (:fields field))) node-type)]
            ;; vector fields could be empty if only object wo fields
            (conj (conj acc node-name) fields))
          ;; not vector
          (if (= node-value :scalar)
            (conj acc (key gql-node))
            (let [field (gql-fields (:fields node-type))]
              (conj (conj acc node-name) field))))))
    []
    gql-nodes))

(defn coverage
    [schema generated]
    (let [generated-fields
          (set (mapcat #(flatten (gql-fields (:fields %))) generated))
          schema-fields
          (set (map :name (mapcat :fields (gu/filter-meta-types (:types schema)))))]
      {:missing-fields   (clojure.set/difference schema-fields generated-fields)
       :schema-fields    schema-fields
       :generated-fields generated-fields}))

(defn coverage-report
    [coverage-data]
    {:coverage
     (* 100
        (double
         (/ (count (:generated-fields coverage-data))
            (count (:schema-fields coverage-data)))))
     :missing-fields (:missing-fields coverage-data)})

(defn run-coverage-test
  [query-gen n]
  (let [property (prop/for-all
                  [generated query-gen]
                  (do
                    (swap! generation-db conj generated)
                    true))]
    (tc/quick-check n property)))

(defn run-test-generation-data
  [url size recursion-limit]
  (let [gql-schema         (query-schema! url)
        query-type-name    (:name (:queryType gql-schema))
        mutation-type-name (:name (:mutationType gql-schema))]
    (reset! result-db [])
    (reset! generation-db [])
    (if query-type-name
      (let [query-node-map  (g/object-node->specification-map
                             (gu/find-type gql-schema query-type-name))
            query-generator (mg/generator
                             (first (vals query-node-map))
                             {:registry
                              (g/generation-registry
                               b/base-registry (:types gql-schema))
                              :malli.generator/recursion-limit recursion-limit})]
        (let [test-result
              (run-coverage-test query-generator size)]
          {:test-result test-result
           :call-result @result-db
           :generated   @generation-db}))
      {:test-result :no-query-node})))

(defn run-test-generation-data-with-permutation
  [url size recursion-limit]
  (let [gql-schema         (query-schema! url)
        query-type-name    (:name (:queryType gql-schema))
        mutation-type-name (:name (:mutationType gql-schema))]
    (reset! result-db [])
    (reset! generation-db [])
    (if query-type-name
      (let [query-node-map  (g/object-node->specification-map
                             (gu/find-type gql-schema query-type-name))
            query-generator (mg/generator
                             (first (vals query-node-map))
                             {:registry
                              (g/generation-registry
                               b/base-registry (:types gql-schema))
                              :malli.generator/recursion-limit recursion-limit})]
        (println "Start Permutatded")
        (let [permutated-generators
              (map
               (fn [node]
                 (mg/generator
                  node
                  {:registry
                   (g/generation-registry b/base-registry (:types gql-schema))
                   :malli.generator/recursion-limit recursion-limit}))
               (permutate-query (first (vals query-node-map))))
              test-result (mapv #(run-coverage-test % size) permutated-generators)]
          {:test-result test-result
           :call-result @result-db
           :generated   @generation-db}))
      {:test-result :no-query-node})))


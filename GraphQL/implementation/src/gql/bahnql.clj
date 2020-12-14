(ns gql.bahnql
  (:require [org.httpkit.client :as http]
            [clojure.data.json :as json]
            [clj-http.client :as client]
            [gql.gql-queries :as q]
            [malli.generator :as mg]
            [malli.core :as m]
            [malli.util :as mu]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]))

(def bahn-url "https://bahnql.herokuapp.com/graphql")

;; (defn run-query
;;   [query-str]
;;   (let [response @(http/request {:url          url
;;                                  :method       :post
;;                                  ;;:headers      {"PRIVATE-TOKEN" token}
;;                                  :content-type "application/json"
;;                                  :form-params  {"query" query-str}})]
;;     {:body response ;;(json/read-str (:body response) :key-fn keyword)
;;      :status-code (:status response)}))

(defn run-query
  [url query-str]
  (let [reply (client/post url {:form-params      {"query" query-str}
                                :throw-exceptions false})
        body  (when (:body reply) (json/read-str (:body reply) :key-fn keyword))]
    (merge
     {:status-code (:status reply)}
     {:body body})
    ))

(defn query-schema
    [url]
    (let [schema-query-response (run-query url q/graphiQL)]
      (-> schema-query-response :body :data :__schema)))

(defonce bahn-schema (query-schema bahn-url))

(def example-query
  "{
  stationWithEvaId(evaId: 8000105) {
    name
    location {
      latitude
      longitude
    }
    picture {
      url
    }
  }
}")



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;


;; (defn object-node->map
;;   [object-node]
;;   (let [fields (mapv
;;                 (fn [field] [(:name field) {:optional true} (type->spec (:type field))])
;;                 (:fields object-node))]
;;     {(keyword "object" (:name object-node))
;;      (into [:map] fields)}))







;; (defn schema-objects->maps-with-specs
;;   [schema]
;;   (map object-node->map (find-object-types (filter-meta-types schema))))

;; (defn schema-registry
;;   [base-registry schema]
;;   (let [object-type-specs (apply merge (schema-objects->maps-with-specs schema))
;;         enum-type-specs   (apply merge (schema-enums->maps-with-specs schema))]
;;     (merge base-registry object-type-specs enum-type-specs)))


(comment
  
  ;; (def query-node
  ;;   (object-node->map (find-type bahn-schema "Query")))

  (def query-node2
    (object-node->map2 (find-type bahn-schema "Query")))

  (mg/generate
   (:object/Query query-node2)
   {:size 1 :registry (generation-registry the-registry (:types bahn-schema))})

  (mg/generate
   :object/Route
   {:registry (generation-registry the-registry (:types bahn-schema))})

  (mg/generate
   [:map
    [:type [:vector {:min 1} [:ref :object/Route]]]
    [:args
     [:map
      ["from" :gql.scalar/non-null-int]
      ["to" :gql.scalar/non-null-int]]]]
   {:registry (generation-registry the-registry (:types bahn-schema))})
  
  ;;;;
  ;; target spec

  ;; query-spec and spec for query generation are different
  
  (def some-other-type
;;    (m/schema)
    [:map
     [:fields
      [:map
       ["other-field" {:optional true}
        [:map
         [:type [:ref :other-type]]
         [:args [:map ["arg-1" string?]]]]]]]])
  
  (def target-spec
    [:map
     [:fields
      [:map
       ["my-first-field" {:optional true}
        [:map
         [:type [:ref :other-type]]
         [:args [:map ["arg-1" string?]]]]]
       ["my-second-field" {:optional true}
        [:map
         [:args
          [:map ["arg-1" string?]]]]]]]])



  (mg/generate
   target-spec
   {:size 10
    :registry
    (merge
     (m/class-schemas)
     (m/comparator-schemas)
     (m/base-schemas)
     (m/predicate-schemas)
     {:other-type some-other-type})})

  (mg/generate [:vector {:min 1} [:ref :other-type]]
               {:registry (merge
                           (m/class-schemas)
                           (m/comparator-schemas)
                           (m/base-schemas)
                           (m/predicate-schemas)
                           {:other-type some-other-type})
                :size     4})

  

  ;; (defn make-gql
  ;;   [gql-nodes]
  ;;   (reduce
  ;;    (fn [query-str  gql-node]
  ;;      ;;(println (first gql-node))
  ;;      (let [node-name   (first gql-node)
  ;;            node-value  (second gql-node)
  ;;            type-fields (:fields (:type node-value))]
  ;;        (println (count type-fields))
  ;;        (if (or (and type-fields (seq type-fields))
  ;;                (vector? (:type node-value)))
  ;;          (conj
  ;;           (conj
  ;;            query-str
  ;;            (str node-name
  ;;                 (when (seq (:args node-value))
  ;;                   (let [args (:args node-value)]
  ;;                     (make-arg-string args)))))
  ;;           (if (vector? (:type node-value))
  ;;             (let [fields-gql (mapcat (fn [field-node] (make-gql (:fields field-node))) (:type node-value))]
  ;;              (conj
  ;;               (into ["{ "]
  ;;                     fields-gql)
  ;;               "}"))
  ;;             (conj (into ["{"] (make-gql (:fields (:type node-value)))) "}")))
  ;;          (conj
  ;;           query-str
  ;;           (str node-name
  ;;                (when (seq (:args node-value))
  ;;                  (let [args (:args node-value)]
  ;;                    (make-arg-string args)))
  ;;                " ")))))
  ;;    []
  ;;    gql-nodes))
  
  (defn make-gql
    [gql-nodes]
    (reduce
     (fn [query-str  gql-node]
       ;;(println (first gql-node))
       (let [node-name   (first gql-node)
             node-value  (second gql-node)
             type-fields (:fields (:type node-value))
             fields      (if (vector? (:type node-value))
                           (let [fields-gql (mapcat (fn [field-node] (make-gql (:fields field-node))) (:type node-value))]
                             (if (seq fields-gql)
                               (conj
                                (into ["{ "]
                                      fields-gql)
                                "}")
                               (conj
                                (into [:empty]))))
                           (let [other-fields (make-gql (:fields (:type node-value)))]
                             (if (seq other-fields)
                               (conj (into ["{"] other-fields) "}")
                               (conj [:empty]))))]
         
         (println (count type-fields))
         (if (and (not= [:empty] fields)
              (or (and type-fields (seq type-fields))
                  (vector? (:type node-value))))
           (conj
            (conj
             query-str
             (str node-name
                  (when (seq (:args node-value))
                    (let [args (:args node-value)]
                      (make-arg-string args)))))
            fields
            )
           (if (or (not= [:empty] fields) (= node-value :scalar))
             (conj
              query-str
              (str node-name
                   (when (seq (:args node-value))
                     (let [args (:args node-value)]
                       (make-arg-string args)))
                   " "))
             [""]))))
     []
     gql-nodes))


  
  
  
  

  (make-gql (:fields {:fields
                      {"routing"
                       {:type
                        [{:fields {}, :type :object/Route}
                         {:fields {}, :type :object/Route}],
                        :args {"from" 0, "to" -1}}}}))

  (make-gql (:fields {:fields
                      {"routing"
                       {:type
                        [{:fields {}, :type :object/Route}
                         {:fields
                          {"parts"
                           {:type
                            [{:fields {"delay" :scalar}, :type :object/RoutePart}
                             {:fields
                              {"product"
                               {:type
                                {:fields {"name" :scalar}, :type :object/Product}}},
                              :type :object/RoutePart}]}},
                          :type :object/Route}],
                        :args {"from" 0, "to" -15}}}}))
  
  (make-gql (:fields (first vec-example)))
  
  (def vec-example
    [{:fields
      {"routing"
       {:type
        [{:fields
          {"from"
           {:type
            {:fields
             {"stationNumber" :scalar,
              "stationManagement"
              {:type
               {:fields {"name" :scalar}, :type :object/StationContact}},
              "picture"
              {:type
               {:fields
                {"url" :scalar,
                 "photographer"
                 {:type
                  {:fields {"name" :scalar},
                   :type   :object/Photographer}}},
                :type :object/Picture}}},
             :type :object/Station}}},
          :type :object/Route}
         {:fields
          {"from"
           {:type
            {:fields
             {"hasParking"          :scalar,
              "hasPublicFacilities" :scalar,
              "hasTaxiRank"         :scalar},
             :type :object/Station}}},
          :type :object/Route}],
        :args {"from" 2, "to" 0}}},
      :type :object/Query}
     "{routing(from: 2, to: 0){from{stationNumber stationManagement{name }picture{url photographer{name }}}}{from{hasParking hasPublicFacilities hasTaxiRank }}}"])
  
  ;;;;
  
  (mg/generate
   (first (vals query-node))
   {:registry (merge (schema-registry the-registry (:types bahn-schema)) {:list-of/Route [:vector [:object/Route]]})})
  
  )

(comment
  (def complete-registry
    (schema-registry the-registry (:types bahn-schema))))

(comment

  (map object-node->map (find-object-types (filter-meta-types (:types bahn-schema))))
  
  (map arg->spec
       (:args
        (first (:fields (first (filter-meta-types (:types bahn-schema)))))))
  )

(comment
  
  (def bahn-query-type-name (:name (:queryType bahn-schema)))

  (filter #(= (:name %) bahn-query-type-name) (:types bahn-schema))

  (find-type bahn-schema bahn-query-type-name)

  (find-enums (:types bahn-schema))
  (find-input-types (:types bahn-schema))

  (first (filter-meta-types (:types bahn-schema)))
  
  (spit "bahnql-schema.clj"
        (run-query gql.gql-queries/graphiQL))

  (json/read-str gql.bahnql-schema/schema-json :key-fn keyword))

(comment

  (def Order
  [:schema
   {:registry {"Country"   [:and
                            [:map
                             [:name {:optional true} [:enum :FI :PO]]
                             [:neighbors {:optional true} [:vector [:ref "Country"]]]]
                            [:fn seq]]
               "Burger"    [:map
                            [:name {:optional true} string?]
                            [:description {:optional true} string?]
                            [:origin {:optional true} [:maybe "Country"]]
                            [:price {:optional true} pos-int?]]
               "OrderLine" [:map
                            [:burger {:optional true} "Burger"]
                            [:amount {:optional true} int?]]
               "Order"     [:map {:optional true}
                            [:lines {:optional true} [:vector "OrderLine"]]
                            [:delivery [:map
                                        [:delivered {:optional true} boolean?]
                                        [:address {:optional true} [:map
                                                                    [:street {:optional true} string?]
                                                                    [:zip {:optional true} int?]
                                                                    [:country {:optional true} "Country"]]]]]]}}
   "Order"])

  (mg/generate Order {:size 0})

  (m/map-entries [:map [:a {:optional true} string?]])

  (def thingy
    [:and
     [:map [:a {:optional true} string?]]
     [:fn seq]])

  (m/validate thingy {:a "a"})
  (mg/generate thingy)


  (->> (m/map-entries [:map [:a {:optional true} string?]])
       (filter #(-> % second :optional))
       (map (fn [[k _ s]]
              (gen/one-of (into [(gen/return nil)] (if continue [(value-gen k s)])))))
       (apply gen/tuple))
  )

(comment

  (def mini-query
    {:object/Query
     [:map
      [:fields
       [:map
        ["routing"
         {:optional true}
         [:map
          [:type [:vector {:min 1} [:ref :object/Route]]]
          [:args
           [:map
            ["from" :gql.scalar/non-null-int]
            ["to" :gql.scalar/non-null-int]]]]]]]]})

  (def mini-gen
    (mg/generator
     (:object/Query mini-query)
     {:registry                        (generation-registry the-registry (:types bahn-schema))
      :malli.generator/recursion-limit 10}))
  
  (def query-gen
    (mg/generator
     (:object/Query query-node2)
     {:registry                        (generation-registry the-registry (:types bahn-schema))
      :malli.generator/recursion-limit 10}))

  (def samples
    (map (fn [sample] [sample (make-gql-string (:fields sample))]) samples))

  (def result-db (atom []))
  
  

  #_(defn run-test
    [url query]
      {:status-code 500})
  
  (def the-property
    (prop/for-all [generated query-gen]
                  (let [gql-str (make-gql-string (:fields generated))
                        result  (run-test bahn-url gql-str)]
                    (not= (:status-code result) 500))))


  
  (reset! result-db [])
  (tc/quick-check 10 the-property)

  (defn run-test-generation
    [url n]
    (reset! result-db [])
    (let [test-result (tc/quick-check n the-property)]
      (if (:pass? test-result)
        test-result
        ;;test-result
        {:failing-example (make-gql-string (:fields (first (:smallest (:shrunk test-result)))))}
        )))

  ;; permutate
  

  (def permutated-example-gen
    (mg/generator
     (first (permutate-query query-node2))
     {:registry
      (generation-registry the-registry (:types bahn-schema))
      :malli.generator/recursion-limit 10}))
  
  (def permutated-generators
    (map
     (fn [node]
       (mg/generator
        node
        {:registry
         (generation-registry the-registry (:types bahn-schema))
         :malli.generator/recursion-limit 5}))
     (permutate-query query-node2)))

  

  
  )

;;;;
;; Public API Implementation







(defn permutate-query-2
    [query-node]
    (let [query-fields
          (second (second query-node))]
      (reduce
       (fn [acc field-node]
         (conj acc [:map [:fields [:map (into [] (remove :optional field-node))]]]))
       []
       (rest query-fields))))

;;;;
;; Public API

;; (def query-gen
;;     (mg/generator
;;      (:object/Query query-node2)
;;      {:registry                        (generation-registry the-registry (:types bahn-schema))
;;       :malli.generator/recursion-limit 10}))

;; (defn run-test-generation-2
;;   [url]
;;   ;; get query and mutation type
;;   (try
;;     (let [gql-schema         (query-schema! url)
;;           query-type-name    (:name (:queryType gql-schema))
;;           mutation-type-name (:name (:mutationType gql-schema))]
;;       (if query-type-name
;;         (let [query-node-map  (object-node->map2 (find-type gql-schema query-type-name))
;;               query-generator (mg/generator
;;                                (first (vals query-node-map))
;;                                {:registry
;;                                 (generation-registry the-registry (:types gql-schema))
;;                                 :malli.generator/recursion-limit 2})] 
;;           ;;(spit "bahn-schema.edn" query-node-map)
;;           (println "Running generators..")
;;           (let [test-result
;;                 (run-test-on-generator query-generator 100)]
;;             (println "Test generation done.")
;;             (println test-result))
;;           (println "Running single field generators..")
;;           (let [permutated-generators
;;                 (map
;;                  (fn [node]
;;                    (mg/generator
;;                     node
;;                     {:registry
;;                      (generation-registry the-registry (:types gql-schema))
;;                      :malli.generator/recursion-limit 2}))
;;                  (permutate-query (first (vals query-node-map))))]
;;             (mapv #(run-test-on-generator % 100) permutated-generators)
;;             ))
;;         (println "No Query node found"))
;;       )
;;     (catch Exception e
;;       (str "Exception: " (.getMessage e))))
;;   )

(comment
  ;; Writing comments

  "If I set the generator to not generate empty seq then we will get into trouble due to the recursion limit beeing hit (I think!), resulting in 'such-that' errors"
  "The consequence is that we will generate non-valid queryies due to recursion depth beeing hit, so those need to be filtered out (or included as negative tests)"
  )

(ns gql.seeded-fault-finding-experiment
  (:require [gql.generators :as gqlgen]
            [gql.query-data :as data]
            [gql.gql-queries :as query]
            [gql.small-example-specs :as sspecs]
            [paren.serene :as serene]
            [paren.serene.schema :as schema]
            [clojure.test.check.properties :as prop]
            [org.httpkit.client :as http]
            [clojure.data.json :as json]
            [clojure.spec.alpha :as s]))

(defn run-query
  [query-str]
  (let [response @(http/request {:url    "http://localhost:3000/api/graphql"
                                 :method :post
                                 :as     :text
                                 :body   query-str})]
    {:body        (json/read-str (:body response) :key-fn keyword)
     :status-code (:status response)}))

(comment
  ;; Write specs to file, only needed when schema changed
  (serene/spit-specs
   "small-example-specs.clj"
   'gql.small-example-specs
   (:body (run-query schema/query))))

(defn valid-result?
  [payload]
  ;;(println (str "Validating " payload))
  (every?
   identity
   (map
    eval
    (reduce
     (fn [acc p]
       (conj
        acc
        `(s/valid?
          ~(keyword "gql.small-example-specs.QueryRoot" (name (key p)))
          ~(val p))))
     []
     payload))))

(def small-example-schema
  (:body (run-query query/graphiQL)))

(def results-db (atom []))
(def queries (atom []))

(def test-property
  (let [schema (-> small-example-schema :data :__schema)]
   (prop/for-all [
                  query-tree (gqlgen/gen-gql-nodes
                              (first (filter #(= (:name %) "QueryRoot")
                                             (:types schema)))
                              (:types schema)
                              3
                              gqlgen/resolve-arg-gen-alphanumeric
                              ;;gqlgen/resolve-arg-gen-string
                              )]
                 (let [result (run-query (gqlgen/make-query query-tree))]
                   (swap! results-db conj
                          {:query      (gqlgen/make-query query-tree)
                           :result     result
                           :query-tree query-tree})
                   (swap! queries conj (gqlgen/make-query query-tree))
                   (and
                    (= (:status-code result) 200)
                    (valid-result? (:data (:body result)))
                    ;; Inspect :errors or not
                    ;;(= (:errors (:body result)) nil)
                    )))))

(defn run-tests
  []
  (reset! results-db [])
  (reset! queries [])
  (clojure.test.check/quick-check 100 test-property))

(defn result-errors
  []
  (reduce
   (fn [acc result]
     (let [error (-> result :result :body :errors)]
       (if error
         (conj acc error)
         acc)))
   []
   @results-db))

(defn run-tests-and-report-smallest-failed-query
  []
  (if-let [result (first (:smallest (:shrunk (run-tests))))]
    (gqlgen/make-query result)
    :error-not-found))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Fault finding

;; Bugs are seeded in the "graphql.clj" file of the small example server app

;;;;
;; RESOLVER: resolve-project-by-id
;; 100 Test cases per bug

;; resolve-project-by-id - Example bug 1 - Logic error
(run-tests-and-report-smallest-failed-query)
;; => "{projects(id: \"\"){name }}"

;; resolve-project-by-id - Example bug 2 - NumberFormatException
(run-tests-and-report-smallest-failed-query)
;; => "{projects(id: \"\"){name }}"

;; resolve-project-by-id - Example bug 3 - ClassCastException
(run-tests-and-report-smallest-failed-query)
;; => "{projects(id: \"\"){description }}"

;; resolve-project-by-id - Example bug 4 - Wrong field used to filter
(run-tests-and-report-smallest-failed-query)
;; => :error-not-found

;; resolve-project-by-id - Example bug 5 - Wrong type returned
;; this return 200 but fails the spec validation
(run-tests-and-report-smallest-failed-query)
;; => "{projects(id: \"\"){id name }}"

;; resolve-project-by-id - Example bug 6 - IndexOutOfBoundsException
;; To find this, the generator for ID must be changed to use numbers
(run-tests-and-report-smallest-failed-query) 
;; => "{projects(id: \"-1\"){description }}"

;;;;
;; RESOLVER: resolve-project-owner

;; resolve-project-owner - Example bug 1 - Logic error
;; To find this, the generator for ID must be changed to use numbers
;; Otherwise we will not go as deep in the query as needed
(run-tests-and-report-smallest-failed-query)
;; => "{projects(id: \"1\"){owner{id projects{description owner{name }name }name }id }}"

;; resolve-project-owner - Example bug 2 - Wrong field used to filter
(run-tests-and-report-smallest-failed-query)
;; => :error-not-found

;; resolve-project-owner - Example bug 3 - wrong type "error"
;; To find this the "error" part of the payload must be inspected
(run-tests-and-report-smallest-failed-query)
;; => "{projects(id: \"1\"){description id owner{name }}}"


;;;;
;; RESOLVER: resolve-project-members

;; resolve-project-members - Example bug 1 - logic error
(run-tests-and-report-smallest-failed-query)
;; => "{projects(id: \"2\"){members{name }}}"

;; resolve-project-members - Example bug 2 - Using the wrong field
(run-tests-and-report-smallest-failed-query)
;; => :error-not-found

;; resolve-project-members - Example bug 3 - wrong type "error"
(run-tests-and-report-smallest-failed-query)
;; => "{projects(id: \"1\"){members{age }}}"


;;;;
;; RESOLVER: resolve-user-projects

;; resolve-user-projects - Example bug 1 - logic error
(run-tests-and-report-smallest-failed-query)
;; => "{projects(id: \"1\"){name owner{id projects{id owner{age id }name }name }}}"

;; resolve-user-projects - Example bug 2 - Using the wrong field
(run-tests-and-report-smallest-failed-query)
;; => :error-not-found

;; resolve-user-projects - Example bug 3 - wrong type "error"
(run-tests-and-report-smallest-failed-query)
;; => "{projects(id: \"1\"){members{name projects{owner{id projects{members{age }}age }}id }}}"

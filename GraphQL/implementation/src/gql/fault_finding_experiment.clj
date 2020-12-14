(ns gql.fault-finding-experiment
  (:require [gql.generators :as gqlgen]
            [gql.query-data :as data]
            [gql.git-lab-specs :as gspecs]
            [clojure.test.check.properties :as prop]
            [org.httpkit.client :as http]
            [clojure.data.json :as json]
            [clojure.spec.alpha :as s]))

(def token "ZaBpdrqzpzcmbdEzd1kB")

(def results-db (atom []))
(def queries (atom []))

(defn run-query
  [query-str]
  (let [response @(http/request {:url          "http://localhost/api/graphql"
                                 :method       :post
                                 :headers      {"PRIVATE-TOKEN" token}
                                 :content-type "application/json"
                                 :form-params  {"query" query-str}})]
    {:body (json/read-str (:body response) :key-fn keyword)
     :status-code (:status response)}))

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
          ~(keyword "gql.git-lab-specs.Query" (name (key p)))
          ~(val p))))
     []
     payload))))

(def test-property
  (let [schema (-> data/gitlab-schema :data :__schema)]
   (prop/for-all [
                  query-tree (gqlgen/gen-gql-nodes
                              (nth (:types schema) 2) (:types schema) 3
                              ;; gqlgen/resolve-arg-gen-alphanumeric
                              gqlgen/resolve-arg-gen-string
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
                    ;;(= (:errors (:body result)) nil)
                    )))))

(defn run-tests
  []
  (reset! results-db [])
  (reset! queries [])
  (clojure.test.check/quick-check 10000 test-property))

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

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Fault finding

(run-tests)

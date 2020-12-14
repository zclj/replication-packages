(ns gql.gitlab-experiment
  (:require [clojure.data.json :as json]
            [org.httpkit.client :as http]
            [gql.generators :as gqlgen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.generators :as gen]
            [gql.query-data :as data]
            [clojure.spec.alpha :as s]))


;; (def token "ZaBpdrqzpzcmbdEzd1kB")

;; (defn run-query
;;   [query-str]
;;   (json/read-str 
;;    (:body
;;     @(http/request {:url          "http://localhost/api/graphql"
;;                     :method       :post
;;                     :headers      {"PRIVATE-TOKEN" token}
;;                     :content-type "application/json"
;;                     :form-params  {"query" query-str}}))
;;    :key-fn keyword))

;; (defn run-query-2
;;   [query-str]
;;   (let [response @(http/request {:url          "http://localhost/api/graphql"
;;                                  :method       :post
;;                                  :headers      {"PRIVATE-TOKEN" token}
;;                                  :content-type "application/json"
;;                                  :form-params  {"query" query-str}})]
;;     {:body (json/read-str (:body response) :key-fn keyword)
;;      :status-code (:status response)}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Experiments utils

(def results-db (atom []))

(defn coverage-of-nodes
  []
  (let [schema (-> gql.query-data/gitlab-schema-explore :data :__schema)
        nodes (gqlgen/gen-gql-nodes
               (nth (:types schema) 2) (:types schema))]
    (map #(let [from-type-raw (:from-type %)
                from-type (if from-type-raw from-type-raw "Query")]            
            (vector from-type (:name %))) (flatten (gen/sample nodes 1)))))

(defn make-query-of-nodes
  []
  (let [schema (-> gql.query-data/gitlab-schema-explore :data :__schema)
        nodes (gqlgen/gen-gql-nodes
               (nth (:types schema) 2) (:types schema) 5)]
    (map gqlgen/make-query (gen/sample nodes 100))))


(defn result-field-names
  []
  (into #{} (map :name (flatten (map :query-tree @results-db)))))

(def schema-field-names
  (into #{}
        (flatten
         (reduce
          (fn [acc t]
            (if (and (= (:kind t) "OBJECT")
                     (not= (:name t) "Mutation")
                     (not (clojure.string/starts-with? (:name t) "__")))
              (conj acc (map :name (:fields t)))
              acc))
          []
          (:types (-> gql.query-data/gitlab-schema-explore :data :__schema))))))

(def mutation-related-objects
  #{"AddAwardEmojiPayload" "AwardEmoji" "CreateDiffNotePayload" "CreateImageDiffNotePayload" "CreateNotePayload" "CreateSnippetPayload" "DestroyNotePayload" "IssueSetConfidentialPayload" "IssueSetDueDatePayload" "MarkAsSpamSnippetPayload" "MergeRequestSetAssigneesPayload" "MergeRequestSetLabelsPayload" "MergeRequestSetMilestonePayload" "MergeRequestSetSubscriptionPayload" "MergeRequestSetWipPayload" "RemoveAwardEmojiPayload" "TodoMarkDonePayload" "TodoRestorePayload" "TodosMarkAllDonePayload" "ToggleAwardEmojiPayload" "UpdateNotePayload" "UpdateSnippetPayload" "DestroySnippetPayload" "MergeRequestSetLockedPayload"})

(def schema-field-tuples
  (into #{}
        (filter
         #(not (contains? mutation-related-objects (first %)))
         (reduce
          (fn [acc t]
            (if (and (= (:kind t) "OBJECT")
                     (not= (:name t) "Mutation")
                     (not (clojure.string/starts-with? (:name t) "__")))
              (into acc (map #(vector (:name t) (:name %)) (:fields t)))
              acc))
          []
          (:types (-> gql.query-data/gitlab-schema-explore :data :__schema))))))

(def generated-queries (atom []))
(def generated-nodes-db (atom #{}))

(defn coverage-of-gitlab-schema
  [size max-elements]
  (let [schema             (-> gql.query-data/gitlab-schema-explore :data :__schema)
        query-tree         (gqlgen/gen-gql-nodes
                            (nth (:types schema) 2) (:types schema) max-elements
                            gqlgen/resolve-arg-gen-alphanumeric)
        generated-nodes    (gen/sample query-tree size)
        node-field-names   (into
                            #{}
                            (map
                             #(let [from-type-raw (:from-type %)
                                    from-type
                                    (if from-type-raw from-type-raw "Query")]
                                (vector from-type (:name %)))
                             (flatten generated-nodes)))
        nrof-schema-fields (count schema-field-tuples)
        fields-not-covered (clojure.set/difference schema-field-tuples node-field-names)]
    (swap! generated-nodes-db into node-field-names)
    (reset! generated-queries (map gqlgen/make-query generated-nodes))
    ;;fields-not-covered
    (double
     (/ (- nrof-schema-fields (count fields-not-covered)) nrof-schema-fields))
    ))

;;;;
;; DBs

(def coverage-result-db (atom []))

(defn report-node-coverage-result
  [n]
  {:iterations n
   :avg-coverage (* 100 (double (/ (reduce + @coverage-result-db) n)))
   :compounded-coverage
   (*
    100
    (double
     (/ (count @generated-nodes-db) (count schema-field-tuples))))})

(defn run-range-of-generations
  [n sample-size max-elements]
  (reset! coverage-result-db [])
  (reset! generated-nodes-db #{})
  (do    
    (doseq [_ (range 0 n)]
      (let [result-n (coverage-of-gitlab-schema sample-size max-elements)]
        (swap! coverage-result-db conj result-n)))
    (report-node-coverage-result n)))

(defn run-until-coverage
  [max-n sample-size max-elements]
  (reset! coverage-result-db [])
  (reset! generated-nodes-db #{})
  (loop [n 0]
    (if (and (not= 100.0 (:compounded-coverage (report-node-coverage-result max-n)))
             (< n max-n))
      (recur
       (do
         (let [result-n (coverage-of-gitlab-schema sample-size max-elements)]
           (swap! coverage-result-db conj result-n))
         (inc n)))
      (report-node-coverage-result (count @coverage-result-db)))))


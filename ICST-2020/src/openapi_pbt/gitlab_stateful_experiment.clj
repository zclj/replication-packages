(ns openapi-pbt.gitlab-stateful-experiment
  (:require [openapi-pbt.parse :as parse]
            [openapi-pbt.generation :as generation]
            [openapi-pbt.jschema :as schema]
            [openapi-pbt.responses :as responses]
            [org.httpkit.client :as httpkit]
            [clojure.test.check :as tc]
            [clojure.spec.alpha :as s]
            [clojure.test.check.properties :as prop]
            [clojure.spec.gen.alpha :as gen]
            [cheshire.core :as json]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Setup
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def url-root "http://localhost")
(def access-token "yC6ZAvsZK3JeoEUA5Hs-")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Databases
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def tc-results (atom []))
(def freq-results (atom []))
(def responses-db (atom []))
(def generator-db (atom #{}))
(def call-index (atom []))
(def results-db (atom #{}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Reporting
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn report-result
  [test-n]
  (let [failed      (count (filter not (map :pass? @tc-results)))
        passed      (count (filter identity (map :pass? @tc-results)))
        pass-time
        (double
         (/ (reduce + (filter identity (map :time-elapsed-ms @tc-results))) 60000))
        shrink-time
        (double
         (/
          (reduce
           + (filter identity (map #(get-in % [:shrunk :time-shrinking-ms])
                                   @tc-results))) 60000))
        frequencies (apply merge-with + @freq-results)
        smallest
        (into #{} (filter identity (map #(get-in % [:shrunk :smallest]) @tc-results)))]
    {:failed      failed :passed passed :pass-time pass-time :shrink-time shrink-time
     :iterations  (+ failed passed)
     :frequencies frequencies
     :smallest    smallest
     :test-n      test-n}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Utils
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn call-gitlab
  [token url verb body]
  (update-in
   (condp = verb
     :get   @(httpkit/get
              url
              {:headers     {"Private-Token" token}
               :form-params body})
     :post   @(httpkit/post
               url
               {:headers     {"Private-Token" token}
                :form-params body})
     :put    @(httpkit/put
               url
               {:headers     {"Private-Token" token}
                :form-params (first body)})
     :delete @(httpkit/delete
               url
               {:headers     {"Private-Token" token}
                :form-params body}))
   [:body]
   #(json/parse-string % true)))

(defn run-command
  [call-api-fn path url body]
  #_(println (str "Begin calling Path " path " url " url " body " body))
  (let [next-url (if (clojure.string/includes? (:url path) "{id}")
                  (let [base-url (first (clojure.string/split (:url path) #"\{.*\}"))
                        db-val   @generator-db
                        new-url  (if-let [v (get (last db-val) :id)]
                                   (do
                                     (println (str "Selecting from dB " (str base-url v)))
                                     (str "http://localhost" base-url v))
                                   url)]
                    ;;(println (str "DB val : " db-val))
                    new-url)
                  url)
        result  (call-api-fn next-url (:verb path) body)]
    #_(println (str "Calling " next-url " - " (:verb path) " - " (:status result)))
    result))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Properties
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn run-api-property
  [call-api-fn path url body]
  (try
    (let [responses (:responses path)
          result    (run-command call-api-fn path url body)
          status    (:status result)
          rspec     (get-in responses [(keyword (str status)) :spec])]

      ;;(println (str "Result " result))
      
      ;;(println (str "Call URL : " url " - " (:verb path)))
      ;;(println (str "RAW URL " (:url path)))

      ;;(println (str "Count of DB " (count @generator-db)))
      
      (swap! call-index conj [(:url path) (:verb path) status] )
      (if
          (and rspec
               (or (= status 200) (= status 201) (= status 202) (= status 204)
                   (= status 404) (= status 400))
               (s/valid? rspec (:body result)))
        (do
          #_(println "Valid spec!")
          (when (or (= status 200) (= status 201))
            (do
              (swap! results-db conj (:body result))
              (swap! generator-db conj (:body result))))
          true)
        (do
          (prn "FAILED")
          (when rspec
            (s/explain rspec (:body result)))
          (swap! responses-db conj
                 [{rspec
                   ;;(get-in responses [(keyword (str status)) :spec])
                   (:body result)}
                  (:verb path)
                  (:url path)
                  body
                  status])
          false)))
    (catch java.net.URISyntaxException e
      ;;(prn (str "Malformed URL: " url))
      true)))

(defn get-200-or-404-property-form-data-sequence
  [call-api-fn paths-with-gen]
  (prop/for-all
   [path-seq
    (gen/not-empty
     (gen/vector (gen/bind (gen/elements paths-with-gen)
                           #(gen/tuple (:generator %) (gen/return %)))))]
   (reset! generator-db #{})
   (let [result (doall
                 (map
                  (fn [[generator a-path]]
                    (run-api-property
                     call-api-fn
                     a-path (:url generator) (:form-data generator)))
                  path-seq))]
     (every?
      identity
      result))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Sequences
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn run-tests-on-gitlab-sequence
  [base-url token file-path n]
  (let [raw-doc    (parse/get-json-from-path file-path)
        parsed-doc (parse/parse-doc raw-doc)
        paths      (generation/make-generators base-url (:paths parsed-doc))]
    (reset! call-index [])
    (reset! results-db #{})
    (reset! generator-db #{})
    (reset! responses-db [])
    ;;(println "Produce specs for definitions..")
    (eval (conj (schema/definitions-to-specs "prefix" (:definitions parsed-doc)) 'do))
    ;;(println "Produce specs for responses..")
    (eval (conj (responses/paths-items-to-specs (:paths parsed-doc)) 'do))
    (tc/quick-check
     n
     (get-200-or-404-property-form-data-sequence
      (partial call-gitlab token) paths))))

(defn run-range-of-seq-tests
    [file-path runs n]
    (reset! tc-results [])
    (reset! freq-results [])
    (reset! call-index [])
    (reset! generator-db #{})
    (do
      (doseq [_ (range 0 runs)]
       (do
         (swap!
          tc-results
          conj
          (run-tests-on-gitlab-sequence url-root access-token file-path n))
         (swap!
          freq-results
          conj
          (frequencies @call-index))))
      (report-result n)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Experiments
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(comment
  (run-range-of-seq-tests "gitlab-files/gitlab-seq.json" 1 100)

  ;;;;;;;;;;
  ;; Log output by 'cat production.log | grep -C 15 TRDeadlock'
  ;; in '~/temp/gitlab/logs/gitlab-rails' show that we produced the sequence that
  ;; RESTler did [POST, PUT, DELETE] => Deadlock

;;   Started POST "/api/v4/groups" for 172.17.0.1 at 2019-09-03 13:00:31 +0000
;;   [ActiveJob] Enqueued ActionMailer::DeliveryJob (Job ID: 6f77952d-e6f3-4d8c-ae7e-909c69211157) to Sidekiq(mailers) with arguments: "Notify", "member_access_granted_email", "deliver_now", "Group", 14
;;   [ActiveJob] [ActionMailer::DeliveryJob] [6f77952d-e6f3-4d8c-ae7e-909c69211157] Performing ActionMailer::DeliveryJob from Sidekiq(mailers) with arguments: "Notify", "member_access_granted_email", "deliver_now", "Group", 14
;;   Started DELETE "/api/v4/groups/16" for 172.17.0.1 at 2019-09-03 13:00:32 +0000
;;   User 2 scheduled a deletion of group ID 16 with job ID 758f9d20392d296cc7b51787
;;   Started PUT "/api/v4/groups/16" for 172.17.0.1 at 2019-09-03 13:00:32 +0000
;;   [ActiveJob] [ActionMailer::DeliveryJob] [6f77952d-e6f3-4d8c-ae7e-909c69211157] 
;;   Sent mail to tester@example.com (10.0ms)
;;   [ActiveJob] [ActionMailer::DeliveryJob] [6f77952d-e6f3-4d8c-ae7e-909c69211157] Performed ActionMailer::DeliveryJob from Sidekiq(mailers) in 109.23ms

;;   ActiveRecord::StatementInvalid (PG::TRDeadlockDetected: ERROR:  deadlock detected
;; DETAIL:  Process 1316 waits for ShareLock on transaction 2414; blocked by process 2061.
;; Process 2061 waits for ShareLock on transaction 2415; blocked by process 1316.
;; HINT:  See server log for query details.
;; CONTEXT:  while updating tuple (0,28) in relation "routes"
;; : UPDATE "routes" SET "path" = '7', "name" = '5Y', "updated_at" = '2019-09-03 13:00:32.112134' WHERE "routes"."id" = 16):
;;   /opt/gitlab/embedded/lib/ruby/gems/2.4.0/gems/peek-pg-1.3.0/lib/peek/views/pg.rb:17:in `async_exec'
;;   /opt/gitlab/embedded/lib/ruby/gems/2.4.0/gems/peek-pg-1.3.0/lib/peek/views/pg.rb:17:in `async_exec'
;;   /opt/gitlab/embedded/lib/ruby/gems/2.4.0/gems/activerecord-4.2.10/lib/active_record/connection_adapters/postgresql_adapter.rb:592:in `block in exec_no_cache'
;;   /opt/gitlab/embedded/lib/ruby/gems/2.4.0/gems/activerecord-4.2.10/lib/active_record/connection_adapters/abstract_adapter.rb:484:in `block in log'
;;   /opt/gitlab/embedded/lib/ruby/gems/2.4.0/gems/activesupport-4.2.10/lib/active_support/notifications/instrumenter.rb:20:in `instrument'
  
  ;; =>
  ;; {:failed      1,
  ;;  :passed      0,
  ;;  :pass-time   0.0,
  ;;  :shrink-time 0.1159333333333333,
  ;;  :iterations  1,
  ;;  :frequencies
  ;;  {["/api/v4/groups" :post 400]     79,
  ;;   ["/api/v4/groups/{id}" :put 404] 75,
  ;;   ["/api/v4/groups" :post 201]     6,
  ;;   ["/api/v4/groups/{id}" :put 500] 5},
  ;;  :smallest
  ;;  #{[[[{:url       "http://localhost/api/v4/groups",
  ;;        :verb      :post,
  ;;        :form-data {:name "g", :path "0", :description "251p"}}
  ;;       {:verb :post,
  ;;        :parameters
  ;;        {:name
  ;;         {:in          "formData",
  ;;          :name        "name",
  ;;          :description "The name of the group",
  ;;          :type        "string",
  ;;          :required    true,
  ;;          :spec        :openapi-pbt.api-specs/string},
  ;;         :path
  ;;         {:in          "formData",
  ;;          :name        "path",
  ;;          :description "The path of the group",
  ;;          :type        "string",
  ;;          :required    true,
  ;;          :spec        :openapi-pbt.api-specs/string},
  ;;         :description
  ;;         {:in          "formData",
  ;;          :name        "description",
  ;;          :description "The description of the group",
  ;;          :type        "string",
  ;;          :required    false,
  ;;          :spec        :openapi-pbt.api-specs/string-not-required}},
  ;;        :responses
  ;;        {:201
  ;;         {:description
  ;;          "Create a group. Available only for users who can create groups.",
  ;;          :schema {:$ref "#/definitions/Group"},
  ;;          :spec   :definitions/Group},
  ;;         :400 {:type: "string", :spec :openapi-pbt.api-specs/empty}},
  ;;        :url  "/api/v4/groups",
  ;;        :generator
  ;;        {:gen
  ;;         #function[clojure.test.check.generators/gen-fmap/fn--16613]}}]
  ;;      [{:url       "http://localhost/api/v4/groups/0",
  ;;        :body      [],
  ;;        :form-data [{"name" "c48", "path" "", "description" "Iywy"}],
  ;;        :verb      :put}
  ;;       {:verb :put,
  ;;        :parameters
  ;;        {:id
  ;;         {:in          "path",
  ;;          :name        "id",
  ;;          :description "The ID of a group",
  ;;          :type        "integer",
  ;;          :format      "int32",
  ;;          :required    true,
  ;;          :spec        :openapi-pbt.api-specs/int},
  ;;         :name
  ;;         {:in          "formData",
  ;;          :name        "name",
  ;;          :description "The name of the group",
  ;;          :type        "string",
  ;;          :required    false,
  ;;          :spec        :openapi-pbt.api-specs/string-not-required},
  ;;         :path
  ;;         {:in          "formData",
  ;;          :name        "path",
  ;;          :description "The path of the group",
  ;;          :type        "string",
  ;;          :required    false,
  ;;          :spec        :openapi-pbt.api-specs/string-not-required},
  ;;         :description
  ;;         {:in          "formData",
  ;;          :name        "description",
  ;;          :description "The description of the group",
  ;;          :type        "string",
  ;;          :required    false,
  ;;          :spec        :openapi-pbt.api-specs/string-not-required}},
  ;;        :responses
  ;;        {:200
  ;;         {:description
  ;;          "Update a group. Available only for users who can administrate groups.",
  ;;          :schema {:$ref "#/definitions/Group"},
  ;;          :spec   :definitions/Group},
  ;;         :404
  ;;         {:schema {:$ref "#/definitions/Message"},
  ;;          :spec   :definitions/Message}},
  ;;        :url  "/api/v4/groups/{id}",
  ;;        :generator
  ;;        {:gen
  ;;         #function[clojure.test.check.generators/gen-bind/fn--16618]}}]]]},
  ;;  :test-n      100}
  )

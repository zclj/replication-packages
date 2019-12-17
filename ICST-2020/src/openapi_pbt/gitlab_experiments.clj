(ns openapi-pbt.gitlab-experiments
  (:require [openapi-pbt.parse :as parse]
            [openapi-pbt.generation :as generation]
            [openapi-pbt.jschema :as schema]
            [openapi-pbt.responses :as responses]
            [clj-http.client :as http]
            [clojure.test.check :as tc]
            [clojure.test.check.properties :as prop]
            [clojure.spec.alpha :as s]
            [openapi-pbt.api-specs :as api-specs]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Setup
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def url-root "http://localhost")
(def access-token "Tzz_1zipFxRvdWyxm_ph")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Databases
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def tc-results (atom []))
(def freq-results (atom []))
(def call-index (atom []))
(def results-db (atom #{}))
(def responses-db (atom []))
(def generator-db (atom #{}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Properties
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn run-api-property
  [call-api-fn path url body]
  (try
    (let [responses (:responses path)
          result    (call-api-fn url (:verb path) body)
          status    (:status result)
          rspec     (get-in responses [(keyword (str status)) :spec])]
      ;;(println (str "Call URL : " url))
      (swap! call-index conj [(:url path) (:verb path) status] )
      (if
          (and rspec
               (or (= status 200) (= status 201) (= status 202) (= status 204)
                   (= status 404) (= status 400))
               (s/valid? rspec (:body result)))
        (do
          (when (or (= status 200) (= status 201))
            (do
              (swap! results-db conj (:body result))
              (swap! generator-db conj (:body result))))
          true)
        (do
          (when rspec
            (s/explain rspec (:body result)))
          (swap! responses-db conj
                 [{rspec
                   (:body result)}
                  (:verb path)
                  (:url path)
                  body
                  status])
          false)))
    (catch java.net.URISyntaxException e
      true)))

(defn get-200-or-404-property-form-data
  [call-api-fn path]
  (prop/for-all
   [generator (:generator path)]
   (run-api-property call-api-fn path (:url generator) (:form-data generator))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Experimentation helper functions
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn report-result
  [test-n]
  (let [failed        (count (filter not (map :pass? @tc-results)))
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

(defn call-gitlab
  [token url verb body]
  (condp = verb
    :get  (http/get
           url
           {:throw-exceptions false
            :headers          {"Private-Token" token}
            :form-params      body
            :as               :json})
    :post (http/post
           url
           {:throw-exceptions false
            :headers          {"Private-Token" token}
            :form-params      body
            :content-type     :json
            :as               :json})
    :put  (http/put
           url
           {:throw-exceptions false
            :headers          {"Private-Token" token}
            :form-params      body
            :content-type     :json
            :as               :json})
    
    :delete (http/delete
             url
             {:throw-exceptions false
              :headers          {"Private-Token" token}
              :as               :json})))

(defn run-tests-on-gitlab
  [base-url token file-path n]
  (let [raw-doc    (parse/get-json-from-path file-path)
        parsed-doc (parse/parse-doc raw-doc)
        paths      (generation/make-generators base-url (:paths parsed-doc))]
    (reset! call-index [])
    (reset! results-db #{})
    (reset! responses-db [])
    ;;(println "Produce specs for definitions..")
    (eval (conj (schema/definitions-to-specs "prefix" (:definitions parsed-doc)) 'do))
    ;;(println "Produce specs for responses..")
    (eval (conj (responses/paths-items-to-specs (:paths parsed-doc)) 'do))
    (mapv (fn [path]
            (tc/quick-check
             n
             (get-200-or-404-property-form-data
              (partial call-gitlab token) path))) paths)))

(defn run-range-of-tests
  [file-path runs n]
  (reset! tc-results [])
  (reset! freq-results [])
  (reset! call-index [])
  (do
    (doseq [_ (range 0 runs)]
      (do
        (swap!
         tc-results
         into
         (run-tests-on-gitlab url-root access-token file-path n))
        (swap!
         freq-results
         conj
         (frequencies @call-index))))
    (report-result n)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Experiments
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;
;; Hints

;; tc-results contains the raw results from test-check, can be helpful to debug any
;; experiment i.e. @tc-result

(comment
  ;;;;;;;;;;
  ;; Sanity check, should pass if the setup is correct
  (run-tests-on-gitlab url-root access-token "gitlab-files/gitlab-1.json" 100)
  ;; =>
  ;; [{:result true,
  ;; :pass? true,
  ;; :num-tests 100,
  ;; :time-elapsed-ms 3234,
  ;; :seed 1567501509104}]

  ;;;;;;;;;
  ;; Experiment 1 - One string param, "gitlab-files/gitlab-1.json"
  ;;
  ;; NOTE: frequencies described below coresponds to
  ;; [X (gen/string)] [Y (gen/string-alphanumeric)] [Z (gen/return nil)]
  ;; Change them in 'api_specs.clj' prior to running the specific experiment.
  ;; Remember to evaluate any changes.
  
  ;;;; Running with only one get op and one param, sort, [10,0,0]
  (run-range-of-tests "gitlab-files/gitlab-1.json" 30 100)
  ;; => 0 failed / 30 pass [0.50 min / 0 shrink]
  
  (run-range-of-tests "gitlab-files/gitlab-1.json" 30 1000)
  ;; => 4 failed 26 pass / 3 failed 27 pass [4.17 min / 0.13shrink]

  (run-range-of-tests "gitlab-files/gitlab-1.json" 30 10000)
  ;; =>  16 failed 14 pass / 19 failed 11 pass [16.6 min / 0.56 shrink] 

  ;;;; Running with only one get op and one param, sort, [0,10,0]
  (run-range-of-tests "gitlab-files/gitlab-1.json" 30 100)
  ;; => 0 failed / 30 pass [0.53 min / 0 shrink]

  (run-range-of-tests "gitlab-files/gitlab-1.json" 30 1000)
  ;; => 0 failed 30 pass / 0 failed 30 pass [5.12 min / 0.0 shrink]

  (run-range-of-tests "gitlab-files/gitlab-1.json" 30 10000)
  ;; => 0 failed 30 pass / 0 failed 30 pass [52.9 min / 0 shrink]
  
  ;;;;;;;;;
  ;; Experiment 2 - One param, 'page', "gitlab-files/gitlab-2.json"
  ;; 'page' is a ::api-specs/int, spec:ed as nat-int
  (s/def ::api-specs/int nat-int?)
  (run-range-of-tests "gitlab-files/gitlab-2.json" 30 10)
  ;; =>  0 failed /  30 pass [0.21 min / 0.0 min shrink]
  
  (run-range-of-tests "gitlab-files/gitlab-2.json" 30 100)
  ;; => 28 failed / 2 pass [0.12 min / 14.8 min shrink]

  (run-range-of-tests "gitlab-files/gitlab-2.json" 30 1000)
  ;; => 30 failed / 0 pass [0 min /  15.6 min shrink]

  ;; 'page' is a ::api-specs/int, spec:ed as int?
  (s/def ::api-specs/int int?)
  (run-range-of-tests "gitlab-files/gitlab-2.json" 30 10)
  ;; =>  0 failed /  30 pass [0.22 min /  0 min shrink]
  
  (run-range-of-tests "gitlab-files/gitlab-2.json" 30 100)
  ;; => 18 failed / 12 pass [0.8 min / 9.8 min shrink]

  (run-range-of-tests "gitlab-files/gitlab-2.json" 30 1000)
  ;; => 30 failed / pass [0 min /  16.7 min shrink]

  ;;;;;;;;;;
  ;; Experiment 3 - show the effect of different combinations of
  ;; A/N strings, strings, nat-int and int in POST
  ;;
  ;; Remember to change the frequencies in api_specs.clj as noted
  ;; above each experiment. ::string, ::string-not-required ::int are
  ;; the relevant specs.

  ;;  100% string, nat-int
  (run-range-of-tests "gitlab-files/gitlab-post-2.json" 30 100)
  ;; {:failed      30,
  ;;  :passed      0,
  ;;  :pass-time   0.0,
  ;;  :shrink-time 0.2012166666666667,
  ;;  :iterations  30,
  ;;  :frequencies
  ;;  {["/api/v4/groups" :post 400] 928,
  ;;   ["/api/v4/groups" :post 500] 182},
  ;;  :smallest
  ;;  #{[{:url       "http://localhost/api/v4/groups",
  ;;      :form-data {:name "", :path " "}}]},
  ;;  :test-n      100}

  (run-range-of-tests "gitlab-files/gitlab-post-2.json" 30 1000)
  ;; {:failed      30,
  ;;  :passed      0,
  ;;  :pass-time   0.0,
  ;;  :shrink-time 0.1992166666666667,
  ;;  :iterations  30,
  ;;  :frequencies
  ;;  {["/api/v4/groups" :post 400] 973,
  ;;   ["/api/v4/groups" :post 500] 182},
  ;;  :smallest
  ;;  #{[{:url       "http://localhost/api/v4/groups",
  ;;      :form-data {:name "", :path " "}}]},
  ;;  :test-n      1000}

  ;;  100% A/N string, nat-int
  (run-range-of-tests "gitlab-files/gitlab-post-2.json" 30 100)
  ;; {:failed      0,
  ;;  :passed      30,
  ;;  :pass-time   12.27733333333333,
  ;;  :shrink-time 0.0,
  ;;  :iterations  30,
  ;;  :frequencies
  ;;  {["/api/v4/groups" :post 400] 406,
  ;;   ["/api/v4/groups" :post 201] 2594},
  ;;  :smallest    #{},
  ;;  :test-n      100}

  ;; 50% A/N 50% string, int?
  (run-range-of-tests "gitlab-files/gitlab-post-2.json" 30 100)
  ;; {:failed      30,
  ;;  :passed      0,
  ;;  :pass-time   0.0,
  ;;  :shrink-time 0.2383333333333333,
  ;;  :iterations  30,
  ;;  :frequencies
  ;;  {["/api/v4/groups" :post 400] 1163,
  ;;   ["/api/v4/groups" :post 201] 258,
  ;;   ["/api/v4/groups" :post 500] 218},
  ;;  :smallest
  ;;  #{[{:url       "http://localhost/api/v4/groups",
  ;;      :form-data {:name "", :path " "}}]},
  ;;  :test-n      100}

  ;; 50% A/N 50% string, nat-int?
  (run-range-of-tests "gitlab-files/gitlab-post-2.json" 30 100)
  ;; {:failed      30,
  ;;  :passed      0,
  ;;  :pass-time   0.0,
  ;;  :shrink-time 0.2145666666666667,
  ;;  :iterations  30,
  ;;  :frequencies
  ;;  {["/api/v4/groups" :post 400] 1148,
  ;;   ["/api/v4/groups" :post 201] 271,
  ;;   ["/api/v4/groups" :post 500] 223},
  ;;  :smallest
  ;;  #{[{:url       "http://localhost/api/v4/groups",
  ;;      :form-data {:name "", :path " "}}]},
  ;;  :test-n      100}

  ;; 30% string, 70% A/N , nat-int?
  (run-range-of-tests "gitlab-files/gitlab-post-2.json" 30 100)
  ;; {:failed      30,
  ;;  :passed      0,
  ;;  :pass-time   0.0,
  ;;  :shrink-time 0.2125166666666667,
  ;;  :iterations  30,
  ;;  :frequencies
  ;;  {["/api/v4/groups" :post 400] 821,
  ;;   ["/api/v4/groups" :post 201] 453,
  ;;   ["/api/v4/groups" :post 500] 213},
  ;;  :smallest
  ;;  #{[{:url       "http://localhost/api/v4/groups",
  ;;      :form-data {:name "", :path " "}}]},
  ;;  :test-n      100}

  ;; 10% string, 90% A/N , nat-int?
  (run-range-of-tests "gitlab-files/gitlab-post-2.json" 30 100)
  ;; {:failed      17,
  ;;  :passed      13,
  ;;  :pass-time   5.003183333333333,
  ;;  :shrink-time 0.13815,
  ;;  :iterations  30,
  ;;  :frequencies
  ;;  {["/api/v4/groups" :post 400] 802,
  ;;   ["/api/v4/groups" :post 201] 1582,
  ;;   ["/api/v4/groups" :post 500] 136},
  ;;  :smallest
  ;;  #{[{:url       "http://localhost/api/v4/groups",
  ;;      :form-data {:name "", :path " "}}]},
  ;;  :test-n      100}

  
  ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
  ;; Experiment on api/group/{id} with mixed spec frequencies
  (run-range-of-tests "gitlab-files/gitlab-groups-id-delete.json" 30 100)
  ;; NOTE - some failiurs below is due to 202 not beeing defined
  ;; {:failed      5,
  ;;  :passed      25,
  ;;  :pass-time   0.9952,
  ;;  :shrink-time 0.02953333333333333,
  ;;  :iterations  30,
  ;;  :frequencies
  ;;  {["/api/v4/groups/{id}" :delete 404] 2630,
  ;;   ["/api/v4/groups/{id}" :delete 400] 80,
  ;;   ["/api/v4/groups/{id}" :delete 202] 8,
  ;;   ["/api/v4/groups/{id}" :delete 500] 13},
  ;;  :smallest
  ;;  #{[{:url       "http://localhost/api/v4/groups/26",
  ;;      :body      [],
  ;;      :form-data [],
  ;;      :verb      :delete}]
  ;;    [{:url       "http://localhost/api/v4/groups/12",
  ;;      :body      [],
  ;;      :form-data [],
  ;;      :verb      :delete}]
  ;;    [{:url       "http://localhost/api/v4/groups/0M",
  ;;      :body      [],
  ;;      :form-data [],
  ;;      :verb      :delete}]
  ;;    [{:url       "http://localhost/api/v4/groups/%a0",
  ;;      :body      [],
  ;;      :form-data [],
  ;;      :verb      :delete}]
  ;;    [{:url       "http://localhost/api/v4/groups/40",
  ;;      :body      [],
  ;;      :form-data [],
  ;;      :verb      :delete}]},
  ;;  :test-n      100}

  (run-range-of-tests "gitlab-files/gitlab-groups-id-get.json" 30 100)
  ;; {:failed      30,
  ;;  :passed      0,
  ;;  :pass-time   0.0,
  ;;  :shrink-time 0.19195,
  ;;  :iterations  30,
  ;;  :frequencies
  ;;  {["/api/v4/groups/{id}" :get 404] 65,
  ;;   ["/api/v4/groups/{id}" :get 200] 177},
  ;;  :smallest
  ;;  #{[{:url       "http://localhost/api/v4/groups/ ",
  ;;      :body      [],
  ;;      :form-data [],
  ;;      :verb      :get}]},
  ;;  :test-n      100}

  (run-range-of-tests "gitlab-files/gitlab-groups-id-put.json" 30 100)
  ;; {:failed      0,
  ;;  :passed      30,
  ;;  :pass-time   1.345966666666667,
  ;;  :shrink-time 0.0,
  ;;  :iterations  30,
  ;;  :frequencies
  ;;  {["/api/v4/groups/{id}" :put 404] 2814,
  ;;   ["/api/v4/groups/{id}" :put 200] 186},
  ;;  :smallest    #{},
  ;;  :test-n      100}
  )

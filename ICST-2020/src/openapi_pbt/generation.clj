(ns openapi-pbt.generation
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]
            [clojure.string :as str]
            [openapi-pbt.api-specs :as api-specs]))

(defn find-generator
  [verb mappings db]
  (gen/frequency [[1 (s/gen (:spec verb))]
                  [0 (gen/bind
                      (gen/return :static)
                      (fn [_]
                        (let [db-val {}]
                          (if-let [v (get (first db-val) (keyword (:name verb)))]
                            (gen/return v)
                            (s/gen (:spec verb))))))]]))

(defn path-template?
  [path]
  (s/valid? ::api-specs/path-template? path))

(defn gen-for-template
  [server-url open-api-verb]
  (reduce
   (fn [acc [k v]]
     (cond
       (= (:in v) "path")
       (gen/bind
        acc
        (fn [url]
          (gen/fmap
           (fn [param]
             (assoc
              url
              :url
              (clojure.string/replace
               (:url url)
               (re-pattern (str "\\{" (:name v) "\\}"))
               (str/re-quote-replacement param))))
           ;;(gen/such-that not-empty (s/gen (:spec v)))
           ;; Handle that some params are ints, make them strings before empty check
           (gen/such-that #(not-empty (str %)) (find-generator v {} []))
           )))
       (= (:in v) "body")
       (gen/bind
        acc
        (fn [payload]
          (gen/fmap
           (fn [param]
             (update payload :body conj param))
           (s/gen (:spec v)))))
       (= (:in v) "formData")
       (gen/bind
        acc
        (fn [payload]
          (gen/fmap
           (fn [param]
             (if param
               (update payload :form-data
                       (fn [old p] [(assoc (first old) (:name v) p)]) param)
               payload))
           (s/gen (:spec v)))))
       :else acc))
   (gen/return {:url       (str server-url (:url open-api-verb))
                :body      []
                :form-data []
                :verb      (:verb open-api-verb)})
   (:parameters open-api-verb)))

(defn gen-for-no-template
  [server-url open-api-verb]
  (gen/fmap
   (fn [url-gen]
     (if (or (= (last (:url url-gen)) \?)
             (= (last (:url url-gen)) \&))
       (update url-gen :url #(subs % 0 (- (count %) 1)))
       url-gen))
   (reduce
    (fn [acc [k v]]
      (cond
        (= (:in v) "body")
        (gen/bind
         acc
         (fn [payload]
           (gen/frequency
            [[80
              (gen/fmap
               (fn [param]
                 (assoc payload :body param))
               (s/gen (:spec v)))]
             [20
              (gen/fmap
               (fn [mutant]
                 (assoc payload :body mutant))
               (gen/bind (s/gen (:spec v))
                         (fn [x]
                           ;; Potential to add more 'mutations'
                           (if (and (seq x)
                                    (map? (first x))
                                    (seq (keys (first x))))
                             (gen/vector (gen/map (gen/elements (keys (first x)))
                                                  (gen/elements (vals (first x)))))
                             (gen/return x)))))]])))

        (= (:in v) "formData")
        (gen/bind
         acc
         (fn [payload]
           (gen/fmap
            (fn [param]
              (if param
                (update payload :form-data merge {(keyword (:name v)) param})
                payload)
              ;;(assoc payload :form-data param)
              )
            (s/gen (:spec v)))))

        (= (:in v) "query")
        (gen/bind
         acc
         (fn [payload]
           (gen/fmap
            (fn [param]
              (if (and (not= param nil) (not= param ""))
                (update payload :url #(str % "?" (:name v) "=" param "&"))
                payload))
            (s/gen (:spec v)))))
        :else acc))
    (gen/return {:url  (str server-url (:url open-api-verb))
                 ;;:form-data []
                 :verb (:verb open-api-verb)
                 })
    (:parameters open-api-verb))))

(defn make-gen
  [server-url open-api-verb]
  ;; there can be params of in query, path, body etc in addition the url
  ;; can be in template format with some param in the url and some in body
  (if (path-template? (:url open-api-verb))
    (assoc open-api-verb :generator (gen-for-template server-url open-api-verb))
    (assoc open-api-verb :generator (gen-for-no-template server-url open-api-verb))))

(defn make-generators
  [server-url parsed-open-api-doc]
  (mapv #(make-gen server-url %) parsed-open-api-doc))

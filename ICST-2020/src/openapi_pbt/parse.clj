(ns openapi-pbt.parse
  (:require [cheshire.core :as json]
            [openapi-pbt.jschema :as jschema]
            [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]
            [openapi-pbt.api-specs :as api-specs]))

(defn get-json-from-path
  [path]
  (json/parse-string (slurp path)))

(defn schema-ref-to-spec-name
  [schema-object]
  (let [ref-path (get-in schema-object [:schema :$ref])
        ref-name (last (clojure.string/split ref-path #"/"))]
    (keyword "definitions" ref-name)))

(defn schema-object-to-spec-name
  [schema-object]
  (let [ref-path (get-in schema-object [:schema :items :$ref])
        ref-name (last (clojure.string/split ref-path #"/"))
        ref-type (get-in schema-object [:schema :type])
        unique (when (get-in schema-object [:schema :uniqueItems])
                 "unique-")]
    (keyword (str unique ref-type) ref-name)))

(defn open-api-schema-type
  [schema-object]
  (if-let [schema (get schema-object :schema)]
    (cond
      (s/valid? :response/object schema)        {:type "object"}
      (s/valid? :response/array schema)         (select-keys
                                                 (:schema schema-object) [:type])
      (s/valid? :response/array-strings schema) {:type "array-strings"})
    {}))

(defn open-api-type
  [object]
  (cond
    (s/valid? :response/array-ints object)    {:type "array-ints"}
    (s/valid? :response/array-objects object) {:type "array-objects"}
    (s/valid? :response/array-string-uuid object)
    {:type "array-string-uuids"}
    (s/valid? :response/array-strings object) {:type "array-strings"}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Params to spec

(defn open-api-to-spec-dispatch
  [param]
  (let [schema?     (contains? param :schema)
        disp-params (select-keys param [:type :required :format])]
    (if schema?
      (merge (assoc disp-params :schema schema?) (open-api-schema-type param))
      (merge disp-params (open-api-type param)))))

(defmulti open-api-param-to-spec
  open-api-to-spec-dispatch)

(defmethod open-api-param-to-spec {:type "string" :required false}
  [param]
  (if-let [enum (:enum param)]
    (let [def-name (keyword "definitions" (:name param))
          sp
          `(s/def ~def-name
             (s/with-gen (s/or :string string? :empty nil?)
               #(gen/frequency [[5 (gen/elements ~enum)]
                                [5 (gen/return nil)]])))
          _ (eval sp)]
      (keyword "definitions" (:name param)))
    ::api-specs/string-not-required))

(defmethod open-api-param-to-spec {:type "string" :required true}
  [_]
  ::api-specs/string)

(defmethod open-api-param-to-spec {:type "string", :required true, :format "uuid"}
  [_]
  ::api-specs/string-uuid)

(defmethod open-api-param-to-spec {:type "integer" :required true :format "int32"}
  [_]
  ::api-specs/int)

(defmethod open-api-param-to-spec {:type "integer" :required false :format "int32"}
  [_]
  ::api-specs/int)

(defmethod open-api-param-to-spec {:type "number", :required true, :format "float"}
  [_]
  ::api-specs/float)

(defmethod open-api-param-to-spec {:type "string",
                                   :required false,
                                   :format "date-time"}
  [_]
  ::api-specs/string-date-time)

(defmethod open-api-param-to-spec {:type "string",
                                   :required false,
                                   :format "date"}
  [_]
  ::api-specs/string-date)

(defmethod open-api-param-to-spec {:type "boolean", :required false}
  [_]
  ::api-specs/bool-not-required)

(defmethod open-api-param-to-spec {:type "boolean", :required true}
  [_]
  ::api-specs/bool)

(defmethod open-api-param-to-spec {:required true, :type "array-objects"}
  [param]
  ::api-specs/array-objects)

(defmethod open-api-param-to-spec {:required false, :type "array-ints"}
  [param]
  ::api-specs/array-ints)

(defmethod open-api-param-to-spec {:required false :type "array-strings"}
  [param]
  ::api-specs/array-strings)

(defmethod open-api-param-to-spec {:required true :type "array-strings"}
  [param]
  ::api-specs/array-strings)

(defmethod open-api-param-to-spec {:required true, :type "file"}
  [param]
  ::api-specs/file)

(defmethod open-api-param-to-spec {:schema true :required true :type "array"}
  [param]
  (schema-object-to-spec-name param))

(defmethod open-api-param-to-spec {:required true, :schema true, :type "array-strings"}
  [param]
  ::api-specs/array-strings)

(defmethod open-api-param-to-spec {:schema true :required false :type "object"}
  [param]
  (schema-ref-to-spec-name param))

(defmethod open-api-param-to-spec {:schema true :required true :type "object"}
  [param]
  (schema-ref-to-spec-name param))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Response to spec
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn open-api-response-to-spec-dispatch
  [response]
  (if-let [schema (get response :schema)]
    (cond
      (s/valid? :response/object schema) {:type "object"}
      (s/valid? :response/array schema)  (select-keys (:schema response) [:type]))
    {}))

(defmulti open-api-respons-to-spec
  (fn [response]
    (open-api-response-to-spec-dispatch response)))

(defmethod open-api-respons-to-spec {:type "array"}
  [response]
  (schema-object-to-spec-name response))

(defmethod open-api-respons-to-spec {:type "object"}
  [response]
  (schema-ref-to-spec-name response))

(defmethod open-api-respons-to-spec {}
  [response]
  ::api-specs/empty)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Parse of top entities
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn parse-verb-responses
  [responses]
  (apply merge
         (map (fn [[status status-desc]]
                (let [kw-status-desc (clojure.walk/keywordize-keys status-desc)
                      with-spec      (assoc
                                      kw-status-desc
                                      :spec (open-api-respons-to-spec kw-status-desc))]
                  {(keyword status) with-spec}))
              responses)))

(defn parse-verb-parameters
  [parameters]
  (if-let [parsed-params
           (apply
            merge
            (map (fn [param]
                   (let [kw-param (clojure.walk/keywordize-keys param)
                         with-spec
                         (merge kw-param
                                {:spec   (open-api-param-to-spec kw-param)})]
                     {(keyword (get param "name")) with-spec}))
                 parameters))]
    parsed-params
    []))

(defn parse-verbs
  [[verb verb-data]]
  {:verb       (keyword verb)
   :parameters (parse-verb-parameters (get verb-data "parameters"))
   :responses  (parse-verb-responses (get verb-data "responses"))})

(defn parse-path
  [base-path [path path-data]]
  (mapv (fn [pd] (assoc (parse-verbs pd) :url (str base-path path))) path-data))

(defn parse-definitions
  [definitions]
  (jschema/parse-schema definitions))

(defn parse-doc*
  [open-api-doc]
  (let [base-path (get open-api-doc "basePath")]
    (reduce
     (fn [acc path]
       (into acc (parse-path base-path path)))
     []
     (get open-api-doc "paths"))))

(defn parse-doc
  [open-api-doc]
  {:paths       (parse-doc* open-api-doc)
   :definitions (parse-definitions (get open-api-doc "definitions"))})

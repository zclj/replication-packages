(ns openapi-pbt.jschema
  (:require [clojure.spec.alpha :as s]
            [openapi-pbt.api-specs :as api-specs]))

(defn parse-schema
  [schema-json]
  (clojure.walk/keywordize-keys schema-json))

(defn property-ref-to-spec-name
  [property-ref]
  (let [ref-path (get-in property-ref [:$ref])
        ref-name (last (clojure.string/split ref-path #"/"))]
    (keyword "definitions" ref-name)))

(defn property-array-with-ref-to-spec-name
  [property-array]
  (let [ref-path (get-in property-array [:items :$ref])
        ref-name (last (clojure.string/split ref-path #"/"))
        ref-type "array"
        unique   (when (get property-array :uniqueItems)
                   "unique-")]
    (keyword (str unique ref-type) ref-name)))

(defn property-array-with-enum-to-spec-name
  [property-array]
  (let [unique (when (:uniqueItems property-array)
                 "unique-")
        type   (:type property-array)
        items  (:items property-array)]
    (keyword (str unique type)
             (str "enum-" (apply str (interpose "-" (:enum items)))))))

(defn enum-to-spec
  [property-array]
  `(s/def
     ~(property-array-with-enum-to-spec-name property-array)
     (s/coll-of ~(into #{} (get-in property-array [:items :enum])) :type vector?)))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Properties
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn property-array-to-type
  [property-array]
  (let [items (:items property-array)]
    (cond
      (s/valid? :jschema/ref items)        {:type "array" :items :ref}
      (s/valid? :jschema.items/enum items) {:type "array" :items :enum}
      (s/valid? :jschema.items/type items)
      (if-let [format (:format items)]
        {:type "array" :items (:type items) :format format}
        {:type "array" :items (:type items)}))))

(defn json-schema-property-to-dispatch
  [property-type]
  (cond
    (s/valid? :jschema/ref property-type)
    {:type "ref"}
    (s/valid? :jschema/array property-type)
    (property-array-to-type property-type)
    :default (select-keys property-type [:type :format])))

(defmulti json-schema-property-type-to-spec
  (fn [property-type]
    (json-schema-property-to-dispatch property-type)))

(defmethod json-schema-property-type-to-spec {:type "string"}
  [_]
  ::api-specs/string)

(defmethod json-schema-property-type-to-spec {:type "boolean"}
  [_]
  ::api-specs/bool)

(defmethod json-schema-property-type-to-spec {:type "string" :format "uuid"}
  [_]
  ::api-specs/string-uuid)

(defmethod json-schema-property-type-to-spec {:type "integer"}
  [_]
  ::api-specs/integer)

(defmethod json-schema-property-type-to-spec {:type "object"}
  [_]
  ::api-specs/object)

(defmethod json-schema-property-type-to-spec {:type "array" :items :enum}
  [property-array]
  (property-array-with-enum-to-spec-name property-array))

(defmethod json-schema-property-type-to-spec {:type "array" :items :ref}
  [property-array]
  (property-array-with-ref-to-spec-name property-array))

(defmethod json-schema-property-type-to-spec {:type "array", :items "string"}
  [property-array]
  ::api-specs/array-strings)

(defmethod json-schema-property-type-to-spec
  {:type "array", :items "string", :format "uuid"}
  [property-array]
  ::api-specs/array-uuids)

(defmethod json-schema-property-type-to-spec {:type "ref"}
  [property-ref]
  (property-ref-to-spec-name property-ref))

(defn ref-to-spec
  [property-ref]
  `(s/def
     ~(property-array-with-ref-to-spec-name property-ref)
     (s/coll-of ~(property-ref-to-spec-name (:items property-ref)))))

(defn properties-to-specs
    [properties]
    (reduce
     (fn [acc p]
       ;;(prn p)
       (cond
         (get-in (val p) [:items :enum])
         (cons (enum-to-spec (val p))
               (cons
                `(s/def
                   ~(keyword (str "prefix/" (name (key p))))
                   ~(json-schema-property-type-to-spec (val p)))
                acc))
         (get-in (val p) [:items :$ref])
         (cons (ref-to-spec (val p))
               (cons
                `(s/def
                   ~(keyword (str "prefix/" (name (key p))))
                   ~(json-schema-property-type-to-spec (val p)))
                acc))
         :default
         (cons
          `(s/def
             ~(keyword (str "prefix/" (name (key p))))
             ~(json-schema-property-type-to-spec (val p)))
          acc)))
     []
     properties))

(defn group-by-required
   [properties required]
    (let [required-ks (mapv keyword required)]
      (group-by #(some? (some #{%} required-ks)) (keys properties))))

(defn properties-to-keys-spec
    [prefix properties required]
    (let [{req-ks true opt-ks false} (group-by-required properties required)]
      (cond-> `(s/keys)
        (seq req-ks)
        (concat `(:req-un ~(mapv #(keyword prefix (name %)) req-ks)))
        (seq opt-ks)
        (concat `(:opt-un ~(mapv #(keyword prefix (name %)) opt-ks))))))

(defn object-to-spec
    [prefix object-name properties required]
    `(s/def
       ~(keyword (str "definitions/" object-name))
       ~(properties-to-keys-spec prefix properties required)))

(defn sort-definition-specs
  [specs]
  (reverse
   (reduce
    (fn [acc s]
      (if (not (seq (filter #(= % s) acc)))
        (let [[_ spec-name spec] s]
          ;; if the spec is a reference to another spec an that spec is not in the registry or already in the result
          (if (and (keyword? spec) (= "definitions" (namespace spec))
                   (not (seq (filter (fn [[_ n _]] (= spec n)) acc))))
            (if-let [missing-spec (first (filter (fn [[_ n _]] (= spec n)) specs))]
              (conj (conj acc missing-spec) s)
              (conj acc s))
            (conj acc s))
          )
        acc))
    '()
    specs)))

(defn definition-to-spec
  [prefix definition-k definition-object]
  (let [object-name (name definition-k)
        properties  (:properties definition-object)
        required    (:required definition-object)]
     (concat
      (properties-to-specs properties)
      (list (object-to-spec prefix object-name properties required)))))

(defn definitions-to-specs
  [prefix definitions]
  (let [specs (mapcat (fn [[k v]] (definition-to-spec prefix k v)) definitions)]
    (sort-definition-specs (distinct specs))))

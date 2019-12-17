(ns openapi-pbt.api-specs
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.gen.alpha :as gen]))

(s/def ::string (s/with-gen string?
                  #(gen/frequency [[0 (gen/string)]
                                   [10 (gen/string-alphanumeric)]
                                   [0 (gen/return "1")]])))

(s/def ::string-not-required
  (s/with-gen (s/or :string string? :empty nil?)
    #(gen/frequency [[0 (gen/string)]
                     [10 (gen/string-alphanumeric)]
                     [0 (gen/return nil)]
                     [0 (gen/return "1")]])))



(def uuid-regex
  #"^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$")

(s/def ::string-uuid (s/with-gen
                       (s/and string? #(re-matches uuid-regex %))
                       #(gen/fmap str (s/gen uuid?))))

(s/def ::bool boolean?)

(s/def ::object map?)

(s/def ::empty any?)

(s/def ::int nat-int? #_(s/with-gen nat-int?
               #(gen/frequency [[1 (gen/int)]
                                [0 (gen/return 1)]]))) ;; changed for experiment from nat-int? to int?

(s/def ::integer int?)

(s/def ::float float?)

(s/def ::string-date-time string?)
(s/def ::string-date string?)

(s/def ::bool-not-required (s/or :bool boolean? :empty nil?))

(def path-template-section-regex #"\{.*\}")
(s/def ::path-template (s/and string? #(re-matches path-template-section-regex %)))

(def path-template?-regex #".*\{.*\}.*")
(s/def ::path-template? (s/and string? #(re-matches path-template?-regex %)))

(s/def ::temp-schema map?)

(s/def ::array-strings (s/coll-of string?))

(s/def ::array-uuids (s/coll-of ::string-uuid))

(s/def ::array-objects (s/coll-of map?))

(s/def ::array-ints (s/coll-of int?))

(s/def ::file string?)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; JSON Schema

(s/def :jschema/type #{"string" "number" "integer" "boolean" "null" "array" "object"})

(s/def :jschema.array/type #{"array"})

(s/def :jschema/$ref string?)

(s/def :jschema/items (s/keys :req-un [:jschema/$ref]))

(s/def :jschema/ref (s/keys :req-un [:jschema/$ref]))

(s/def :jschema/enum vector?)

(s/def :jschema.enum/type #{"integer"})

(s/def :jschema.items/enum (s/keys :req-un [:jschema/enum
                                            :jschema.enum/type]))

(s/def :jschema.items/type (s/keys :req-un [:jschema/type]))

(s/def :jschema.v2/items (s/or :enum :jschema.items/enum
                               :ref :jschema/ref
                               :type :jschema.items/type))

(s/def :jschema/array (s/keys :req-un [:jschema.array/type :jschema.v2/items]))

(s/def :jschema.string/type #{"string"})
(s/def :jschema.int/type #{"integer"})
(s/def :jschema.object/type #{"object"})

(s/def :jschema.uuid/format #{"uuid"})

(s/def :jschema.string/items (s/keys :req-un [:jschema.string/type]))
(s/def :jschema.int/items (s/keys :req-un [:jschema.int/type]))
(s/def :jschema.object/items (s/keys :req-un [:jschema.object/type]))
(s/def :jschema.string.uuid/items
  (s/keys :req-un [:jschema.string/type :jschema.uuid/format]))

(s/def :response/object (s/keys :req-un [:jschema/$ref]))

(s/def :response/array (s/keys :req-un [:jschema.array/type :jschema/items]))

(s/def :response/array-strings
  (s/keys :req-un [:jschema.array/type :jschema.string/items]))

(s/def :response/array-ints
  (s/keys :req-un [:jschema.array/type :jschema.int/items]))

(s/def :response/array-objects
  (s/keys :req-un [:jschema.array/type :jschema.object/items]))

(s/def :response/array-string-uuid
  (s/keys :req-un [:jschema.array/type :jschema.string.uuid/items]))

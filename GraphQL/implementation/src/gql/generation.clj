(ns gql.generation
  (:require [gql.base-specifications :as gb]
            [gql.schema-utils :as gu]))

(defn enum->specification
  [enum-type]
  (let [enum-values (mapv :name (:enumValues enum-type))]
    (into [:enum] enum-values)))

(defn union->specification
  [union-type]
  (into
     [:or]
     (mapv
      (fn [pt] [:ref (keyword "object" (:name pt))])
      (:possibleTypes union-type))))

(defn enum-node->specification-map
  [enum-type]
  {(keyword "enum" (:name enum-type)) (enum->specification enum-type)})

(defn union-node->specification-map
  [union-type]
  {(keyword "union" (:name union-type)) (union->specification union-type)})

(defn object-node->specification-map
  [object-node]
  (let [fields (mapv
                (fn [field]
                  (let [args
                        (mapv
                         (fn [arg] [(:name arg) (gb/type->specification (:type arg))])
                         (:args field))]
                    [(:name field) {:optional true}
                     (if (seq args)
                       [:map
                        [:type (gb/type->specification
                                (gb/type->specification (:type field)))]
                        [:args (into [:map] args)]]
                       (if (gb/scalar?
                            (gb/type->specification
                             (gb/type->specification (:type field))))
                         [:enum :scalar]
                         [:map
                          [:type (gb/type->specification
                                  (gb/type->specification (:type field)))]]))]))
                (:fields object-node))]
    {(keyword "object" (:name object-node))
     [:map
      [:fields (into [:map] fields)]
      [:type [:enum (keyword "object" (:name object-node))]]]}))

(defn schema-objects->maps-with-specifications
  [schema]
  (map
   object-node->specification-map (gu/find-object-types (gu/filter-meta-types schema))))

(defn schema-enums->maps-with-specifications
  [schema]
  (map enum-node->specification-map
       (gu/find-enums (gu/filter-meta-types schema))))

(defn schema-unions->maps-with-specifications
  [schema]
  (map union-node->specification-map
       (gu/find-union-types (gu/filter-meta-types schema))))

(defn generation-registry
  [base-registry schema]
  (let [object-type-specs (apply merge (schema-objects->maps-with-specifications schema))
        enum-type-specs   (apply merge (schema-enums->maps-with-specifications schema))
        union-type-specs  (apply merge (schema-unions->maps-with-specifications schema))]
    (merge base-registry object-type-specs enum-type-specs union-type-specs)))


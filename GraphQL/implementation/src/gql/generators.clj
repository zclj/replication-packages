(ns gql.generators
  (:require [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Utils

(defn resolve-field-type
  [field-type]
  (let [kind         (:kind field-type)
        type-name    (:name field-type)
        of-type-kind (:kind (:ofType field-type))
        of-type-name (:name (:ofType field-type))]
   (cond
     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "String"])
     :gql.scalar/non-null-string

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "Boolean"])
     :gql.scalar/non-null-boolean

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "Int"])
     :gql.scalar/non-null-int

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "ID"])
     :gql.scalar/non-null-id

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "Time"])
     :gql.scalar/non-null-time

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "Float"])
     :gql.scalar/non-null-float

     (= [kind type-name]
        ["SCALAR" "Boolean"])
     :gql.scalar/boolean

     (= [kind type-name]
        ["SCALAR" "Int"])
     :gql.scalar/int

     (= [kind type-name]
        ["SCALAR" "Float"])
     :gql.scalar/float

     (= [kind type-name]
        ["SCALAR" "String"])
     :gql.scalar/string

     (= [kind type-name]
        ["SCALAR" "Time"])
     :gql.scalar/time

     (= [kind of-type-kind]
        ["NON_NULL" "ENUM"])
     :gql/enum
     
     (= [kind of-type-kind]
        ["NON_NULL" "OBJECT"])
     :gql/object

     ;; TODO - might need a null collection
     (= [kind of-type-kind
         (-> field-type :ofType :ofType :kind)
         (-> field-type :ofType :ofType :ofType :kind)
         ]
        ["NON_NULL" "LIST" "NON_NULL" "OBJECT"])
     :gql.list/object

     (= [kind of-type-kind
         (-> field-type :ofType :ofType :kind)
         (-> field-type :ofType :ofType :ofType :kind)
         ]
        ["NON_NULL" "LIST" "NON_NULL" "ENUM"])
     :gql.list/enum

     (= [kind of-type-kind
         (-> field-type :ofType :ofType :kind)
         (-> field-type :ofType :ofType :ofType :kind)
         ]
        ["NON_NULL" "LIST" "NON_NULL" "SCALAR"])
     (condp = (-> field-type :ofType :ofType :ofType :name)
       "String"
       :gql.list.scalar/non-null-string
       "ID"
       :gql.list.scalar/non-null-id)
     
     (= [kind of-type-kind]
        ["NON_NULL" "LIST"])
     (if-let [type-name (:name (:ofType field-type))]
       :gql/list
       :bad-format-non-null-list)

     (= [kind of-type-kind (-> field-type :ofType :ofType :kind)]
        ["LIST" "NON_NULL" "OBJECT"])
     :gql.list/object
     
     (= [kind of-type-kind]
        ["LIST" "OBJECT"])
     :gql.list/object

     (= [kind]
        ["OBJECT"])
     :gql/object
     
     :default
     :not-implemented
     )))

(defn get-field-type
  [field-type]
  (let [kind         (:kind field-type)
        type-name    (:name field-type)
        of-type-kind (:kind (:ofType field-type))
        of-type-name (:name (:ofType field-type))]
    (cond
      (= [kind of-type-kind
          (-> field-type :ofType :ofType :kind)
          (-> field-type :ofType :ofType :ofType :kind)]
         ["NON_NULL" "LIST" "NON_NULL" "OBJECT"])
      {:type :gql/object :name (-> field-type :ofType :ofType :ofType :name)}
      
      (= [kind of-type-kind (-> field-type :ofType :ofType :kind)]
         ["LIST" "NON_NULL" "OBJECT"])
      {:type :gql/object :name (-> field-type :ofType :ofType :name)}
      
      (= [kind of-type-kind]
         ["LIST" "OBJECT"])
      {:type :gql/object :name of-type-name}
      
      (= [kind]
         ["OBJECT"])
      {:type :gql/object :name type-name}

      (= [kind of-type-kind]
         ["NON_NULL" "OBJECT"])
      {:type :gql/object :name of-type-name}

      :default
      {:type :not-an-object})))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Generators for GQL types

(defn gen-fields
  [types type-name max-elements]
  ;;(println (str "type-name " type-name))
  (let [fields (:fields (first (filter #(= (:name %) type-name) types)))]
    ;;(println (str "Fields for type " fields))
    (gen/vector-distinct
     (gen/elements
      (:fields (first (filter #(= (:name %) type-name) types))))
     {:min-elements 1
      :max-elements max-elements
      })))

(defn resolve-arg-gen-alphanumeric
  [arg-type types]
  (let [kind         (:kind arg-type)
        type-name    (:name arg-type)
        of-type-kind (:kind (:ofType arg-type))
        of-type-name (:name (:ofType arg-type))]
   (cond
     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "String"])
     ;;gen/string
     gen/string-alphanumeric

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "Boolean"])
     gen/boolean

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "Int"])
     gen/large-integer

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "ID"])
     ;; CHANGE THIS TO GET INPUT VALIDATION BUG
     gen/string-alphanumeric
     ;;gen/string
     ;;(gen/return "root/test-project")
     ;;;;
     ;; Changes for small example errors
     ;;(gen/fmap (fn [id] (str id)) gen/small-integer)

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "Time"])
     :gql.scalar/non-null-time

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "Float"])
     :gql.scalar/non-null-float

     (= [kind type-name]
        ["SCALAR" "Boolean"])
     gen/boolean

     (= [kind type-name]
        ["SCALAR" "Int"])
     gen/large-integer

     (= [kind type-name]
        ["SCALAR" "Float"])
     :gql.scalar/float

     (= [kind type-name]
        ["SCALAR" "String"])
     ;;gen/string
     gen/string-alphanumeric

     (= [kind type-name]
        ["SCALAR" "Time"])
     gen/string

     (= [kind type-name]
        ["SCALAR" "ID"])
     ;;gen/string
     gen/string-alphanumeric

     (= [kind]
        ["ENUM"])
     (let [enum-type-name type-name
           enum-type      (first (filter #(= (:name %) enum-type-name) types))
           enums          (:enumValues enum-type)]
       (gen/elements (map #(symbol (:name %)) enums)))

     (= [kind of-type-kind]
        ["NON_NULL" "ENUM"])
     :gql/enum
     
     (= [kind of-type-kind]
        ["NON_NULL" "OBJECT"])
     :gql/object

     ;; TODO - might need a null collection
     (= [kind of-type-kind
         (-> arg-type :ofType :ofType :kind)
         (-> arg-type :ofType :ofType :ofType :kind)
         ]
        ["NON_NULL" "LIST" "NON_NULL" "OBJECT"])
     :gql.list/object

     (= [kind of-type-kind
         (-> arg-type :ofType :ofType :kind)
         (-> arg-type :ofType :ofType :ofType :kind)
         ]
        ["NON_NULL" "LIST" "NON_NULL" "ENUM"])
     :gql.list/enum

     (= [kind of-type-kind
         (-> arg-type :ofType :ofType :kind)
         (-> arg-type :ofType :ofType :ofType :kind)
         ]
        ["NON_NULL" "LIST" "NON_NULL" "SCALAR"])
     (condp = (-> arg-type :ofType :ofType :ofType :name)
       "String"
       :gql.list.scalar/non-null-string
       "ID"
       gen/string-alphanumeric)

     (= [kind of-type-kind
         (-> arg-type :ofType :ofType :kind) (-> arg-type :ofType :ofType :name)]
        ["LIST" "NON_NULL" "SCALAR" "ID"])
     ;;(gen/vector gen/string)
     ;;gen/string-alphanumeric
     ;;gen/string
     (gen/fmap (fn [id] (str "gid://abc/abc/" id)) gen/small-integer)

     ;; "gid://abc/abc/1"
     ;;(gen/generate (gen/fmap (fn [id] (str "gid://abc/abc/" id)) gen/small-integer))

     (= [kind of-type-kind
         (-> arg-type :ofType :ofType :kind) (-> arg-type :ofType :ofType :name)]
        ["LIST" "NON_NULL" "SCALAR" "String"])
     ;;gen/string
     gen/string-alphanumeric
     
     (= [kind of-type-kind]
        ["NON_NULL" "LIST"])
     (if-let [type-name (:name (:ofType arg-type))]
       :gql/list
       :bad-format-non-null-list)

     (= [kind of-type-kind (-> arg-type :ofType :ofType :kind)]
        ["LIST" "NON_NULL" "OBJECT"])
     :gql.list/object

     (= [kind of-type-kind (-> arg-type :ofType :ofType :kind)]
        ["LIST" "NON_NULL" "ENUM"])
     ;;(gen/vector gen/symbol)
     ;;(gen/vector gen/small-integer)
     (let [enum-type-name (-> arg-type :ofType :ofType :name)
           enum-type      (first (filter #(= (:name %) enum-type-name) types))
           enums          (:enumValues enum-type)]
       (gen/elements (map #(symbol (:name %)) enums)))
     
     
     (= [kind of-type-kind]
        ["LIST" "OBJECT"])
     :gql.list/object

     (= [kind of-type-kind of-type-name]
        ["LIST" "SCALAR" "String"])
     ;;(gen/vector gen/string)
     (gen/vector gen/string-alphanumeric)

     (= [kind]
        ["OBJECT"])
     :gql/object
     
     :default
     :not-implemented
     )))

(defn resolve-arg-gen-string
  [arg-type types]
  (let [kind         (:kind arg-type)
        type-name    (:name arg-type)
        of-type-kind (:kind (:ofType arg-type))
        of-type-name (:name (:ofType arg-type))]
   (cond
     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "String"])
     gen/string
     ;;gen/string-alphanumeric

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "Boolean"])
     ;;gen/boolean
     gen/string

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "Int"])
     ;;gen/large-integer
     gen/string

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "ID"])
     ;; CHANGE THIS TO GET INPUT VALIDATION BUG
     ;;gen/string-alphanumeric
     gen/string

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "Time"])
     :gql.scalar/non-null-time

     (= [kind of-type-kind of-type-name]
        ["NON_NULL" "SCALAR" "Float"])
     :gql.scalar/non-null-float

     (= [kind type-name]
        ["SCALAR" "Boolean"])
     ;;gen/boolean
     gen/string

     (= [kind type-name]
        ["SCALAR" "Int"])
     ;;gen/large-integer
     gen/string

     (= [kind type-name]
        ["SCALAR" "Float"])
     ;;:gql.scalar/float
     gen/string

     (= [kind type-name]
        ["SCALAR" "String"])
     gen/string
     ;;gen/string-alphanumeric

     (= [kind type-name]
        ["SCALAR" "Time"])
     gen/string

     (= [kind type-name]
        ["SCALAR" "ID"])
     gen/string
     ;;gen/string-alphanumeric

     (= [kind]
        ["ENUM"])
     (let [enum-type-name type-name
           enum-type      (first (filter #(= (:name %) enum-type-name) types))
           enums          (:enumValues enum-type)]
       (gen/elements (map #(symbol (:name %)) enums)))

     (= [kind of-type-kind]
        ["NON_NULL" "ENUM"])
     :gql/enum
     
     (= [kind of-type-kind]
        ["NON_NULL" "OBJECT"])
     :gql/object

     ;; TODO - might need a null collection
     (= [kind of-type-kind
         (-> arg-type :ofType :ofType :kind)
         (-> arg-type :ofType :ofType :ofType :kind)
         ]
        ["NON_NULL" "LIST" "NON_NULL" "OBJECT"])
     :gql.list/object

     (= [kind of-type-kind
         (-> arg-type :ofType :ofType :kind)
         (-> arg-type :ofType :ofType :ofType :kind)
         ]
        ["NON_NULL" "LIST" "NON_NULL" "ENUM"])
     :gql.list/enum

     (= [kind of-type-kind
         (-> arg-type :ofType :ofType :kind)
         (-> arg-type :ofType :ofType :ofType :kind)
         ]
        ["NON_NULL" "LIST" "NON_NULL" "SCALAR"])
     (condp = (-> arg-type :ofType :ofType :ofType :name)
       "String"
       :gql.list.scalar/non-null-string
       "ID"
       :gql.list.scalar/non-null-id)

     (= [kind of-type-kind
         (-> arg-type :ofType :ofType :kind) (-> arg-type :ofType :ofType :name)]
        ["LIST" "NON_NULL" "SCALAR" "ID"])
     ;;(gen/vector gen/string)
     ;;gen/string-alphanumeric
     ;;gen/string
     ;;(gen/fmap (fn [id] (str "gid://abc/abc/" id)) gen/small-integer)
     (gen/fmap (fn [id] (str "gid://abc/abc/" id)) gen/string)

     ;; "gid://abc/abc/1"
     ;;(gen/generate (gen/fmap (fn [id] (str "gid://abc/abc/" id)) gen/small-integer))

     (= [kind of-type-kind
         (-> arg-type :ofType :ofType :kind) (-> arg-type :ofType :ofType :name)]
        ["LIST" "NON_NULL" "SCALAR" "String"])
     gen/string
     ;;gen/string-alphanumeric
     
     (= [kind of-type-kind]
        ["NON_NULL" "LIST"])
     (if-let [type-name (:name (:ofType arg-type))]
       :gql/list
       :bad-format-non-null-list)

     (= [kind of-type-kind (-> arg-type :ofType :ofType :kind)]
        ["LIST" "NON_NULL" "OBJECT"])
     :gql.list/object

     (= [kind of-type-kind (-> arg-type :ofType :ofType :kind)]
        ["LIST" "NON_NULL" "ENUM"])
     ;;(gen/vector gen/symbol)
     ;;(gen/vector gen/small-integer)
     (let [enum-type-name (-> arg-type :ofType :ofType :name)
           enum-type      (first (filter #(= (:name %) enum-type-name) types))
           enums          (:enumValues enum-type)]
       (gen/elements (map #(symbol (:name %)) enums))
       ;;gen/string
       )
     
     
     (= [kind of-type-kind]
        ["LIST" "OBJECT"])
     :gql.list/object

     (= [kind of-type-kind of-type-name]
        ["LIST" "SCALAR" "String"])
     (gen/vector gen/string)
     ;;(gen/vector gen/string-alphanumeric)

     (= [kind]
        ["OBJECT"])
     :gql/object
     
     :default
     :not-implemented
     )))

(defn gen-args
  [args types size arg-gen-fn]
  (mapv
   (fn [arg]
     ;;(println arg)
     (let [arg-generator (arg-gen-fn (:type arg) types)]
      (assoc arg :value (gen/generate arg-generator size))))
   args))

(defn gen-gql-nodes
  [gql-type types max-elements arg-gen-fn]
  (gen/sized
   (fn [size]
     ;; (println size)
     ;; (println (str "type " gql-type))
     (reduce
      (fn [fields-gen generation]
        (gen/bind
         fields-gen
         (fn [generated-fields]
           ;;(println (str "Generated Fields " generated-fields))
           (let [new-fields
                 (reduce
                  (fn [acc field]
                    (if (and (=
                              ;;(:kind (:type field)) "OBJECT"
                              (:type (get-field-type (:type field))) :gql/object
                              )
                             (not (:fields field)))
                      (let [id           (java.util.UUID/randomUUID)
                            field-id     (java.util.UUID/randomUUID)
                            field-type   (get-field-type (:type field))
                            inner-fields (gen/generate
                                          (gen-fields
                                           types (:name field-type) max-elements)
                                          size)]
                        ;;(println (str "Inner fields " inner-fields))
                        (into
                         (conj
                          acc
                          (merge
                           field {:fields inner-fields :generation generation :id id
                                  :args   (gen-args
                                           (:args field) types size arg-gen-fn)}))
                         (mapv
                          #(assoc
                            (assoc % :field-id id)
                            :from-type (:name field-type))
                          inner-fields)))
                      (if (:generation field)
                        (conj acc field)
                        (conj acc
                              (if (seq (:args field))
                                (merge field {:generation generation
                                              :args
                                              (gen-args
                                               (:args field) types size arg-gen-fn)})
                                (assoc field :generation generation))))))
                  []
                  generated-fields)]
             (gen/return new-fields)))))
      (gen-fields types (:name gql-type) max-elements)
      (range (min (inc size) 100))))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Post processing

(defn make-tree
  [example]
  (let [nrof-generations (last (sort (map :generation example)))
        clean-nodes (filterv
                     #(not (and ;;(= (:kind (:type %)) "OBJECT")
                            (= (:type (get-field-type (:type %))) :gql/object) 
                            (not (contains? % :generation))))
                     example)]
    ;; (println (str "***** START *****"))
    ;; (println (str "CLEAN " clean-nodes))
    ;; (println (str "NROF Generations " nrof-generations))
    (filterv
     #(= (:generation %) 0)
     (reduce
      (fn [nodes generation]
        ;; (println (str "Generation " generation))
        (let [current-generation (filterv #(= generation (:generation %)) nodes)
              remaining (filterv #(not= generation (:generation %)) nodes)]
          ;; (println (str "Current generation " current-generation))
          ;; (println (str "remaining " remaining))
          (let [processed
                (mapv
                 (fn [node]
                   (let [node-fields
                         (filterv #(when (:id node)
                                     (= (:field-id %) (:id node))) nodes)]
                     (assoc node :fields node-fields)))
                 current-generation)]
            (into remaining ;;(filterv #(= (:type %) :object) processed)
                  processed
                  ))))
      clean-nodes
      (reverse (range (inc nrof-generations)))))))

(defn make-arg-string
  [arg]
  (let [value (:value arg)
        arg-str (if (string? value)
                  (str "\"" (:value arg) "\"")
                  (str (:value arg)))]
    (str "(" (:name arg) ": " arg-str  ")")))

(defn make-gql
  [gql-nodes]
  (conj
   (reduce
    (fn [query-str  gql-node]
      (if (and (:fields gql-node) (seq (:fields gql-node)))
        (conj
         (conj
          query-str
          (str (:name gql-node)
               (when (seq (:args gql-node))
                (let [arg (first (:args gql-node))]
                  (make-arg-string arg)))))
         (make-gql (:fields gql-node)) )
        (conj
         query-str
         (str (:name gql-node)
              (when (seq (:args gql-node))
                (let [arg (first (:args gql-node))]
                  (make-arg-string arg)))
              " "))))
    ["{"]
    gql-nodes)
   "}"))

(defn make-query
  [type-tree]
  (apply str
   (-> type-tree
       (make-tree)
       (make-gql)
       flatten)))

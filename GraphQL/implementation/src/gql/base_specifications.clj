(ns gql.base-specifications
  (:require [malli.core :as m]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Basic GQL type specifications

(def object-spec
  [:map
   [:kind [:enum "OBJECT"]]])

(def non-null-object-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "OBJECT"]]]]])

(def non-null-scalar-id-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "ID"]]]]])

(def non-null-scalar-string-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "String"]]]]])

(def non-null-scalar-boolean-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "Boolean"]]]]])

(def non-null-scalar-int-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "Int"]]]]])

(def non-null-scalar-time-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "Time"]]]]])

(def non-null-scalar-float-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "Float"]]]]])

(def non-null-enum-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "ENUM"]]]]])

(def scalar-string-spec
  [:map
   [:kind [:enum "SCALAR"]]
   [:name [:enum "String"]]])

(def scalar-id-spec
  [:map
   [:kind [:enum "SCALAR"]]
   [:name [:enum "ID"]]])

(def scalar-int-spec
  [:map
   [:kind [:enum "SCALAR"]]
   [:name [:enum "Int"]]])

(def scalar-float-spec
  [:map
   [:kind [:enum "SCALAR"]]
   [:name [:enum "Float"]]])

(def scalar-boolean-spec
  [:map
   [:kind [:enum "SCALAR"]]
   [:name [:enum "Boolean"]]])

(def scalar-time-spec
  [:map
   [:kind [:enum "SCALAR"]]
   [:name [:enum "Time"]]])

(def list-non-null-scalar-id-spec
  [:map
   [:kind [:enum "LIST"]]
   [:ofType
    [:map
     [:kind [:enum "NON_NULL"]]
     [:ofType
      [:map
       [:kind [:enum "SCALAR"]]
       [:name [:enum "ID"]]]]]]])

(def list-non-null-scalar-string-spec
  [:map
   [:kind [:enum "LIST"]]
   [:ofType
    [:map
     [:kind [:enum "NON_NULL"]]
     [:ofType
      [:map
       [:kind [:enum "SCALAR"]]
       [:name [:enum "String"]]]]]]])

(def list-non-null-enum-spec
  [:map
   [:kind [:enum "LIST"]]
   [:ofType
    [:map
     [:kind [:enum "NON_NULL"]]
     [:ofType
      [:map
       [:kind [:enum "ENUM"]]]]]]])

(def list-scalar-string-spec
  [:map
   [:kind [:enum "LIST"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "String"]]]]])

(def list-scalar-int-spec
  [:map
   [:kind [:enum "LIST"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "Int"]]]]])

(def list-scalar-float-spec
  [:map
   [:kind [:enum "LIST"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "Float"]]]]])

(def list-enum-spec
  [:map
   [:kind [:enum "LIST"]]
   [:ofType
    [:map
     [:kind [:enum "ENUM"]]]]])

(def list-object-spec
  [:map
   [:kind [:enum "LIST"]]
   [:ofType
    [:map
     [:kind [:enum "OBJECT"]]]]])

(def non-null-list-non-null-scalar-id-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "LIST"]]
     [:ofType
      [:map
       [:kind [:enum "NON_NULL"]]
       [:ofType
        [:map
         [:kind [:enum "SCALAR"]]
         [:name [:enum "ID"]]]]]]]]])

(def non-null-list-list-list-list-scalar-float
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "LIST"]]
     [:ofType
      [:map
       [:kind [:enum "LIST"]]
       [:ofType
        [:map
         [:kind [:enum "LIST"]]
         [:ofType
          [:map
           [:kind [:enum "LIST"]]
           [:ofType
            [:map
             [:kind [:enum "SCALAR"]]
             [:name [:enum "Float"]]]]]]]]]]]]])

(def non-null-list-non-null-object-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "LIST"]]
     [:ofType
      [:map
       [:kind [:enum "NON_NULL"]]
       [:ofType
        [:map
         [:kind [:enum "OBJECT"]]]]]]]]])

(def non-null-list-object-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "LIST"]]
     [:ofType
      [:map
       [:kind [:enum "OBJECT"]]]]]]])

(def non-null-list-non-null-scalar-string-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "LIST"]]
     [:ofType
      [:map
       [:kind [:enum "NON_NULL"]]
       [:ofType
        [:map
         [:kind [:enum "SCALAR"]]
         [:name [:enum "String"]]]]]]]]])

(def non-null-list-non-null-scalar-int-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "LIST"]]
     [:ofType
      [:map
       [:kind [:enum "NON_NULL"]]
       [:ofType
        [:map
         [:kind [:enum "SCALAR"]]
         [:name [:enum "Int"]]]]]]]]])

(def non-null-input-object-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "INPUT_OBJECT"]]]]])

(def enum-spec
  [:map
   [:kind [:enum "ENUM"]]])

(def union-spec
  [:map
   [:kind [:enum "UNION"]]])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Basic GQL generator specifications

(def gql-scalar-non-null-id string?)
(def gql-scalar-non-null-string [:string {:min 1}])
(def gql-scalar-non-null-boolean boolean?)
(def gql-scalar-non-null-time [:string {:min 1}])
(def gql-scalar-non-null-int int?)
(def gql-scalar-non-null-float float?)

(def gql-non-null-list-non-null-scalar-id [:vector {:min 1} [:string {:min 1}]])
(def gql-non-null-list-non-null-scalar-string [:vector {:min 1} [:string {:min 1}]])
(def gql-non-null-list-non-null-scalar-int [:vector {:min 1} int?])

(def gql-non-null-list-list-list-list-scalar-float
  [:vector {:min 1} [:vector {:min 1} [:vector {:min 1} [:vector {:min 1} float?]]]])

(def gql-scalar-string [:string])
(def gql-scalar-id [:string])
(def gql-scalar-int int?)
(def gql-scalar-boolean boolean?)
(def gql-scalar-float float?)
(def gql-scalar-time [:string])

(def gql-registry
  {:gql.scalar/non-null-id          gql-scalar-non-null-id
   :gql.scalar/non-null-string      gql-scalar-non-null-string
   :gql.scalar/non-null-boolean     gql-scalar-non-null-boolean
   :gql.scalar/non-null-time        gql-scalar-non-null-time
   :gql.scalar/non-null-int         gql-scalar-non-null-int
   :gql.scalar/non-null-float       gql-scalar-non-null-float
   :gql.scalar/string               gql-scalar-string
   :gql.scalar/id                   gql-scalar-id
   :gql.scalar/int                  gql-scalar-int
   :gql.scalar/boolean              gql-scalar-boolean
   :gql.scalar/float                gql-scalar-float
   :gql.scalar/time                 gql-scalar-time
   :gql.list.scalar/non-null-id     gql-non-null-list-non-null-scalar-id
   :gql.list.scalar/non-null-string gql-non-null-list-non-null-scalar-string
   :gql.list.scalar/non-null-int    gql-non-null-list-non-null-scalar-int

   :gql.list.list.list.list.scalar/float gql-non-null-list-list-list-list-scalar-float})

;;;;
;; Base GQL specification registry

(def base-registry
    (merge
     (m/class-schemas)
     (m/comparator-schemas)
     (m/base-schemas)
     (m/predicate-schemas)
     gql-registry))

(defn scalar?
  [node]
  (some #{node} (into #{} (keys gql-registry))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; API

(defn type->specification
  [input-type]
  (cond
    (m/validate non-null-scalar-id-spec input-type)
    :gql.scalar/non-null-id

    (m/validate non-null-scalar-string-spec input-type)
    :gql.scalar/non-null-string

    (m/validate non-null-scalar-boolean-spec input-type)
    :gql.scalar/non-null-boolean

    (m/validate non-null-scalar-int-spec input-type)
    :gql.scalar/non-null-int

    (m/validate non-null-scalar-time-spec input-type)
    :gql.scalar/non-null-time

    (m/validate non-null-scalar-float-spec input-type)
    :gql.scalar/non-null-float

    (m/validate list-non-null-scalar-id-spec input-type)
    :gql.list.scalar/non-null-id

    (m/validate list-non-null-scalar-string-spec input-type)
    :gql.list.scalar/non-null-string

    (m/validate list-scalar-string-spec input-type)
    :gql.list.scalar/non-null-string

    (m/validate list-scalar-int-spec input-type)
    :gql.list.scalar/non-null-int
    
    (m/validate non-null-list-non-null-scalar-id-spec input-type)
    :gql.list.scalar/non-null-id

    (m/validate non-null-list-non-null-scalar-string-spec input-type)
    :gql.list.scalar/non-null-string

    (m/validate non-null-list-non-null-scalar-int-spec input-type)
    :gql.list.scalar/non-null-int

    (m/validate scalar-string-spec input-type)
    :gql.scalar/string

    (m/validate scalar-int-spec input-type)
    :gql.scalar/int

    (m/validate scalar-id-spec input-type)
    :gql.scalar/id

    (m/validate scalar-boolean-spec input-type)
    :gql.scalar/boolean

    (m/validate scalar-float-spec input-type)
    :gql.scalar/float

    (m/validate scalar-time-spec input-type)
    :gql.scalar/time

    (m/validate non-null-input-object-spec input-type)
    (keyword "input-object" (get-in input-type [:ofType :name]))

    (m/validate enum-spec input-type)
    (keyword "enum" (:name input-type))

    (m/validate non-null-enum-spec input-type)
    (keyword "enum" (get-in input-type [:ofType :name]))

    (m/validate list-non-null-enum-spec input-type)
    [:vector {:min 1}
     (keyword "enum" (get-in input-type [:ofType :ofType :name]))]
    
    (m/validate object-spec input-type)
    [:ref (keyword "object" (:name input-type))]

    (m/validate non-null-object-spec input-type)
    [:ref (keyword "object" (get-in input-type [:ofType :name]))]

    (m/validate list-object-spec input-type)
    [:vector {:min 1}
     [:ref (keyword "object" (get-in input-type [:ofType :name]))]]

    (m/validate list-enum-spec input-type)
    [:vector {:min 1}
     (keyword "enum" (get-in input-type [:ofType :name]))]
    
    (m/validate non-null-list-object-spec input-type)
    [:vector {:min 1}
     [:ref (keyword "object" (get-in input-type [:ofType :ofType :name]))]]
    
    (m/validate non-null-list-non-null-object-spec input-type)
    [:vector {:min 1}
     [:ref (keyword "object" (get-in input-type [:ofType :ofType :ofType :name]))]]

    (m/validate non-null-list-list-list-list-scalar-float input-type)
    :gql.list.list.list.list.scalar/float

    (m/validate union-spec input-type)
    [:ref (keyword "union" (:name input-type))]
    
    ;; Custom Generators
    (m/validate
     [:map [:kind [:enum "SCALAR"]] [:name [:enum "FuzzyDateInt"]]]
     input-type)
    :gql.scalar/string

    (m/validate
     [:map [:kind [:enum "SCALAR"]] [:name [:enum "CountryCode"]]]
     input-type)
    :gql.scalar/string

    (m/validate
     [:map [:kind [:enum "SCALAR"]] [:name [:enum "Json"]]]
     input-type)
    :gql.scalar/string

    (m/validate
     [:map [:kind [:enum "LIST"]] [:ofType [:map [:kind [:enum "UNION"]]]]]
     input-type)
    [:vector {:min 1}
     [:ref (keyword "union" (get-in input-type [:ofType :name]))]]

    (m/validate
     [:map
      [:kind [:enum "LIST"]]
      [:ofType
       [:map
        [:kind [:enum "LIST"]]
        [:ofType
         [:map
          [:kind [:enum "OBJECT"]]]]]]]
     input-type)
    [:vector {:min 1}
     [:vector {:min 1}
      [:ref (keyword "object" (get-in input-type [:ofType :ofType :name]))]]]

    (m/validate list-scalar-float-spec input-type)
    [:vector {:min 1} float?]

    (m/validate
     [:map
      [:kind [:enum "NON_NULL"]]
      [:ofType
       [:map
        [:kind [:enum "LIST"]]
        [:ofType
         [:map
          [:kind [:enum "SCALAR"]]
          [:name [:enum "Int"]]]]]]]
     input-type)
    [:vector {:min 1} int?]
    
    :else
    input-type))



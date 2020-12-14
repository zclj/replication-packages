(ns gql.base-specifications-test
  (:require [gql.base-specifications :as sut]
            [clojure.test :refer [deftest testing is]]))

(deftest type-to-specification
  (testing "No match return input"
    (is (= "stuff"
           (sut/type->specification "stuff"))))
  
  (testing "Scalar Types"
    (is (= :gql.scalar/non-null-id
           (sut/type->specification
            {:kind   "NON_NULL"
             :ofType {:kind "SCALAR"
                      :name "ID"}})))
    (is (= :gql.scalar/non-null-string
           (sut/type->specification
            {:kind   "NON_NULL"
             :ofType {:kind "SCALAR"
                      :name "String"}})))
    (is (= :gql.scalar/non-null-boolean
           (sut/type->specification
            {:kind   "NON_NULL"
             :ofType {:kind "SCALAR"
                      :name "Boolean"}})))
    (is (= :gql.scalar/non-null-int
           (sut/type->specification
            {:kind   "NON_NULL"
             :ofType {:kind "SCALAR"
                      :name "Int"}})))
    (is (= :gql.scalar/non-null-time
           (sut/type->specification
            {:kind   "NON_NULL"
             :ofType {:kind "SCALAR"
                      :name "Time"}})))
    (is (= :gql.scalar/non-null-float
           (sut/type->specification
            {:kind   "NON_NULL"
             :ofType {:kind "SCALAR"
                      :name "Float"}})))
    (is (= :gql.scalar/string
           (sut/type->specification
            {:kind "SCALAR"
             :name "String"})))
    (is (= :gql.scalar/int
           (sut/type->specification
            {:kind "SCALAR"
             :name "Int"})))
    (is (= :gql.scalar/id
           (sut/type->specification
            {:kind "SCALAR"
             :name "ID"})))
    (is (= :gql.scalar/boolean
           (sut/type->specification
            {:kind "SCALAR"
             :name "Boolean"})))
    (is (= :gql.scalar/float
           (sut/type->specification
            {:kind "SCALAR"
             :name "Float"})))
    (is (= :gql.scalar/time
           (sut/type->specification
            {:kind "SCALAR"
             :name "Time"}))))

  (testing "List Types"
    (is (= :gql.list.scalar/non-null-id
           (sut/type->specification
            {:kind "LIST",
             :ofType
             {:kind   "NON_NULL",
              :ofType {:kind "SCALAR", :name "ID", :ofType nil}}})))
    (is (= [:vector {:min 1} :enum/TodoActionEnum]
           (sut/type->specification
            {:kind "LIST",
             :name nil,
             :ofType
             {:kind   "NON_NULL",
              :name   nil,
              :ofType {:kind "ENUM", :name "TodoActionEnum", :ofType nil}}})))
    (is (= [:vector {:min 1} [:ref :object/UserEdge]]
           (sut/type->specification
            {:kind   "LIST",
             :name   nil,
             :ofType {:kind "OBJECT", :name "UserEdge", :ofType nil}})))
    (is (= :gql.list.scalar/non-null-string
           (sut/type->specification
            {:kind "LIST",
             :name nil,
             :ofType
             {:kind   "NON_NULL",
              :name   nil,
              :ofType {:kind "SCALAR", :name "String", :ofType nil}}})))
    (is (= :gql.list.scalar/non-null-string
           (sut/type->specification
            {:kind   "LIST",
             :name   nil,
             :ofType {:kind "SCALAR", :name "String", :ofType nil}})))

    (testing "Union Types"
      (is (= [:or
              [:ref :object/TextActivity]
              [:ref :object/ListActivity]
              [:ref :object/MessageActivity]]
             (sut/type->specification
              {:kind        "UNION",
               :name        "ActivityUnion",
               :description "Activity union type",
               :fields      nil,
               :inputFields nil,
               :interfaces  nil,
               :enumValues  nil,
               :possibleTypes
               [{:kind "OBJECT", :name "TextActivity", :ofType nil}
                {:kind "OBJECT", :name "ListActivity", :ofType nil}
                {:kind "OBJECT", :name "MessageActivity", :ofType nil}]}))))))

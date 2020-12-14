(ns gql.schema-utils
  (:require [clojure.string :as s]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; GraphQL utils

(defn find-type
  [schema type-name]
  (first (filter #(= (:name %) type-name) (:types schema))))

(defn filter-meta-types
  [schema]
  (filter (fn [s] (not (s/starts-with? (:name s) "__"))) schema))

(defn find-enums
  [schema]
  (filter (fn [s] (= "ENUM" (:kind s))) schema))

(defn find-input-types
  [schema]
  (filter (fn [s] (= "INPUT_OBJECT" (:kind s))) schema))

(defn find-object-types
  [schema]
  (filter (fn [s] (= "OBJECT" (:kind s))) schema))

(defn find-union-types
  [schema]
  (filter (fn [s] (= "UNION" (:kind s))) schema))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Specification -> GraphQL String

(defn make-arg-string
    [arg]
    (s/replace
     (apply
      str
      (conj
       (reduce
        (fn [acc [arg-name arg-value]] 
          (conj
           acc
           (let [arg-str (if (string? arg-value)
                           (str "\"" arg-value "\"")
                           (str arg-value))]
             (str arg-name ": " arg-str ", "))))
        ["("]
        arg)
       ")"))
     ", )"
     ")"))

(defn make-fields
  [acc node-name fields]
  ;; empty fields means node should not be included
  (if (seq fields)
    (conj acc [node-name (conj (into [" { "] fields) "} ")])
    acc))

(defn make-gql
   [gql-nodes]
   (reduce
    (fn [acc gql-node]
      (let [node-name      (first gql-node)
            node-value     (second gql-node)
            node-type      (:type node-value)
            node-args      (:args node-value)
            node-with-args (if node-args
                             (str node-name (make-arg-string node-args))
                             node-name)]
        ;; value can be vector
        (if (vector? node-type)
          (let [fields (mapcat (fn [field] (make-gql (:fields field))) node-type)]
            ;; vector fields could be empty if only object wo fields
            (make-fields acc node-with-args fields))
          ;; not vector
          (if (= node-value :scalar)
            (conj acc (str node-name " "))
            (let [field (make-gql (:fields node-type))]
              (make-fields acc node-with-args field))))))
    []
    gql-nodes))

(defn make-gql-string
  [gql-node]
  (str "{"
       (apply str
              (-> gql-node
                  make-gql
                  flatten))
       "}"))

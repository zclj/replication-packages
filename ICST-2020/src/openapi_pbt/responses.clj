(ns openapi-pbt.responses
  (:require [clojure.spec.alpha :as s]))

(defn response-to-spec
  [response]
  (when (and (= (get-in response [:schema :type]) "array")
             (get-in response [:schema :items :$ref]))
    (let [object-name (name (:spec response))]
      `(s/def ~(:spec response) (s/coll-of ~(keyword "definitions" object-name))))))

(defn responses-to-specs
  [responses]
  (distinct
   (reduce-kv
    (fn [acc k r]
      (if-let [spec (response-to-spec r)]
        (cons spec acc)
        acc))
    []
    responses)))

(defn paths-items-to-specs
  [paths]
  (let [param-specs (mapcat #(responses-to-specs %) (map :parameters paths))
        resps-specs (mapcat #(responses-to-specs %) (map :responses paths))]
   (distinct (concat param-specs resps-specs))))


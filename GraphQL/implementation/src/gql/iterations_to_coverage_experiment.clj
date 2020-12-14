(ns gql.iterations-to-coverage-experiment
  (:require [gql.gitlab-experiment :as exp]))

;; Iterate until accumulated coverage is 100%

(def until-coverage-db (atom []))

(defn run-until-coverage-experiment
  [iterations max-n size max-elements]
  (let [all-iterations
        (reduce
         (fn [acc _]
           (conj acc (exp/run-until-coverage max-n size max-elements)))
         []
         (range 0 iterations))]
    (double (/ (reduce + (map :iterations all-iterations)) (count all-iterations)))))


(run-until-coverage-experiment 30 100 100 1)
;; => 100.0

(run-until-coverage-experiment 30 100 100 2)
;; => 100.0

(run-until-coverage-experiment 30 100 100 3)
;; => 61.43333333333333

(run-until-coverage-experiment 30 100 100 4)
;; => 18.0

(run-until-coverage-experiment 30 100 1000 1)
;; => 100.0

(run-until-coverage-experiment 30 30 1000 2)
;; => 26.63333333333333

(run-until-coverage-experiment 30 30 1000 3)
;; => 6.566666666666667

(run-until-coverage-experiment 30 30 1000 4)
;; => 2.2

(run-until-coverage-experiment 30 30 10000 1)
;; => 26.0

(run-until-coverage-experiment 30 30 10000 2)
;; => 3.766666666666667

(run-until-coverage-experiment 30 30 10000 3)
;; => 1.133333333333333

(run-until-coverage-experiment 30 30 10000 4)
;; => 1.0

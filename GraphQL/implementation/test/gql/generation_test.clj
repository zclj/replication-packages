(ns gql.generation-test
  (:require [gql.generation :as sut]
            [clojure.test :refer [deftest testing is]]))

(deftest stuff
  (is (= 3
         (sut/stuff 2)))
  )


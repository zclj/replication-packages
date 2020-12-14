(ns gql.coverage-experiments
  (:require [gql.gitlab-experiment :as exp]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Coverage Experiments

 ;; coverage of generation size 10, field max 1

(time
 (exp/run-range-of-generations 30 10 1))
;; "Elapsed time: 25.542336 msecs"
;; => {:iterations 30, :avg-coverage 3.1824417009602195, :compounded-coverage 20.5761316872428}

 ;; coverage of generation size 100, field max 1
(time
 (exp/run-range-of-generations 30 100 1))
;; "Elapsed time: 620.049025 msecs"
;; => {:iterations 30, :avg-coverage 14.046639231824415, :compounded-coverage 49.58847736625514}

 ;; coverage of generation size 1000, field max 1
(time
 (exp/run-range-of-generations 30 1000 1))
;; "Elapsed time: 9118.185122 msecs"
;; => {:iterations 30, :avg-coverage 36.94787379972564, :compounded-coverage 87.24279835390946}

 ;; coverage of generation size 10000, field max 1
(time
 (exp/run-range-of-generations 30 10000 1))
;; "Elapsed time: 94829.619056 msecs"
;; => {:iterations 30, :avg-coverage 73.33333333333333, :compounded-coverage 100.0}

;;;;
;; field max 2

;; coverage of generation size 10, field max 2
(time
 (exp/run-range-of-generations 30 10 2))
;; "Elapsed time: 43.129638 msecs"
;; => {:iterations 30, :avg-coverage 6.556927297668039, :compounded-coverage 38.88888888888889}

;; coverage of generation size 100, field max 2
(time
 (exp/run-range-of-generations 30 100 2))
;; "Elapsed time: 1259.775175 msecs"
;; => {:iterations 30, :avg-coverage 28.936899862825786, :compounded-coverage 85.59670781893004}

;; coverage of generation size 1000, field max 2
(time
 (exp/run-range-of-generations 30 1000 2))
;; "Elapsed time: 19324.148403 msecs"
;; => {:iterations 30, :avg-coverage 64.86968449931413, :compounded-coverage 100.0}

;; coverage of generation size 10000, field max 2
(time
 (exp/run-range-of-generations 30 10000 2))
;; "Elapsed time: 199650.281413 msecs"
;; => {:iterations 30, :avg-coverage 97.95610425240056, :compounded-coverage 100.0}

;;;;
;; field max 3

;; coverage of generation size 10, field max 3
(time
 (exp/run-range-of-generations 30 10 3))
;; "Elapsed time: 65.253129 msecs"
;; => {:iterations 30, :avg-coverage 11.995884773662551, :compounded-coverage 54.93827160493827}

;; coverage of generation size 100, field max 3
(time
 (exp/run-range-of-generations 30 100 3))
;; "Elapsed time: 2552.918511 msecs"
;; => {:iterations 30, :avg-coverage 49.08093278463649, :compounded-coverage 99.58847736625513}

;; coverage of generation size 1000, field max 3
(time
 (exp/run-range-of-generations 30 1000 3))
;; "Elapsed time: 40972.678678 msecs"
;; => {:iterations 30, :avg-coverage 90.62414266117969, :compounded-coverage 100.0}

;; coverage of generation size 10000, field max 3
(time
 (exp/run-range-of-generations 30 10000 3))
;; "Elapsed time: 416308.794242 msecs"
;; => {:iterations 30, :avg-coverage 100.0, :compounded-coverage 100.0}


;;;;
;; field max 4

;; coverage of generation size 10, field max 4
(time
 (exp/run-range-of-generations 30 10 4))
;; "Elapsed time: 109.750862 msecs"
;; => {:iterations 30, :avg-coverage 20.85733882030178, :compounded-coverage 77.1604938271605}

;; coverage of generation size 100, field max 4
(time
 (exp/run-range-of-generations 30 100 4))
;; "Elapsed time: 5728.749997 msecs"
;; => {:iterations 30, :avg-coverage 71.50891632373111, :compounded-coverage 99.79423868312757}

;; coverage of generation size 1000, field max 4
(time
 (exp/run-range-of-generations 30 1000 4))
;; "Elapsed time: 93570.367599 msecs"
;; => {:iterations 30, :avg-coverage 99.29355281207131, :compounded-coverage 100.0}

;; coverage of generation size 10000, field max 4
(time
 (exp/run-range-of-generations 30 10000 4))
;; "Elapsed time: 931626.357889 msecs"
;; => {:iterations 30, :avg-coverage 100.0, :compounded-coverage 100.0}

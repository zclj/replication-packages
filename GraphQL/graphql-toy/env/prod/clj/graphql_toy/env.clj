(ns graphql-toy.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[graphql-toy started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[graphql-toy has shut down successfully]=-"))
   :middleware identity})

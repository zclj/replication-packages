(ns graphql-toy.env
  (:require
    [selmer.parser :as parser]
    [clojure.tools.logging :as log]
    [graphql-toy.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[graphql-toy started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[graphql-toy has shut down successfully]=-"))
   :middleware wrap-dev})

(ns graphql-toy.routes.services.graphql
  (:require
    [com.walmartlabs.lacinia.util :refer [attach-resolvers]]
    [com.walmartlabs.lacinia.schema :as schema]
    [com.walmartlabs.lacinia :as lacinia]
    [clojure.data.json :as json]
    [clojure.edn :as edn]
    [clojure.java.io :as io]
    [ring.util.http-response :refer :all]
    [mount.core :refer [defstate]]))

(def db
  {:projects
   [{:id          "1"
     :name        "Project 1"
     :description "Awesome project!"
     :owner       "100"
     :members     #{"100" "200"}}
    {:id          "2"
     ;; DB error vector instead of scalar
     :name        "Project 2"
     :description "Not an awesome project!"
     :owner       "200"
     :members     #{"200"}}]

   :users
   [{:id       "100"
     :name     "Burt"
     :age      23
     :projects #{"1" "2"}}

    {:id       "200"
     :name     "Earnie"
     :age      32
     :projects #{"2"}}]})

(defn resolve-project-by-id
  [projects context args value]
  (let [{:keys [id]} args]
    ;; Example bug 1 - Syntax misstake 
    ;; (first (filter #(= (:id %) id)) projects)

    ;; Example bug 2 - Give "foo", input validation
    ;; (nth projects (Integer/parseInt id))
    
    ;; Example bug 3 - Input type validation bug
    ;; (nth projects id)

    ;; Example bug 4 - Using the wrong field
    ;; (first (filter #(= (:name %) id) projects))

    ;; Example bug 5 - wrong type "error"
    ;; (assoc (first (filter #(= (:id %) id) projects)) :name [:a :b])

    ;; Example bug 6 - IndexOutOfBounds
    ;;(nth projects (Integer/parseInt id))
    
    ;; Correct implementation
    (first (filter #(= (:id %) id) projects))
    ))

(defn resolve-project-owner
  [users context args project]
  (let [owner (:owner project)]
    
    ;; Example bug 1 - Syntax misstake 
    ;;(first (filter #(= (:id %) owner)) users)

    ;; Example bug 2 - Using the wrong field
    ;; (first (filter #(= (:name %) owner) project))

    ;; Example bug 3 - wrong type "error"
    ;;(assoc (first (filter #(= (:id %) owner) project)) :name [:a :b])
    
    ;; Correct implementation
    (first (filter #(= (:id %) owner) users))
    ))

(defn resolve-project-members
  [users context args project]
  (let [members (:members project)]
    ;; Example bug 1 - logic error
    ;; (filter #(contains? members) users)

    ;; Example bug 2 - Using the wrong field
    ;; (filter #(contains? members (:name %)) users)

    ;; Example bug 3 - wrong type "errors"
    ;;(filter #(contains? members (:id %)))
    
    ;; Correct implementation
    (filter #(contains? members (:id %)) users)
    ))

(defn resolve-user-projects
  [projects context args user]
  (let [user-projects (:projects user)]
    ;; Example bug 1 - Syntax Error
    ;; (filter #(contains? user-projects) projects)

    ;; Example bug 2 - Using the wrong field
    ;; (filter #(contains? user-projects (:name %)) projects)

    ;; Example bug 3 - wrong type "errors"
    ;; (filter #(contains? user-projects (:id %)))
    
    ;; Correct implementation
    (filter #(contains? user-projects (:id %)) projects)
    ))

(defstate compiled-schema
  :start
  (-> "graphql/schema.edn"
      io/resource
      slurp
      edn/read-string
      (attach-resolvers
       {:query/project   (partial resolve-project-by-id (:projects db))
        :user/projects   (partial resolve-user-projects (:projects db))
        :project/members (partial resolve-project-members (:users db))
        :project/owner   (partial resolve-project-owner (:users db))})
      schema/compile))

(defn format-params [query]
   (let [parsed (json/read-str query)] ;;-> placeholder - need to ensure query meets graphql syntax
     (str "query { hero(id: \"1000\") { name appears_in }}")))

(defn execute-request [query]
    (let [vars nil
          context nil]
    (-> (lacinia/execute compiled-schema query vars context)
        (json/write-str))))

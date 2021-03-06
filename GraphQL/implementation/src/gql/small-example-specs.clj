;;;; Serene
;;; com.paren/serene
;;; https://github.com/paren-com/serene
;;; Generate clojure.spec with GraphQL and extend GraphQL with clojure.spec
;;;
;;; DO NOT EDIT THIS FILE!

(ns gql.small-example-specs (:require [clojure.core] [clojure.spec.alpha]))

(clojure.spec.alpha/def :gql.small-example-specs.QueryRoot/projects
  (clojure.spec.alpha/nilable :gql.small-example-specs/Project))

(clojure.spec.alpha/def :gql.small-example-specs/ID clojure.core/string?)

(clojure.spec.alpha/def :gql.small-example-specs.User.name/&args
  (clojure.spec.alpha/keys :opt-un [] :req-un []))

(clojure.spec.alpha/def :gql.small-example-specs.User.__typename/&args
  (clojure.spec.alpha/keys :opt-un [] :req-un []))

(clojure.spec.alpha/def :gql.small-example-specs.QueryRoot/__typename #{"QueryRoot"})

(clojure.spec.alpha/def :gql.small-example-specs.Project.description/&args
  (clojure.spec.alpha/keys :opt-un [] :req-un []))

(clojure.spec.alpha/def :gql.small-example-specs.Project.members/&args
  (clojure.spec.alpha/keys :opt-un [] :req-un []))

(clojure.spec.alpha/def :gql.small-example-specs.Project/owner
  (clojure.spec.alpha/nilable :gql.small-example-specs/User))

(clojure.spec.alpha/def :gql.small-example-specs.Project.id/&args
  (clojure.spec.alpha/keys :opt-un [] :req-un []))

(clojure.spec.alpha/def :gql.small-example-specs.User/projects
  (clojure.spec.alpha/nilable
   (clojure.spec.alpha/coll-of
    (clojure.spec.alpha/nilable :gql.small-example-specs/Project)
    :kind
    clojure.core/sequential?)))

(clojure.spec.alpha/def :gql.small-example-specs.Project/members
  (clojure.spec.alpha/nilable
   (clojure.spec.alpha/coll-of
    (clojure.spec.alpha/nilable :gql.small-example-specs/User)
    :kind
    clojure.core/sequential?)))

(clojure.spec.alpha/def :gql.small-example-specs.QueryRoot.__typename/&args
  (clojure.spec.alpha/keys :opt-un [] :req-un []))

(clojure.spec.alpha/def :gql.small-example-specs.status/COMPLETED #{"COMPLETED"})

(clojure.spec.alpha/def :gql.small-example-specs.Project/description
  (clojure.spec.alpha/nilable :gql.small-example-specs/String))

(clojure.spec.alpha/def :gql.small-example-specs.User/__typename #{"User"})

(clojure.spec.alpha/def :gql.small-example-specs.User/age
  (clojure.spec.alpha/nilable :gql.small-example-specs/Int))

(clojure.spec.alpha/def :gql.small-example-specs/Boolean clojure.core/boolean?)

(clojure.spec.alpha/def :gql.small-example-specs.User.id/&args
  (clojure.spec.alpha/keys :opt-un [] :req-un []))

(clojure.spec.alpha/def :gql.small-example-specs.Project.owner/&args
  (clojure.spec.alpha/keys :opt-un [] :req-un []))

(clojure.spec.alpha/def :gql.small-example-specs/User
  (clojure.spec.alpha/keys
   :opt-un
   [:gql.small-example-specs.User/age
    :gql.small-example-specs.User/id
    :gql.small-example-specs.User/name
    :gql.small-example-specs.User/projects
    :gql.small-example-specs.User/__typename]))

(clojure.spec.alpha/def :gql.small-example-specs.User/name
  (clojure.spec.alpha/nilable :gql.small-example-specs/String))

(clojure.spec.alpha/def :gql.small-example-specs.User.projects/&args
  (clojure.spec.alpha/keys :opt-un [] :req-un []))

(clojure.spec.alpha/def :gql.small-example-specs.Project/__typename #{"Project"})

(clojure.spec.alpha/def :gql.small-example-specs/status
  (clojure.spec.alpha/nonconforming
   (clojure.spec.alpha/or
    :status/COMPLETED
    :gql.small-example-specs.status/COMPLETED
    :status/STARTED
    :gql.small-example-specs.status/STARTED)))

(clojure.spec.alpha/def :gql.small-example-specs/Int clojure.core/integer?)

(clojure.spec.alpha/def :gql.small-example-specs.QueryRoot.projects/&args
  (clojure.spec.alpha/keys :opt-un [] :req-un [:gql.small-example-specs.QueryRoot.projects/id]))

(clojure.spec.alpha/def :gql.small-example-specs/Float clojure.core/float?)

(clojure.spec.alpha/def :gql.small-example-specs/Project
  (clojure.spec.alpha/keys
   :opt-un
   [:gql.small-example-specs.Project/description
    :gql.small-example-specs.Project/id
    :gql.small-example-specs.Project/members
    :gql.small-example-specs.Project/name
    :gql.small-example-specs.Project/owner
    :gql.small-example-specs.Project/__typename]))

(clojure.spec.alpha/def :gql.small-example-specs/String clojure.core/string?)

(clojure.spec.alpha/def :gql.small-example-specs.Project/name
  (clojure.spec.alpha/nilable :gql.small-example-specs/String))

(clojure.spec.alpha/def :gql.small-example-specs.Project.name/&args
  (clojure.spec.alpha/keys :opt-un [] :req-un []))

(clojure.spec.alpha/def :gql.small-example-specs.status/STARTED #{"STARTED"})

(clojure.spec.alpha/def :gql.small-example-specs.Project.__typename/&args
  (clojure.spec.alpha/keys :opt-un [] :req-un []))

(clojure.spec.alpha/def :gql.small-example-specs/QueryRoot
  (clojure.spec.alpha/keys
   :opt-un
   [:gql.small-example-specs.QueryRoot/projects :gql.small-example-specs.QueryRoot/__typename]))

(clojure.spec.alpha/def :gql.small-example-specs.User/id
  (clojure.spec.alpha/nilable :gql.small-example-specs/ID))

(clojure.spec.alpha/def :gql.small-example-specs.User.age/&args
  (clojure.spec.alpha/keys :opt-un [] :req-un []))

(clojure.spec.alpha/def :gql.small-example-specs.Project/id :gql.small-example-specs/ID)

(clojure.spec.alpha/def :gql.small-example-specs.QueryRoot.projects/id :gql.small-example-specs/ID)

(ns gql.mutations
  (:require
   [clojure.test.check.generators :as gen]
   [gql.generators :as gqlgen]
   [gql.query-data :as data]
   [malli.core :as m]
   [malli.generator :as mg]
   [clojure.data.json :as json]
   [org.httpkit.client :as http]
   [clojure.test.check.properties :as prop]))

(def token "ZaBpdrqzpzcmbdEzd1kB")

(def results-db (atom []))
(def queries (atom []))

(defn run-query
  [query-str]
  (let [response @(http/request {:url          "http://localhost/api/graphql"
                                 :method       :post
                                 :headers      {"PRIVATE-TOKEN" token}
                                 :content-type "application/json"
                                 :form-params  {"query" query-str}})]
    {:body (json/read-str (:body response) :key-fn keyword)
     :status-code (:status response)}))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Mutations

(defn make-query-of-nodes
  []
  (let [schema (-> gql.query-data/gitlab-schema :data :__schema :types)
        mutation-type (first (filter #(= (:name %) "Mutation") schema))
        nodes (gqlgen/gen-gql-nodes
               mutation-type schema 5
               gqlgen/resolve-arg-gen-alphanumeric)]
    ;;(map gqlgen/make-query (gen/sample nodes 100))
    nodes
    ))

(defn gen-fields
  [types type-name max-elements]
  ;;(println (str "type-name " type-name))
  (let [fields (:fields (first (filter #(= (:name %) type-name) types)))]
    ;;(println (str "Fields for type " fields))
    (gen/vector-distinct
     (gen/elements fields)
     {:min-elements 1
      :max-elements max-elements
      })))

(defn the-argument-generator
  [arg-type]
  (let [kind         (:kind arg-type)
        type-name    (:name arg-type)
        of-type-kind (:kind (:ofType arg-type))
        of-type-name (:name (:ofType arg-type))]
    ;;(println arg-type)
    (cond
      (= [kind of-type-kind]
         ["NON_NULL" "INPUT_OBJECT"])
      (keyword "input-object" of-type-name)
      :else
      :not-implemented)))

(def non-null-scalar-id-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "ID"]]]]])

(def non-null-scalar-string-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "String"]]]]])

(def non-null-scalar-boolean-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "Boolean"]]]]])

(def non-null-scalar-int-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "Int"]]]]])

(def non-null-scalar-time-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "SCALAR"]]
     [:name [:enum "Time"]]]]])

(def non-null-enum-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "ENUM"]]]]])

(def scalar-string-spec
  [:map
   [:kind [:enum "SCALAR"]]
   [:name [:enum "String"]]])

(def scalar-id-spec
  [:map
   [:kind [:enum "SCALAR"]]
   [:name [:enum "ID"]]])

(def scalar-int-spec
  [:map
   [:kind [:enum "SCALAR"]]
   [:name [:enum "Int"]]])

(def non-null-list-non-null-scalar-id-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "LIST"]]
     [:ofType
      [:map
       [:kind [:enum "NON_NULL"]]
       [:ofType
        [:map
         [:kind [:enum "SCALAR"]]
         [:name [:enum "ID"]]]]]]]]])

(def non-null-list-non-null-scalar-string-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "LIST"]]
     [:ofType
      [:map
       [:kind [:enum "NON_NULL"]]
       [:ofType
        [:map
         [:kind [:enum "SCALAR"]]
         [:name [:enum "String"]]]]]]]]])

(def non-null-input-object-spec
  [:map
   [:kind [:enum "NON_NULL"]]
   [:ofType
    [:map
     [:kind [:enum "INPUT_OBJECT"]]]]])

(def enum-spec
  [:map
   [:kind [:enum "ENUM"]]])


(def gql-scalar-non-null-id [:enum "gid://gitlab/Issue/1"];;string?
  )
(def gql-scalar-non-null-string [:string {:min 1}])
(def gql-scalar-non-null-boolean boolean?)
(def gql-scalar-non-null-time [:string {:min 1}])
(def gql-scalar-non-null-int int?)

(def gql-non-null-list-non-null-scalar-id [:vector {:min 1} [:string {:min 1}]])
(def gql-non-null-list-non-null-scalar-string [:vector {:min 1} [:string {:min 1}]])

(def gql-scalar-string [:string])
(def gql-scalar-id [:string])
(def gql-scalar-int int?)

(comment
  (mg/generate gql-non-null-list-non-null-scalar-id)
  )

(def gql-registry
  {:gql.scalar/non-null-id          gql-scalar-non-null-id
   :gql.scalar/non-null-string      gql-scalar-non-null-string
   :gql.scalar/non-null-boolean     gql-scalar-non-null-boolean
   :gql.scalar/non-null-time        gql-scalar-non-null-time
   :gql.scalar/non-null-int         gql-scalar-non-null-int
   :gql.scalar/string               gql-scalar-string
   :gql.scalar/id                   gql-scalar-id
   :gql.scalar/int                  gql-scalar-int
   :gql.list.scalar/non-null-id     gql-non-null-list-non-null-scalar-id
   :gql.list.scalar/non-null-string gql-non-null-list-non-null-scalar-string})

(def the-registry
    (merge
     (m/class-schemas)
     (m/comparator-schemas)
     (m/base-schemas)
     (m/predicate-schemas)
     gql-registry))

(defn input-field-generator
  [input-type]
  (cond
    (m/validate non-null-scalar-id-spec input-type)
    :gql.scalar/non-null-id

    (m/validate non-null-scalar-string-spec input-type)
    :gql.scalar/non-null-string

    (m/validate non-null-scalar-boolean-spec input-type)
    :gql.scalar/non-null-boolean

    (m/validate non-null-scalar-int-spec input-type)
    :gql.scalar/non-null-int

    (m/validate non-null-scalar-time-spec input-type)
    :gql.scalar/non-null-time

    (m/validate non-null-list-non-null-scalar-id-spec input-type)
    :gql.list.scalar/non-null-id

    (m/validate non-null-list-non-null-scalar-string-spec input-type)
    :gql.list.scalar/non-null-string

    (m/validate scalar-string-spec input-type)
    :gql.scalar/string

    (m/validate scalar-int-spec input-type)
    :gql.scalar/int

    (m/validate scalar-id-spec input-type)
    :gql.scalar/id

    (m/validate non-null-input-object-spec input-type)
    (keyword "input-object" (get-in input-type [:ofType :name]))

    (m/validate enum-spec input-type)
    (keyword "enum" (:name input-type))

    (m/validate non-null-enum-spec input-type)
    (keyword "enum" (get-in input-type [:ofType :name]))
    
    :else
    input-type))

(comment
  (map (fn [y] (map #(input-field-generator (:type %)) y))
       (map (fn [x] (get x :inputFields))
            (filter (fn [s] (:inputFields s)) schema))))

(defn gen-args-old
  [args types size arg-gen-fn]
  (mapv
   (fn [arg]
     ;;(println arg)
     (let [arg-generator (arg-gen-fn (:type arg) types)]
      (assoc arg :value (gen/generate arg-generator size))))
   args))

(defn gen-args
  [args types size arg-gen-fn]
  (mapv
   (fn [arg]
     ;;(println arg)
     (let [arg-generator (arg-gen-fn (:type arg) types)]
      (assoc arg :value arg-generator)))
   args))

(defn gen-mutation-node
  [node]
  (let [args      (:args node)
        node-name (:name node)
        arg-specs (mapv #(input-field-generator (:type %)) args)]
    [:map (into [node-name] arg-specs)]))

(defn enum->spec
  [enum-type]
  (let [enum-values (mapv :name (:enumValues enum-type))]
    (into [:enum] enum-values)))

(defn enum-node->map
  [enum-type]
  {(keyword "enum" (:name enum-type)) (enum->spec enum-type)})

(defn filter-meta-types
  [schema]
  (filter (fn [s] (not (clojure.string/starts-with? (:name s) "__"))) schema))

(defn find-enums
  [schema]
  (filter (fn [s] (= "ENUM" (:kind s))) schema))

(defn find-input-types
  [schema]
  (filter (fn [s] (= "INPUT_OBJECT" (:kind s))) schema))

(defn input-object-node->map
  [input-type]
  (let [input-fields
        (mapv
         (fn [field] [(:name field) (input-field-generator (:type field))])
         (:inputFields input-type))]
    {(keyword "input-object" (:name input-type))
     (into [:map] input-fields)}))

;; 1. Make a registry of the Mutation Types

;; x. Make a registry of input types
(defn schema-input-objects->maps-with-specs
  [schema]
  (map input-object-node->map (find-input-types (filter-meta-types schema))))

;; 2. Make a registry of all the ENUMs
(defn schema-enums->maps-with-specs
  [schema]
  (map enum-node->map (find-enums (filter-meta-types schema))))

(defn mutation-registry
  [base-registry schema]
  (let [input-type-specs (apply merge (schema-input-objects->maps-with-specs schema))
        enum-type-specs  (apply merge (schema-enums->maps-with-specs schema))]
    (merge base-registry input-type-specs enum-type-specs)))

;; make gens for mutation types
(defn mutation-fields->specs
  [schema mutation-type-name]
  (let [mutation-fields
        (:fields (first (filter #(= (:name %) mutation-type-name) schema)))]
    (mapv gen-mutation-node mutation-fields)))

(defn mutation-gen
    [schema registry node]
    (gen/let [mutation (mg/generator (gen-mutation-node node)
                                     {:registry registry :size 100})
              result-query (gqlgen/gen-gql-nodes
                            (:type node) schema 1
                            gqlgen/resolve-arg-gen-alphanumeric)]
      (let [args (clojure.string/join
                  ","
                  (mapv (fn [arg]
                          (str (key arg)
                               ": "
                               (if (string? (val arg))
                                 (str "\"" (val arg) "\"")
                                 (val arg))))
                        (val (first mutation))))]
        (str "mutation { " (first (keys mutation))
             "(input: {" args  "})" (gqlgen/make-query result-query) "}"))))

(defn schema->mutation-generators
  [schema mutation-type-name base-registry]
  (let [composed-registry (mutation-registry base-registry schema)]
    (mapv
     (fn [mutation-type] (mutation-gen schema composed-registry mutation-type))
     (:fields (first (filter #(= (:name %) mutation-type-name) schema))))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Test execution

(defn status-200-property
  [mutation-node-generator]
    (prop/for-all [mutation mutation-node-generator]
                  (let [result (run-query mutation)]
                   (swap! results-db conj
                          {:query  mutation
                           :result result})
                   (= (:status-code result) 200))))

(defn run-tests
  [node-generator]
  (reset! results-db [])
  (reset! queries [])
    (clojure.test.check/quick-check 100 (status-200-property node-generator)))

  (defn result-errors
  []
  (reduce
   (fn [acc result]
     (let [error (-> result :result :body :errors)]
       (if error
         (conj acc error)
         acc)))
   []
   @results-db))

(comment
  (filter (fn [s] (= "ENUM" (:kind s))) schema)

  ;; Filter all meta types
  (filter (fn [s] (clojure.string/starts-with? (:name s) "__")) schema)
  )

;; Will all relevant objects have input fields?

(comment
  (def schema (-> gql.query-data/gitlab-schema :data :__schema :types))

  (def mutation-fields (:fields (first (filter #(= (:name %) "Mutation") schema))))

  (defn find-type
    [schema type-name]
    (first (filter #(= (:name %) type-name) schema)))
  
  (first (:fields (first (filter #(= (:name %) "Mutation") schema))))

  (second (:fields (first (filter #(= (:name %) "Mutation") schema))))


  
  (def example-node
    {:name              "addAwardEmoji",
     :description       nil,
     :args
     [{:name         "input",
       :description  nil,
       :type
       {:kind "NON_NULL",
        :name nil,
        :ofType
        {:kind "INPUT_OBJECT", :name "AddAwardEmojiInput", :ofType nil}},
       :defaultValue nil}],
     :type              {:kind "OBJECT", :name "AddAwardEmojiPayload", :ofType nil},
     :isDeprecated      false,
     :deprecationReason nil})

  (mg/generate [:and {:gen/elements ["addAwardEmoji"]} string?])

  "Mutations are not graph-like (right?, doesn't make sense), so do them one by one."
  
  "A mutation field have args that need to be selected and value generated"
  
  ;;(gen/sample (gen-fields schema "Mutation" 2) 1)

  (gen/sample (gen/vector-distinct (gen/elements (:args example-node))))

  (gen-args (:args example-node) schema 100 the-argument-generator)

  (defn gen-mutation-node
    [node]
    (let [args      (:args node)
          node-name (:name node)
          arg-specs (mapv #(the-argument-generator (:type %)) args)]
      [:map (into [node-name] arg-specs)]))

  (gen-mutation-node example-node)
  
  (def example-input
    {:kind          "INPUT_OBJECT",
     :name          "AddAwardEmojiInput",
     :description   "Autogenerated input type of AddAwardEmoji",
     :fields        nil,
     :inputFields
     [{:name         "awardableId",
       :description  "The global id of the awardable resource",
       :type
       {:kind   "NON_NULL",
        :name   nil,
        :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
       :defaultValue nil}
      {:name         "name",
       :description  "The emoji name",
       :type
       {:kind   "NON_NULL",
        :name   nil,
        :ofType {:kind "SCALAR", :name "String", :ofType nil}},
       :defaultValue nil}
      {:name         "clientMutationId",
       :description
       "A unique identifier for the client performing the mutation.",
       :type         {:kind "SCALAR", :name "String", :ofType nil},
       :defaultValue nil}],
     :interfaces    nil,
     :enumValues    nil,
     :possibleTypes nil})

  (mg/generate [:map ["awardableId" string?]] {:size 10})
  
  (def the-registry
    (merge
     (m/class-schemas)
     (m/comparator-schemas)
     (m/base-schemas)
     (m/predicate-schemas)
     {:input-object/AddAwardEmojiInput
      [:map
       ["awardableId" [:enum "gid://gitlab/Issue/1"] ;;[:string {:min 1}]
        ]
       ["name" [:string {:min 1}]]]}))

  (mg/generate :input-object/AddAwardEmojiInput {:registry the-registry :size 100})

  (mg/generate (gen-mutation-node example-node) {:registry the-registry :size 100})
  
  (def example-with-object
    {:kind          "INPUT_OBJECT",
     :name          "CreateDiffNoteInput",
     :description   "Autogenerated input type of CreateDiffNote",
     :fields        nil,
     :inputFields
     [{:name         "noteableId",
       :description  "The global id of the resource to add a note to",
       :type
       {:kind   "NON_NULL",
        :name   nil,
        :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
       :defaultValue nil}
      {:name         "body",
       :description  "Content of the note",
       :type
       {:kind   "NON_NULL",
        :name   nil,
        :ofType {:kind "SCALAR", :name "String", :ofType nil}},
       :defaultValue nil}
      {:name         "position",
       :description  "The position of this note on a diff",
       :type
       {:kind "NON_NULL",
        :name nil,
        :ofType
        {:kind "INPUT_OBJECT", :name "DiffPositionInput", :ofType nil}},
       :defaultValue nil}
      {:name         "clientMutationId",
       :description
       "A unique identifier for the client performing the mutation.",
       :type         {:kind "SCALAR", :name "String", :ofType nil},
       :defaultValue nil}],
     :interfaces    nil,
     :enumValues    nil,
     :possibleTypes nil})

  (gen/sample
   (gqlgen/gen-gql-nodes
    (:type example-node) schema 1
    gqlgen/resolve-arg-gen-alphanumeric))

  (def example-result-query-gen
    (let [schema   (-> gql.query-data/gitlab-schema :data :__schema :types)
          the-type (:type example-node)
          nodes    (gqlgen/gen-gql-nodes
                    the-type schema 1
                    gqlgen/resolve-arg-gen-alphanumeric)]
      nodes))

  (gqlgen/make-query (first (gen/sample example-result-query-gen 1)))


  (defn mutation-gen
    []
    (gen/let [mutation (mg/generator (gen-mutation-node example-node)
                                     {:registry the-registry :size 100})
              query example-result-query-gen]
      (let [args (clojure.string/join
                  ","
                  (mapv (fn [arg]
                          (str (key arg)
                               ": "
                               (if (string? (val arg))
                                 (str "\"" (val arg) "\"")
                                 (val arg))))
                        (val (first mutation))))]
        (str "mutation { " (first (keys mutation)) "(input: {" args  "})" (gqlgen/make-query query) "}"))))


  (clojure.string/join "," ["a" "b"])
  
  (mg/generator (gen-mutation-node example-node) {:registry the-registry :size 100})

  (def the-property
    (prop/for-all [mutation (mutation-gen)]
                  (let [result (run-query mutation)]
                   (swap! results-db conj
                          {:query      mutation
                           :result     result})
                   (= (:status-code result) 200))))

  (clojure.test.check/quick-check 100 the-property)

  (defn run-tests
  []
  (reset! results-db [])
  (reset! queries [])
    (clojure.test.check/quick-check 10000 the-property))

  (defn result-errors
  []
  (reduce
   (fn [acc result]
     (let [error (-> result :result :body :errors)]
       (if error
         (conj acc error)
         acc)))
   []
   @results-db))
  
  (def example-query
    "mutation {
  addAwardEmoji(input: {awardableId:\"gid://gitlab/Issue/1\", name: \"tea\"}) {
    awardEmoji {
      name
      description
      unicode
      emoji
      unicodeVersion
      user {
        name
      }
    }
    errors
  }
}")

  "http://localhost/-/graphql-explorer"
  )

(ns gql.query-data)

(def query-type-data
  {:data
   {:__type
    {:name "Query",
     :fields
     [{:name "currentUser",
       :args [],
       :type {:kind "OBJECT", :name "User", :ofType nil}}
      {:name "echo",
       :args
       [{:name         "text",
         :description  "Text to echo back",
         :defaultValue nil}],
       :type {:kind "NON_NULL", :name nil, :ofType {:name "String"}}}
      {:name "group",
       :args
       [{:name         "fullPath",
         :description
         "The full path of the project, group or namespace, e.g., \"gitlab-org/gitlab-foss\"",
         :defaultValue nil}],
       :type {:kind "OBJECT", :name "Group", :ofType nil}}
      {:name "metadata",
       :args [],
       :type {:kind "OBJECT", :name "Metadata", :ofType nil}}
      {:name "namespace",
       :args
       [{:name         "fullPath",
         :description
         "The full path of the project, group or namespace, e.g., \"gitlab-org/gitlab-foss\"",
         :defaultValue nil}],
       :type {:kind "OBJECT", :name "Namespace", :ofType nil}}
      {:name "project",
       :args
       [{:name         "fullPath",
         :description
         "The full path of the project, group or namespace, e.g., \"gitlab-org/gitlab-foss\"",
         :defaultValue nil}],
       :type {:kind "OBJECT", :name "Project", :ofType nil}}
      {:name "snippets",
       :args
       [{:name         "ids",
         :description
         "Array of global snippet ids, e.g., \"gid://gitlab/ProjectSnippet/1\"",
         :defaultValue nil}
        {:name         "visibility",
         :description  "The visibility of the snippet",
         :defaultValue nil}
        {:name         "authorId",
         :description  "The ID of an author",
         :defaultValue nil}
        {:name         "projectId",
         :description  "The ID of a project",
         :defaultValue nil}
        {:name         "type",
         :description  "The type of snippet",
         :defaultValue nil}
        {:name         "explore",
         :description  "Explore personal snippets",
         :defaultValue nil}
        {:name         "after",
         :description
         "Returns the elements in the list that come after the specified cursor.",
         :defaultValue nil}
        {:name         "before",
         :description
         "Returns the elements in the list that come before the specified cursor.",
         :defaultValue nil}
        {:name         "first",
         :description  "Returns the first _n_ elements from the list.",
         :defaultValue nil}
        {:name         "last",
         :description  "Returns the last _n_ elements from the list.",
         :defaultValue nil}],
       :type
       {:kind "OBJECT", :name "SnippetConnection", :ofType nil}}]}}})

(def user-type
  {:data
   {:__type
    {:name "User",
     :fields
     [{:name "avatarUrl",
       :args [],
       :type {:kind "NON_NULL", :name nil, :ofType {:name "String"}}}
      {:name "name",
       :args [],
       :type {:kind "NON_NULL", :name nil, :ofType {:name "String"}}}
      {:name "snippets",
       :args
       [{:description
         "Array of global snippet ids, e.g., \"gid://gitlab/ProjectSnippet/1\"",
         :defaultValue nil}
        {:description  "The visibility of the snippet",
         :defaultValue nil}
        {:description "The type of snippet", :defaultValue nil}
        {:description
         "Returns the elements in the list that come after the specified cursor.",
         :defaultValue nil}
        {:description
         "Returns the elements in the list that come before the specified cursor.",
         :defaultValue nil}
        {:description  "Returns the first _n_ elements from the list.",
         :defaultValue nil}
        {:description  "Returns the last _n_ elements from the list.",
         :defaultValue nil}],
       :type {:kind "OBJECT", :name "SnippetConnection", :ofType nil}}
      {:name "todos",
       :args
       [{:description "The action to be filtered", :defaultValue nil}
        {:description "The ID of an author", :defaultValue nil}
        {:description "The ID of a project", :defaultValue nil}
        {:description "The ID of a group", :defaultValue nil}
        {:description "The state of the todo", :defaultValue nil}
        {:description "The type of the todo", :defaultValue nil}
        {:description
         "Returns the elements in the list that come after the specified cursor.",
         :defaultValue nil}
        {:description
         "Returns the elements in the list that come before the specified cursor.",
         :defaultValue nil}
        {:description  "Returns the first _n_ elements from the list.",
         :defaultValue nil}
        {:description  "Returns the last _n_ elements from the list.",
         :defaultValue nil}],
       :type
       {:kind "NON_NULL", :name nil, :ofType {:name "TodoConnection"}}}
      {:name "userPermissions",
       :args [],
       :type
       {:kind   "NON_NULL",
        :name   nil,
        :ofType {:name "UserPermissions"}}}
      {:name "username",
       :args [],
       :type {:kind "NON_NULL", :name nil, :ofType {:name "String"}}}
      {:name "webUrl",
       :args [],
       :type
       {:kind "NON_NULL", :name nil, :ofType {:name "String"}}}]}}})

(def gitlab-schema
  {:data
   {:__schema
    {:queryType {:name "Query"},
     :mutationType {:name "Mutation"},
     :subscriptionType nil,
     :types
     [{:kind "SCALAR",
       :name "Boolean",
       :description "Represents `true` or `false` values.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "SCALAR",
       :name "String",
       :description
       "Represents textual data as UTF-8 character sequences. This type is most often used by GraphQL to represent free-form human-readable text.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Query",
       :description nil,
       :fields
       [{:name "currentUser",
         :description "Get information about current user",
         :args [],
         :type {:kind "OBJECT", :name "User", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "echo",
         :description "Text to echo back",
         :args
         [{:name "text",
           :description "Text to echo back",
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "group",
         :description "Find a group",
         :args
         [{:name "fullPath",
           :description
           "The full path of the project, group or namespace, e.g., \"gitlab-org/gitlab-foss\"",
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "Group", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "metadata",
         :description "Metadata about GitLab",
         :args [],
         :type {:kind "OBJECT", :name "Metadata", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "namespace",
         :description "Find a namespace",
         :args
         [{:name "fullPath",
           :description
           "The full path of the project, group or namespace, e.g., \"gitlab-org/gitlab-foss\"",
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "Namespace", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "project",
         :description "Find a project",
         :args
         [{:name "fullPath",
           :description
           "The full path of the project, group or namespace, e.g., \"gitlab-org/gitlab-foss\"",
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "Project", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippets",
         :description "Find Snippets visible to the current user",
         :args
         [{:name "ids",
           :description
           "Array of global snippet ids, e.g., \"gid://gitlab/ProjectSnippet/1\"",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "ID", :ofType nil}}},
           :defaultValue nil}
          {:name "visibility",
           :description "The visibility of the snippet",
           :type
           {:kind "ENUM", :name "VisibilityScopesEnum", :ofType nil},
           :defaultValue nil}
          {:name "authorId",
           :description "The ID of an author",
           :type {:kind "SCALAR", :name "ID", :ofType nil},
           :defaultValue nil}
          {:name "projectId",
           :description "The ID of a project",
           :type {:kind "SCALAR", :name "ID", :ofType nil},
           :defaultValue nil}
          {:name "type",
           :description "The type of snippet",
           :type {:kind "ENUM", :name "TypeEnum", :ofType nil},
           :defaultValue nil}
          {:name "explore",
           :description "Explore personal snippets",
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "SnippetConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Project",
       :description nil,
       :fields
       [{:name "archived",
         :description "Archived status of the project",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "avatarUrl",
         :description "URL to avatar image file of the project",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "containerRegistryEnabled",
         :description
         "Indicates if the project stores Docker container images in a container registry",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description "Timestamp of the project creation",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description "Short description of the project",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "forksCount",
         :description "Number of times the project has been forked",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fullPath",
         :description "Full path of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "group",
         :description "Group of the project",
         :args [],
         :type {:kind "OBJECT", :name "Group", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "httpUrlToRepo",
         :description "URL to connect to the project via HTTPS",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "importStatus",
         :description
         "Status of project import background job of the project",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issue",
         :description "A single issue of the project",
         :args
         [{:name "iid",
           :description "IID of the issue. For example, \"1\"",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "iids",
           :description "List of IIDs of issues. For example, [1, 2]",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "String", :ofType nil}}},
           :defaultValue nil}
          {:name "state",
           :description "Current state of this issue",
           :type {:kind "ENUM", :name "IssuableState", :ofType nil},
           :defaultValue nil}
          {:name "labelName",
           :description "Labels applied to this issue",
           :type
           {:kind "LIST",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}},
           :defaultValue nil}
          {:name "createdBefore",
           :description "Issues created before this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "createdAfter",
           :description "Issues created after this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "updatedBefore",
           :description "Issues updated before this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "updatedAfter",
           :description "Issues updated after this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "closedBefore",
           :description "Issues closed before this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "closedAfter",
           :description "Issues closed after this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "search",
           :description
           "Search query for finding issues by title or description",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "sort",
           :description "Sort issues by this criteria",
           :type {:kind "ENUM", :name "IssueSort", :ofType nil},
           :defaultValue "created_desc"}],
         :type {:kind "OBJECT", :name "Issue", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issues",
         :description "Issues of the project",
         :args
         [{:name "iid",
           :description "IID of the issue. For example, \"1\"",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "iids",
           :description "List of IIDs of issues. For example, [1, 2]",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "String", :ofType nil}}},
           :defaultValue nil}
          {:name "state",
           :description "Current state of this issue",
           :type {:kind "ENUM", :name "IssuableState", :ofType nil},
           :defaultValue nil}
          {:name "labelName",
           :description "Labels applied to this issue",
           :type
           {:kind "LIST",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}},
           :defaultValue nil}
          {:name "createdBefore",
           :description "Issues created before this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "createdAfter",
           :description "Issues created after this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "updatedBefore",
           :description "Issues updated before this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "updatedAfter",
           :description "Issues updated after this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "closedBefore",
           :description "Issues closed before this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "closedAfter",
           :description "Issues closed after this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "search",
           :description
           "Search query for finding issues by title or description",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "sort",
           :description "Sort issues by this criteria",
           :type {:kind "ENUM", :name "IssueSort", :ofType nil},
           :defaultValue "created_desc"}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "IssueConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issuesEnabled",
         :description
         "(deprecated) Does this project have issues enabled?. Use `issues_access_level` instead",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "jobsEnabled",
         :description
         "(deprecated) Enable jobs for this project. Use `builds_access_level` instead",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lastActivityAt",
         :description "Timestamp of the project last activity",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lfsEnabled",
         :description
         "Indicates if the project has Large File Storage (LFS) enabled",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "A single merge request of the project",
         :args
         [{:name "iid",
           :description "The IID of the merge request, e.g., \"1\"",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "iids",
           :description "The list of IIDs of issues, e.g., [1, 2]",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "String", :ofType nil}}},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequests",
         :description "Merge requests of the project",
         :args
         [{:name "iid",
           :description "The IID of the merge request, e.g., \"1\"",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "iids",
           :description "The list of IIDs of issues, e.g., [1, 2]",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "String", :ofType nil}}},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "MergeRequestConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestsEnabled",
         :description
         "(deprecated) Does this project have merge_requests enabled?. Use `merge_requests_access_level` instead",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestsFfOnlyEnabled",
         :description
         "Indicates if no merge commits should be created and all merges should instead be fast-forwarded, which means that merging is only allowed if the branch could be fast-forwarded.",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description "Name of the project (without namespace)",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nameWithNamespace",
         :description "Full name of the project with its namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "namespace",
         :description "Namespace of the project",
         :args [],
         :type {:kind "OBJECT", :name "Namespace", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "onlyAllowMergeIfAllDiscussionsAreResolved",
         :description
         "Indicates if merge requests of the project can only be merged when all the discussions are resolved",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "onlyAllowMergeIfPipelineSucceeds",
         :description
         "Indicates if merge requests of the project can only be merged with successful jobs",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "openIssuesCount",
         :description "Number of open issues for the project",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description "Path of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pipelines",
         :description "Build pipelines of the project",
         :args
         [{:name "status",
           :description "Filter pipelines by their status",
           :type
           {:kind "ENUM", :name "PipelineStatusEnum", :ofType nil},
           :defaultValue nil}
          {:name "ref",
           :description "Filter pipelines by the ref they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "sha",
           :description
           "Filter pipelines by the sha of the commit they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "PipelineConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "printingMergeRequestLinkEnabled",
         :description
         "Indicates if a link to create or view a merge request should display after a push to Git repositories of the project from the command line",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "publicJobs",
         :description
         "Indicates if there is public access to pipelines and job details of the project, including output logs and artifacts",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "removeSourceBranchAfterMerge",
         :description
         "Indicates if `Delete source branch` option should be enabled by default for all new merge requests of the project",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "repository",
         :description "Git repository of the project",
         :args [],
         :type {:kind "OBJECT", :name "Repository", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "requestAccessEnabled",
         :description
         "Indicates if users can request member access to the project",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sentryDetailedError",
         :description
         "Detailed version of a Sentry error on the project",
         :args
         [{:name "id",
           :description "ID of the Sentry issue",
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "SentryDetailedError", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sharedRunnersEnabled",
         :description
         "Indicates if shared runners are enabled on the project",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippets",
         :description "Snippets of the project",
         :args
         [{:name "ids",
           :description
           "Array of global snippet ids, e.g., \"gid://gitlab/ProjectSnippet/1\"",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "ID", :ofType nil}}},
           :defaultValue nil}
          {:name "visibility",
           :description "The visibility of the snippet",
           :type
           {:kind "ENUM", :name "VisibilityScopesEnum", :ofType nil},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "SnippetConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippetsEnabled",
         :description
         "(deprecated) Does this project have snippets enabled?. Use `snippets_access_level` instead",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sshUrlToRepo",
         :description "URL to connect to the project via SSH",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "starCount",
         :description "Number of times the project has been starred",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "statistics",
         :description "Statistics of the project",
         :args [],
         :type
         {:kind "OBJECT", :name "ProjectStatistics", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "tagList",
         :description "List of project tags",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "ProjectPermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "visibility",
         :description "Visibility of the project",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the project",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "wikiEnabled",
         :description
         "(deprecated) Does this project have wiki enabled?. Use `wiki_access_level` instead",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "ProjectPermissions",
       :description nil,
       :fields
       [{:name "adminOperations",
         :description
         "Whether or not a user can perform `admin_operations` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "adminProject",
         :description
         "Whether or not a user can perform `admin_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "adminRemoteMirror",
         :description
         "Whether or not a user can perform `admin_remote_mirror` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "adminWiki",
         :description
         "Whether or not a user can perform `admin_wiki` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "archiveProject",
         :description
         "Whether or not a user can perform `archive_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "changeNamespace",
         :description
         "Whether or not a user can perform `change_namespace` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "changeVisibilityLevel",
         :description
         "Whether or not a user can perform `change_visibility_level` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createDeployment",
         :description
         "Whether or not a user can perform `create_deployment` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createIssue",
         :description
         "Whether or not a user can perform `create_issue` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createLabel",
         :description
         "Whether or not a user can perform `create_label` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createMergeRequestFrom",
         :description
         "Whether or not a user can perform `create_merge_request_from` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createMergeRequestIn",
         :description
         "Whether or not a user can perform `create_merge_request_in` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createPages",
         :description
         "Whether or not a user can perform `create_pages` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createPipeline",
         :description
         "Whether or not a user can perform `create_pipeline` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createPipelineSchedule",
         :description
         "Whether or not a user can perform `create_pipeline_schedule` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createSnippet",
         :description
         "Whether or not a user can perform `create_snippet` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createWiki",
         :description
         "Whether or not a user can perform `create_wiki` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "destroyPages",
         :description
         "Whether or not a user can perform `destroy_pages` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "destroyWiki",
         :description
         "Whether or not a user can perform `destroy_wiki` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "downloadCode",
         :description
         "Whether or not a user can perform `download_code` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "downloadWikiCode",
         :description
         "Whether or not a user can perform `download_wiki_code` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "forkProject",
         :description
         "Whether or not a user can perform `fork_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pushCode",
         :description
         "Whether or not a user can perform `push_code` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pushToDeleteProtectedBranch",
         :description
         "Whether or not a user can perform `push_to_delete_protected_branch` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readCommitStatus",
         :description
         "Whether or not a user can perform `read_commit_status` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readCycleAnalytics",
         :description
         "Whether or not a user can perform `read_cycle_analytics` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readPagesContent",
         :description
         "Whether or not a user can perform `read_pages_content` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readProject",
         :description
         "Whether or not a user can perform `read_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readProjectMember",
         :description
         "Whether or not a user can perform `read_project_member` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readWiki",
         :description
         "Whether or not a user can perform `read_wiki` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "removeForkProject",
         :description
         "Whether or not a user can perform `remove_fork_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "removePages",
         :description
         "Whether or not a user can perform `remove_pages` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "removeProject",
         :description
         "Whether or not a user can perform `remove_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "renameProject",
         :description
         "Whether or not a user can perform `rename_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "requestAccess",
         :description
         "Whether or not a user can perform `request_access` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatePages",
         :description
         "Whether or not a user can perform `update_pages` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updateWiki",
         :description
         "Whether or not a user can perform `update_wiki` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "uploadFile",
         :description
         "Whether or not a user can perform `upload_file` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "SCALAR",
       :name "ID",
       :description
       "Represents a unique identifier that is Base64 obfuscated. It is often used to refetch an object or as key for a cache. The ID type appears in a JSON response as a String; however, it is not intended to be human-readable. When expected as an input type, any string (such as `\"VXNlci0xMA==\"`) or integer (such as `4`) input value will be accepted as an ID.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "SCALAR",
       :name "Int",
       :description
       "Represents non-fractional signed whole numeric values. Int can represent values between -(2^31) and 2^31 - 1.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "SCALAR",
       :name "Time",
       :description "Time represented in ISO 8601",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Namespace",
       :description nil,
       :fields
       [{:name "description",
         :description "Description of the namespace",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fullName",
         :description "Full name of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fullPath",
         :description "Full path of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lfsEnabled",
         :description
         "Indicates if Large File Storage (LFS) is enabled for namespace",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description "Name of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description "Path of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "projects",
         :description "Projects within this namespace",
         :args
         [{:name "includeSubgroups",
           :description "Include also subgroup projects",
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "ProjectConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "requestAccessEnabled",
         :description
         "Indicates if users can request access to namespace",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "rootStorageStatistics",
         :description
         "Aggregated storage statistics of the namespace. Only available for root namespaces",
         :args [],
         :type
         {:kind "OBJECT", :name "RootStorageStatistics", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "visibility",
         :description "Visibility of the namespace",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "RootStorageStatistics",
       :description nil,
       :fields
       [{:name "buildArtifactsSize",
         :description "The CI artifacts size in bytes",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lfsObjectsSize",
         :description "The LFS objects size in bytes",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "packagesSize",
         :description "The packages size in bytes",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "repositorySize",
         :description "The Git repository size in bytes",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "storageSize",
         :description "The total storage in bytes",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "wikiSize",
         :description "The wiki size in bytes",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "ProjectConnection",
       :description "The connection type for Project.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "ProjectEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Project", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "PageInfo",
       :description "Information about pagination in a connection.",
       :fields
       [{:name "endCursor",
         :description
         "When paginating forwards, the cursor to continue.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "hasNextPage",
         :description
         "When paginating forwards, are there more items?",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "hasPreviousPage",
         :description
         "When paginating backwards, are there more items?",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "startCursor",
         :description
         "When paginating backwards, the cursor to continue.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "ProjectEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Project", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Group",
       :description nil,
       :fields
       [{:name "avatarUrl",
         :description "Avatar URL of the group",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description "Description of the namespace",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fullName",
         :description "Full name of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fullPath",
         :description "Full path of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lfsEnabled",
         :description
         "Indicates if Large File Storage (LFS) is enabled for namespace",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description "Name of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "parent",
         :description "Parent group",
         :args [],
         :type {:kind "OBJECT", :name "Group", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description "Path of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "projects",
         :description "Projects within this namespace",
         :args
         [{:name "includeSubgroups",
           :description "Include also subgroup projects",
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "ProjectConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "requestAccessEnabled",
         :description
         "Indicates if users can request access to namespace",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "rootStorageStatistics",
         :description
         "Aggregated storage statistics of the namespace. Only available for root namespaces",
         :args [],
         :type
         {:kind "OBJECT", :name "RootStorageStatistics", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "GroupPermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "visibility",
         :description "Visibility of the namespace",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the group",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "GroupPermissions",
       :description nil,
       :fields
       [{:name "readGroup",
         :description
         "Whether or not a user can perform `read_group` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "ProjectStatistics",
       :description nil,
       :fields
       [{:name "buildArtifactsSize",
         :description "Build artifacts size of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "commitCount",
         :description "Commit count of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lfsObjectsSize",
         :description
         "Large File Storage (LFS) object size of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "packagesSize",
         :description "Packages size of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "repositorySize",
         :description "Repository size of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "storageSize",
         :description "Storage size of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "wikiSize",
         :description "Wiki size of the project",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Repository",
       :description nil,
       :fields
       [{:name "empty",
         :description "Indicates repository has no visible content",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "exists",
         :description
         "Indicates a corresponding Git repository exists on disk",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "rootRef",
         :description "Default branch of the repository",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "tree",
         :description "Tree of the repository",
         :args
         [{:name "path",
           :description
           "The path to get the tree for. Default value is the root of the repository",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue "\"\""}
          {:name "ref",
           :description
           "The commit ref to get the tree for. Default value is HEAD",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue "\"head\""}
          {:name "recursive",
           :description
           "Used to get a recursive tree. Default is false",
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}],
         :type {:kind "OBJECT", :name "Tree", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Tree",
       :description nil,
       :fields
       [{:name "blobs",
         :description nil,
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "BlobConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lastCommit",
         :description "Last commit for the tree",
         :args [],
         :type {:kind "OBJECT", :name "Commit", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "submodules",
         :description nil,
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "SubmoduleConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "trees",
         :description nil,
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "TreeEntryConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Commit",
       :description nil,
       :fields
       [{:name "author",
         :description "Author of the commit",
         :args [],
         :type {:kind "OBJECT", :name "User", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "authorName",
         :description "Commit authors name",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "authoredDate",
         :description "Timestamp of when the commit was authored",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description "Description of the commit message",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID (global ID) of the commit",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "latestPipeline",
         :description "Latest pipeline of the commit",
         :args
         [{:name "status",
           :description "Filter pipelines by their status",
           :type
           {:kind "ENUM", :name "PipelineStatusEnum", :ofType nil},
           :defaultValue nil}
          {:name "ref",
           :description "Filter pipelines by the ref they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "sha",
           :description
           "Filter pipelines by the sha of the commit they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "Pipeline", :ofType nil},
         :isDeprecated true,
         :deprecationReason "use pipelines"}
        {:name "message",
         :description "Raw commit message",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pipelines",
         :description "Pipelines of the commit ordered latest first",
         :args
         [{:name "status",
           :description "Filter pipelines by their status",
           :type
           {:kind "ENUM", :name "PipelineStatusEnum", :ofType nil},
           :defaultValue nil}
          {:name "ref",
           :description "Filter pipelines by the ref they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "sha",
           :description
           "Filter pipelines by the sha of the commit they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "PipelineConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sha",
         :description "SHA1 ID of the commit",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "signatureHtml",
         :description "Rendered HTML of the commit signature",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Title of the commit message",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the commit",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "User",
       :description nil,
       :fields
       [{:name "avatarUrl",
         :description "URL of the user's avatar",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description "Human-readable name of the user",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippets",
         :description "Snippets authored by the user",
         :args
         [{:name "ids",
           :description
           "Array of global snippet ids, e.g., \"gid://gitlab/ProjectSnippet/1\"",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "ID", :ofType nil}}},
           :defaultValue nil}
          {:name "visibility",
           :description "The visibility of the snippet",
           :type
           {:kind "ENUM", :name "VisibilityScopesEnum", :ofType nil},
           :defaultValue nil}
          {:name "type",
           :description "The type of snippet",
           :type {:kind "ENUM", :name "TypeEnum", :ofType nil},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "SnippetConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "todos",
         :description "Todos of the user",
         :args
         [{:name "action",
           :description "The action to be filtered",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType
             {:kind "ENUM", :name "TodoActionEnum", :ofType nil}}},
           :defaultValue nil}
          {:name "authorId",
           :description "The ID of an author",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "ID", :ofType nil}}},
           :defaultValue nil}
          {:name "projectId",
           :description "The ID of a project",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "ID", :ofType nil}}},
           :defaultValue nil}
          {:name "groupId",
           :description "The ID of a group",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "ID", :ofType nil}}},
           :defaultValue nil}
          {:name "state",
           :description "The state of the todo",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType
             {:kind "ENUM", :name "TodoStateEnum", :ofType nil}}},
           :defaultValue nil}
          {:name "type",
           :description "The type of the todo",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType
             {:kind "ENUM", :name "TodoTargetEnum", :ofType nil}}},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "TodoConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "UserPermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "username",
         :description
         "Username of the user. Unique within this instance of GitLab",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the user",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "UserPermissions",
       :description nil,
       :fields
       [{:name "createSnippet",
         :description
         "Whether or not a user can perform `create_snippet` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TodoConnection",
       :description "The connection type for Todo.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "TodoEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Todo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TodoEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Todo", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Todo",
       :description "Representing a todo entry",
       :fields
       [{:name "action",
         :description "Action of the todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "TodoActionEnum", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "author",
         :description "The owner of this todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "User", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "body",
         :description "Body of the todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description "Timestamp this todo was created",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "group",
         :description "Group this todo is associated with",
         :args [],
         :type {:kind "OBJECT", :name "Group", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "Id of the todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "project",
         :description "The project this todo is associated with",
         :args [],
         :type {:kind "OBJECT", :name "Project", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "state",
         :description "State of the todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "TodoStateEnum", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "targetType",
         :description "Target type of the todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "TodoTargetEnum", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "TodoActionEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "assigned",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mentioned",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "build_failed",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "marked",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "approval_required",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "unmergeable",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "directly_addressed",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "TodoTargetEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "COMMIT",
         :description "A Commit",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "ISSUE",
         :description "An Issue",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "MERGEREQUEST",
         :description "A MergeRequest",
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "TodoStateEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "pending",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "done",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SnippetConnection",
       :description "The connection type for Snippet.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "SnippetEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Snippet", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SnippetEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Snippet", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Snippet",
       :description "Represents a snippet entry",
       :fields
       [{:name "author",
         :description "The owner of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "User", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "content",
         :description "Content of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description "Timestamp this snippet was created",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description "Description of the snippet",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "discussions",
         :description "All discussions on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "DiscussionConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fileName",
         :description "File Name of the snippet",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "Id of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "notes",
         :description "All notes on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "NoteConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "project",
         :description "The project the snippet is associated with",
         :args [],
         :type {:kind "OBJECT", :name "Project", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "rawUrl",
         :description "Raw URL of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Title of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedAt",
         :description "Timestamp this snippet was updated",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "SnippetPermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "visibilityLevel",
         :description "Visibility Level of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "ENUM", :name "VisibilityLevelsEnum", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces
       [{:kind "INTERFACE", :name "Noteable", :ofType nil}],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INTERFACE",
       :name "Noteable",
       :description nil,
       :fields
       [{:name "discussions",
         :description "All discussions on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "DiscussionConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "notes",
         :description "All notes on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "NoteConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes
       [{:kind "OBJECT", :name "Issue", :ofType nil}
        {:kind "OBJECT", :name "MergeRequest", :ofType nil}
        {:kind "OBJECT", :name "Snippet", :ofType nil}]}
      {:kind "OBJECT",
       :name "NoteConnection",
       :description "The connection type for Note.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "NoteEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Note", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "NoteEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Note", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Note",
       :description nil,
       :fields
       [{:name "author",
         :description "User who wrote this note",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "User", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "body",
         :description "Content of the note",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "bodyHtml",
         :description
         "The GitLab Flavored Markdown rendering of `note`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description "Timestamp of the note creation",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "discussion",
         :description "The discussion this note is a part of",
         :args [],
         :type {:kind "OBJECT", :name "Discussion", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of the note",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "position",
         :description "The position of this note on a diff",
         :args [],
         :type {:kind "OBJECT", :name "DiffPosition", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "project",
         :description "Project associated with the note",
         :args [],
         :type {:kind "OBJECT", :name "Project", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "resolvable",
         :description
         "Indicates if this note can be resolved. That is, if it is a resolvable discussion or simply a standalone note",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "resolvedAt",
         :description "Timestamp of the note's resolution",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "resolvedBy",
         :description "User that resolved the discussion",
         :args [],
         :type {:kind "OBJECT", :name "User", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "system",
         :description
         "Indicates whether this note was created by the system or by a user",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedAt",
         :description "Timestamp of the note's last activity",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "NotePermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "NotePermissions",
       :description nil,
       :fields
       [{:name "adminNote",
         :description
         "Whether or not a user can perform `admin_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "awardEmoji",
         :description
         "Whether or not a user can perform `award_emoji` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createNote",
         :description
         "Whether or not a user can perform `create_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readNote",
         :description
         "Whether or not a user can perform `read_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "resolveNote",
         :description
         "Whether or not a user can perform `resolve_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Discussion",
       :description nil,
       :fields
       [{:name "createdAt",
         :description "Timestamp of the discussion's creation",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of this discussion",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "notes",
         :description "All notes in the discussion",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "NoteConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "replyId",
         :description "ID used to reply to this discussion",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DiffPosition",
       :description nil,
       :fields
       [{:name "diffRefs",
         :description
         "Information about the branch, HEAD, and base at the time of commenting",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "DiffRefs", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "filePath",
         :description "Path of the file that was changed",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "height",
         :description "Total height of the image",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "newLine",
         :description "Line on HEAD SHA that was changed",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "newPath",
         :description "Path of the file on the HEAD SHA",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "oldLine",
         :description "Line on start SHA that was changed",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "oldPath",
         :description "Path of the file on the start SHA",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "positionType",
         :description "Type of file the position refers to",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "ENUM", :name "DiffPositionType", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "width",
         :description "Total width of the image",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "x",
         :description "X position on which the comment was made",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "y",
         :description "Y position on which the comment was made",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DiffRefs",
       :description nil,
       :fields
       [{:name "baseSha",
         :description
         "Merge base of the branch the comment was made on",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "headSha",
         :description
         "SHA of the HEAD at the time the comment was made",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "startSha",
         :description "SHA of the branch being compared against",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "DiffPositionType",
       :description "Type of file the position refers to",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "text",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "image",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DiscussionConnection",
       :description "The connection type for Discussion.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "DiscussionEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Discussion", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DiscussionEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Discussion", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SnippetPermissions",
       :description nil,
       :fields
       [{:name "adminSnippet",
         :description
         "Whether or not a user can perform `admin_snippet` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "awardEmoji",
         :description
         "Whether or not a user can perform `award_emoji` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createNote",
         :description
         "Whether or not a user can perform `create_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readSnippet",
         :description
         "Whether or not a user can perform `read_snippet` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "reportSnippet",
         :description
         "Whether or not a user can perform `report_snippet` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updateSnippet",
         :description
         "Whether or not a user can perform `update_snippet` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "VisibilityLevelsEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "private",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "internal",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "public",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "VisibilityScopesEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "private",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "internal",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "public",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "TypeEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "personal",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "project",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "PipelineConnection",
       :description "The connection type for Pipeline.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "PipelineEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Pipeline", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "PipelineEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Pipeline", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Pipeline",
       :description nil,
       :fields
       [{:name "beforeSha",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "committedAt",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "coverage",
         :description "Coverage percentage",
         :args [],
         :type {:kind "SCALAR", :name "Float", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "detailedStatus",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "DetailedStatus", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "duration",
         :description "Duration of the pipeline in seconds",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "finishedAt",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "iid",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sha",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "startedAt",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "status",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "ENUM", :name "PipelineStatusEnum", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedAt",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "PipelinePermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "PipelinePermissions",
       :description nil,
       :fields
       [{:name "adminPipeline",
         :description
         "Whether or not a user can perform `admin_pipeline` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "destroyPipeline",
         :description
         "Whether or not a user can perform `destroy_pipeline` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatePipeline",
         :description
         "Whether or not a user can perform `update_pipeline` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "PipelineStatusEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "CREATED",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "PREPARING",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "PENDING",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "RUNNING",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "FAILED",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "SUCCESS",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "CANCELED",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "SKIPPED",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "MANUAL",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "SCHEDULED",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DetailedStatus",
       :description nil,
       :fields
       [{:name "detailsPath",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "favicon",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "group",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "hasDetails",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "icon",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "label",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "text",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "tooltip",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "SCALAR",
       :name "Float",
       :description
       "Represents signed double-precision fractional values as specified by [IEEE 754](https://en.wikipedia.org/wiki/IEEE_floating_point).",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TreeEntryConnection",
       :description "The connection type for TreeEntry.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "TreeEntryEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "TreeEntry", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TreeEntryEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "TreeEntry", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TreeEntry",
       :description "Represents a directory",
       :fields
       [{:name "flatPath",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sha",
         :description "Last commit sha for entry",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "EntryType", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [{:kind "INTERFACE", :name "Entry", :ofType nil}],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INTERFACE",
       :name "Entry",
       :description nil,
       :fields
       [{:name "flatPath",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sha",
         :description "Last commit sha for entry",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "EntryType", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes
       [{:kind "OBJECT", :name "Blob", :ofType nil}
        {:kind "OBJECT", :name "Submodule", :ofType nil}
        {:kind "OBJECT", :name "TreeEntry", :ofType nil}]}
      {:kind "ENUM",
       :name "EntryType",
       :description "Type of a tree entry",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "tree",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "blob",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "commit",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SubmoduleConnection",
       :description "The connection type for Submodule.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "SubmoduleEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Submodule", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SubmoduleEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Submodule", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Submodule",
       :description nil,
       :fields
       [{:name "flatPath",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sha",
         :description "Last commit sha for entry",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "treeUrl",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "EntryType", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [{:kind "INTERFACE", :name "Entry", :ofType nil}],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "BlobConnection",
       :description "The connection type for Blob.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "BlobEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Blob", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "BlobEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Blob", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Blob",
       :description nil,
       :fields
       [{:name "flatPath",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lfsOid",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sha",
         :description "Last commit sha for entry",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "EntryType", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [{:kind "INTERFACE", :name "Entry", :ofType nil}],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestConnection",
       :description "The connection type for MergeRequest.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "MergeRequestEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "MergeRequest", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequest",
       :description nil,
       :fields
       [{:name "allowCollaboration",
         :description
         "Indicates if members of the target project can push to the fork",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "assignees",
         :description "Assignees of the merge request",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "UserConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description
         "Timestamp of when the merge request was created",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "defaultMergeCommitMessage",
         :description
         "Default merge commit message of the merge request",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description
         "Description of the merge request (Markdown rendered as HTML for caching)",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "diffHeadSha",
         :description "Diff head SHA of the merge request",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "diffRefs",
         :description
         "References of the base SHA, the head SHA, and the start SHA for this merge request",
         :args [],
         :type {:kind "OBJECT", :name "DiffRefs", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "discussionLocked",
         :description
         "Indicates if comments on the merge request are locked to members only",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "discussions",
         :description "All discussions on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "DiscussionConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "downvotes",
         :description "Number of downvotes for the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "forceRemoveSourceBranch",
         :description
         "Indicates if the project settings will lead to source branch deletion after merge",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "headPipeline",
         :description
         "The pipeline running on the branch HEAD of the merge request",
         :args [],
         :type {:kind "OBJECT", :name "Pipeline", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "iid",
         :description "Internal ID of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "inProgressMergeCommitSha",
         :description
         "Commit SHA of the merge request if merge is in progress",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "labels",
         :description "Labels of the merge request",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "LabelConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeCommitMessage",
         :description
         "Deprecated - renamed to defaultMergeCommitMessage",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated true,
         :deprecationReason "Renamed to defaultMergeCommitMessage"}
        {:name "mergeCommitSha",
         :description
         "SHA of the merge request commit (set once merged)",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeError",
         :description "Error message due to a merge error",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeOngoing",
         :description "Indicates if a merge is currently occurring",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeStatus",
         :description "Status of the merge request",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeWhenPipelineSucceeds",
         :description
         "Indicates if the merge has been set to be merged when its pipeline succeeds (MWPS)",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeableDiscussionsState",
         :description
         "Indicates if all discussions in the merge request have been resolved, allowing the merge request to be merged",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "milestone",
         :description "The milestone of the merge request",
         :args [],
         :type {:kind "OBJECT", :name "Milestone", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "notes",
         :description "All notes on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "NoteConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "participants",
         :description "Participants in the merge request",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "UserConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pipelines",
         :description "Pipelines for the merge request",
         :args
         [{:name "status",
           :description "Filter pipelines by their status",
           :type
           {:kind "ENUM", :name "PipelineStatusEnum", :ofType nil},
           :defaultValue nil}
          {:name "ref",
           :description "Filter pipelines by the ref they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "sha",
           :description
           "Filter pipelines by the sha of the commit they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "PipelineConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "project",
         :description "Alias for target_project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "Project", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "projectId",
         :description "ID of the merge request project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "rebaseCommitSha",
         :description "Rebase commit SHA of the merge request",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "rebaseInProgress",
         :description
         "Indicates if there is a rebase currently in progress for the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "reference",
         :description
         "Internal reference of the merge request. Returned in shortened format by default",
         :args
         [{:name "full",
           :description
           "Boolean option specifying whether the reference should be returned in full",
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "shouldBeRebased",
         :description "Indicates if the merge request will be rebased",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "shouldRemoveSourceBranch",
         :description
         "Indicates if the source branch of the merge request will be deleted after merge",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sourceBranch",
         :description "Source branch of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sourceBranchExists",
         :description
         "Indicates if the source branch of the merge request exists",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sourceProject",
         :description "Source project of the merge request",
         :args [],
         :type {:kind "OBJECT", :name "Project", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sourceProjectId",
         :description "ID of the merge request source project",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "state",
         :description "State of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "ENUM", :name "MergeRequestState", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "subscribed",
         :description
         "Indicates if the currently logged in user is subscribed to this merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "targetBranch",
         :description "Target branch of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "targetProject",
         :description "Target project of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "Project", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "targetProjectId",
         :description "ID of the merge request target project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "taskCompletionStatus",
         :description "Completion status of tasks",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "TaskCompletionStatus", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "timeEstimate",
         :description "Time estimate of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Title of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "titleHtml",
         :description
         "The GitLab Flavored Markdown rendering of `title`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "totalTimeSpent",
         :description
         "Total time reported as spent on the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedAt",
         :description
         "Timestamp of when the merge request was last updated",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "upvotes",
         :description "Number of upvotes for the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userNotesCount",
         :description "User notes count of the merge request",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT",
           :name "MergeRequestPermissions",
           :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the merge request",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "workInProgress",
         :description
         "Indicates if the merge request is a work in progress (WIP)",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces
       [{:kind "INTERFACE", :name "Noteable", :ofType nil}],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestPermissions",
       :description
       "Check permissions for the current user on a merge request",
       :fields
       [{:name "adminMergeRequest",
         :description
         "Whether or not a user can perform `admin_merge_request` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "cherryPickOnCurrentMergeRequest",
         :description
         "Whether or not a user can perform `cherry_pick_on_current_merge_request` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createNote",
         :description
         "Whether or not a user can perform `create_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pushToSourceBranch",
         :description
         "Whether or not a user can perform `push_to_source_branch` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readMergeRequest",
         :description
         "Whether or not a user can perform `read_merge_request` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "removeSourceBranch",
         :description
         "Whether or not a user can perform `remove_source_branch` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "revertOnCurrentMergeRequest",
         :description
         "Whether or not a user can perform `revert_on_current_merge_request` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updateMergeRequest",
         :description
         "Whether or not a user can perform `update_merge_request` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "MergeRequestState",
       :description "State of a GitLab merge request",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "opened",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "closed",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "locked",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "merged",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Milestone",
       :description nil,
       :fields
       [{:name "createdAt",
         :description "Timestamp of milestone creation",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description "Description of the milestone",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "dueDate",
         :description "Timestamp of the milestone due date",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of the milestone",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "startDate",
         :description "Timestamp of the milestone start date",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "state",
         :description "State of the milestone",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Title of the milestone",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedAt",
         :description "Timestamp of last milestone update",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "UserConnection",
       :description "The connection type for User.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "UserEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "User", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "UserEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "User", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "LabelConnection",
       :description "The connection type for Label.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "LabelEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Label", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "LabelEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Label", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Label",
       :description nil,
       :fields
       [{:name "color",
         :description "Background color of the label",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description
         "Description of the label (Markdown rendered as HTML for caching)",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "Label ID",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "textColor",
         :description "Text color of the label",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Content of the label",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TaskCompletionStatus",
       :description "Completion status of tasks",
       :fields
       [{:name "completedCount",
         :description "Number of completed tasks",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "count",
         :description "Number of total tasks",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "IssueConnection",
       :description "The connection type for Issue.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "IssueEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Issue", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "IssueEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Issue", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Issue",
       :description nil,
       :fields
       [{:name "assignees",
         :description "Assignees of the issue",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "UserConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "author",
         :description "User that created the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "User", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "closedAt",
         :description "Timestamp of when the issue was closed",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "confidential",
         :description "Indicates the issue is confidential",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description "Timestamp of when the issue was created",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description "Description of the issue",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "discussionLocked",
         :description "Indicates discussion is locked on the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "discussions",
         :description "All discussions on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "DiscussionConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "downvotes",
         :description "Number of downvotes the issue has received",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "dueDate",
         :description "Due date of the issue",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "iid",
         :description "Internal ID of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "labels",
         :description "Labels of the issue",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "LabelConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "milestone",
         :description "Milestone of the issue",
         :args [],
         :type {:kind "OBJECT", :name "Milestone", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "notes",
         :description "All notes on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "NoteConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "participants",
         :description "List of participants in the issue",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "UserConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "reference",
         :description
         "Internal reference of the issue. Returned in shortened format by default",
         :args
         [{:name "full",
           :description
           "Boolean option specifying whether the reference should be returned in full",
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "relativePosition",
         :description
         "Relative position of the issue (used for positioning in epic tree and issue boards)",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "state",
         :description "State of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "IssueState", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "subscribed",
         :description
         "Boolean flag for whether the currently logged in user is subscribed to this issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "taskCompletionStatus",
         :description "Task completion status of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "TaskCompletionStatus", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "timeEstimate",
         :description "Time estimate of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Title of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "titleHtml",
         :description
         "The GitLab Flavored Markdown rendering of `title`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "totalTimeSpent",
         :description "Total time reported as spent on the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedAt",
         :description "Timestamp of when the issue was last updated",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "upvotes",
         :description "Number of upvotes the issue has received",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userNotesCount",
         :description "Number of user notes of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "IssuePermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webPath",
         :description "Web path of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces
       [{:kind "INTERFACE", :name "Noteable", :ofType nil}],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "IssuePermissions",
       :description
       "Check permissions for the current user on a issue",
       :fields
       [{:name "adminIssue",
         :description
         "Whether or not a user can perform `admin_issue` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createNote",
         :description
         "Whether or not a user can perform `create_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readIssue",
         :description
         "Whether or not a user can perform `read_issue` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "reopenIssue",
         :description
         "Whether or not a user can perform `reopen_issue` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updateIssue",
         :description
         "Whether or not a user can perform `update_issue` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "IssueState",
       :description "State of a GitLab issue",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "opened",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "closed",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "locked",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "IssuableState",
       :description "State of a GitLab issue or merge request",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "opened",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "closed",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "locked",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "IssueSort",
       :description "Values for sorting issues",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "updated_desc",
         :description "Updated at descending order",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updated_asc",
         :description "Updated at ascending order",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "created_desc",
         :description "Created at descending order",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "created_asc",
         :description "Created at ascending order",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "DUE_DATE_ASC",
         :description "Due date by ascending order",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "DUE_DATE_DESC",
         :description "Due date by descending order",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "RELATIVE_POSITION_ASC",
         :description "Relative position by ascending order",
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SentryDetailedError",
       :description nil,
       :fields
       [{:name "count",
         :description "Count of occurrences",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "culprit",
         :description "Culprit of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "externalUrl",
         :description "External URL of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "firstReleaseLastCommit",
         :description "Commit the error was first seen",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "firstReleaseShortVersion",
         :description "Release version the error was first seen",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "firstSeen",
         :description "Timestamp when the error was first seen",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "frequency",
         :description "Last 24hr stats of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "OBJECT",
             :name "SentryErrorFrequency",
             :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID (global ID) of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lastReleaseLastCommit",
         :description "Commit the error was last seen",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lastReleaseShortVersion",
         :description "Release version the error was last seen",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lastSeen",
         :description "Timestamp when the error was last seen",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "message",
         :description "Sentry metadata message of the error",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sentryId",
         :description "ID (Sentry ID) of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sentryProjectId",
         :description "ID of the project (Sentry project)",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sentryProjectName",
         :description "Name of the project affected by the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sentryProjectSlug",
         :description "Slug of the project affected by the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "shortId",
         :description "Short ID (Sentry ID) of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "status",
         :description "Status of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "ENUM", :name "SentryErrorStatus", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Title of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description "Type of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userCount",
         :description "Count of users affected by the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "SentryErrorStatus",
       :description "State of a Sentry error",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "RESOLVED",
         :description "Error has been resolved",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "RESOLVED_IN_NEXT_RELEASE",
         :description "Error has been ignored until next release",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "UNRESOLVED",
         :description "Error is unresolved",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "IGNORED",
         :description "Error has been ignored",
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SentryErrorFrequency",
       :description nil,
       :fields
       [{:name "count",
         :description
         "Count of errors received since the previously recorded time",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "time",
         :description "Time the error frequency stats were recorded",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Metadata",
       :description nil,
       :fields
       [{:name "revision",
         :description "Revision",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "version",
         :description "Version",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Mutation",
       :description nil,
       :fields
       [{:name "addAwardEmoji",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "AddAwardEmojiInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "AddAwardEmojiPayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createDiffNote",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "CreateDiffNoteInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "CreateDiffNotePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createImageDiffNote",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "CreateImageDiffNoteInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "CreateImageDiffNotePayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createNote",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "CreateNoteInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "CreateNotePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createSnippet",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "CreateSnippetInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "CreateSnippetPayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "destroyNote",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "DestroyNoteInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "DestroyNotePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "destroySnippet",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "DestroySnippetInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "DestroySnippetPayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issueSetConfidential",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "IssueSetConfidentialInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "IssueSetConfidentialPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issueSetDueDate",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "IssueSetDueDateInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "IssueSetDueDatePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "markAsSpamSnippet",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MarkAsSpamSnippetInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MarkAsSpamSnippetPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestSetAssignees",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MergeRequestSetAssigneesInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MergeRequestSetAssigneesPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestSetLabels",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MergeRequestSetLabelsInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MergeRequestSetLabelsPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestSetLocked",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MergeRequestSetLockedInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MergeRequestSetLockedPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestSetMilestone",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MergeRequestSetMilestoneInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MergeRequestSetMilestonePayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestSetSubscription",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MergeRequestSetSubscriptionInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MergeRequestSetSubscriptionPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestSetWip",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MergeRequestSetWipInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MergeRequestSetWipPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "removeAwardEmoji",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "RemoveAwardEmojiInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "RemoveAwardEmojiPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "todoMarkDone",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "TodoMarkDoneInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "TodoMarkDonePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "todoRestore",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "TodoRestoreInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "TodoRestorePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "todosMarkAllDone",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "TodosMarkAllDoneInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "TodosMarkAllDonePayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "toggleAwardEmoji",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "ToggleAwardEmojiInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "ToggleAwardEmojiPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updateNote",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "UpdateNoteInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "UpdateNotePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updateSnippet",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "UpdateSnippetInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "UpdateSnippetPayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "AddAwardEmojiPayload",
       :description "Autogenerated return type of AddAwardEmoji",
       :fields
       [{:name "awardEmoji",
         :description "The award emoji after mutation",
         :args [],
         :type {:kind "OBJECT", :name "AwardEmoji", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "AwardEmoji",
       :description nil,
       :fields
       [{:name "description",
         :description "The emoji description",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "emoji",
         :description "The emoji as an icon",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description "The emoji name",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "unicode",
         :description "The emoji in unicode",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "unicodeVersion",
         :description "The unicode version for this emoji",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "user",
         :description "The user who awarded the emoji",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "User", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "AddAwardEmojiInput",
       :description "Autogenerated input type of AddAwardEmoji",
       :fields nil,
       :inputFields
       [{:name "awardableId",
         :description "The global id of the awardable resource",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "name",
         :description "The emoji name",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "RemoveAwardEmojiPayload",
       :description "Autogenerated return type of RemoveAwardEmoji",
       :fields
       [{:name "awardEmoji",
         :description "The award emoji after mutation",
         :args [],
         :type {:kind "OBJECT", :name "AwardEmoji", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "RemoveAwardEmojiInput",
       :description "Autogenerated input type of RemoveAwardEmoji",
       :fields nil,
       :inputFields
       [{:name "awardableId",
         :description "The global id of the awardable resource",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "name",
         :description "The emoji name",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "ToggleAwardEmojiPayload",
       :description "Autogenerated return type of ToggleAwardEmoji",
       :fields
       [{:name "awardEmoji",
         :description "The award emoji after mutation",
         :args [],
         :type {:kind "OBJECT", :name "AwardEmoji", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "toggledOn",
         :description
         "True when the emoji was awarded, false when it was removed",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "ToggleAwardEmojiInput",
       :description "Autogenerated input type of ToggleAwardEmoji",
       :fields nil,
       :inputFields
       [{:name "awardableId",
         :description "The global id of the awardable resource",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "name",
         :description "The emoji name",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "IssueSetConfidentialPayload",
       :description
       "Autogenerated return type of IssueSetConfidential",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issue",
         :description "The issue after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Issue", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "IssueSetConfidentialInput",
       :description "Autogenerated input type of IssueSetConfidential",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the issue to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the issue to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "confidential",
         :description
         "Whether or not to set the issue as a confidential.",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "IssueSetDueDatePayload",
       :description "Autogenerated return type of IssueSetDueDate",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issue",
         :description "The issue after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Issue", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "IssueSetDueDateInput",
       :description "Autogenerated input type of IssueSetDueDate",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the issue to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the issue to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "dueDate",
         :description "The desired due date for the issue",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestSetLabelsPayload",
       :description
       "Autogenerated return type of MergeRequestSetLabels",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "The merge request after mutation",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MergeRequestSetLabelsInput",
       :description
       "Autogenerated input type of MergeRequestSetLabels",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the merge request to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the merge request to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "labelIds",
         :description
         "The Label IDs to set. Replaces existing labels by default.\n",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "ID", :ofType nil}}}},
         :defaultValue nil}
        {:name "operationMode",
         :description
         "Changes the operation mode. Defaults to REPLACE.\n",
         :type
         {:kind "ENUM", :name "MutationOperationMode", :ofType nil},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "MutationOperationMode",
       :description "Different toggles for changing mutator behavior.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "REPLACE",
         :description "Performs a replace operation",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "APPEND",
         :description "Performs an append operation",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "REMOVE",
         :description "Performs a removal operation",
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestSetLockedPayload",
       :description
       "Autogenerated return type of MergeRequestSetLocked",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "The merge request after mutation",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MergeRequestSetLockedInput",
       :description
       "Autogenerated input type of MergeRequestSetLocked",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the merge request to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the merge request to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "locked",
         :description "Whether or not to lock the merge request.\n",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestSetMilestonePayload",
       :description
       "Autogenerated return type of MergeRequestSetMilestone",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "The merge request after mutation",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MergeRequestSetMilestoneInput",
       :description
       "Autogenerated input type of MergeRequestSetMilestone",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the merge request to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the merge request to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "milestoneId",
         :description
         "The milestone to assign to the merge request.\n",
         :type {:kind "SCALAR", :name "ID", :ofType nil},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestSetSubscriptionPayload",
       :description
       "Autogenerated return type of MergeRequestSetSubscription",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "The merge request after mutation",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MergeRequestSetSubscriptionInput",
       :description
       "Autogenerated input type of MergeRequestSetSubscription",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the merge request to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the merge request to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "subscribedState",
         :description "The desired state of the subscription",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestSetWipPayload",
       :description "Autogenerated return type of MergeRequestSetWip",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "The merge request after mutation",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MergeRequestSetWipInput",
       :description "Autogenerated input type of MergeRequestSetWip",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the merge request to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the merge request to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "wip",
         :description
         "Whether or not to set the merge request as a WIP.\n",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestSetAssigneesPayload",
       :description
       "Autogenerated return type of MergeRequestSetAssignees",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "The merge request after mutation",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MergeRequestSetAssigneesInput",
       :description
       "Autogenerated input type of MergeRequestSetAssignees",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the merge request to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the merge request to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "assigneeUsernames",
         :description
         "The usernames to assign to the merge request. Replaces existing assignees by default.\n",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :defaultValue nil}
        {:name "operationMode",
         :description
         "The operation to perform. Defaults to REPLACE.\n",
         :type
         {:kind "ENUM", :name "MutationOperationMode", :ofType nil},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "CreateNotePayload",
       :description "Autogenerated return type of CreateNote",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "note",
         :description "The note after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Note", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "CreateNoteInput",
       :description "Autogenerated input type of CreateNote",
       :fields nil,
       :inputFields
       [{:name "noteableId",
         :description "The global id of the resource to add a note to",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "body",
         :description "Content of the note",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "discussionId",
         :description
         "The global id of the discussion this note is in reply to",
         :type {:kind "SCALAR", :name "ID", :ofType nil},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "CreateDiffNotePayload",
       :description "Autogenerated return type of CreateDiffNote",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "note",
         :description "The note after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Note", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "CreateDiffNoteInput",
       :description "Autogenerated input type of CreateDiffNote",
       :fields nil,
       :inputFields
       [{:name "noteableId",
         :description "The global id of the resource to add a note to",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "body",
         :description "Content of the note",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "position",
         :description "The position of this note on a diff",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "INPUT_OBJECT",
           :name "DiffPositionInput",
           :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "DiffPositionInput",
       :description nil,
       :fields nil,
       :inputFields
       [{:name "headSha",
         :description
         "SHA of the HEAD at the time the comment was made",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "baseSha",
         :description
         "Merge base of the branch the comment was made on",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "startSha",
         :description "SHA of the branch being compared against",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "paths",
         :description
         "The paths of the file that was changed. Both of the properties of this input are optional, but at least one of them is required",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "INPUT_OBJECT", :name "DiffPathsInput", :ofType nil}},
         :defaultValue nil}
        {:name "oldLine",
         :description "Line on start SHA that was changed",
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :defaultValue nil}
        {:name "newLine",
         :description "Line on HEAD SHA that was changed",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "DiffPathsInput",
       :description nil,
       :fields nil,
       :inputFields
       [{:name "oldPath",
         :description "The path of the file on the start sha",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "newPath",
         :description "The path of the file on the head sha",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "CreateImageDiffNotePayload",
       :description "Autogenerated return type of CreateImageDiffNote",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "note",
         :description "The note after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Note", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "CreateImageDiffNoteInput",
       :description "Autogenerated input type of CreateImageDiffNote",
       :fields nil,
       :inputFields
       [{:name "noteableId",
         :description "The global id of the resource to add a note to",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "body",
         :description "Content of the note",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "position",
         :description "The position of this note on a diff",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "INPUT_OBJECT",
           :name "DiffImagePositionInput",
           :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "DiffImagePositionInput",
       :description nil,
       :fields nil,
       :inputFields
       [{:name "headSha",
         :description
         "SHA of the HEAD at the time the comment was made",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "baseSha",
         :description
         "Merge base of the branch the comment was made on",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "startSha",
         :description "SHA of the branch being compared against",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "paths",
         :description
         "The paths of the file that was changed. Both of the properties of this input are optional, but at least one of them is required",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "INPUT_OBJECT", :name "DiffPathsInput", :ofType nil}},
         :defaultValue nil}
        {:name "x",
         :description "X position on which the comment was made",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :defaultValue nil}
        {:name "y",
         :description "Y position on which the comment was made",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :defaultValue nil}
        {:name "width",
         :description "Total width of the image",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :defaultValue nil}
        {:name "height",
         :description "Total height of the image",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "UpdateNotePayload",
       :description "Autogenerated return type of UpdateNote",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "note",
         :description "The note after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Note", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "UpdateNoteInput",
       :description "Autogenerated input type of UpdateNote",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the note to update",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "body",
         :description "Content of the note",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DestroyNotePayload",
       :description "Autogenerated return type of DestroyNote",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "note",
         :description "The note after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Note", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "DestroyNoteInput",
       :description "Autogenerated input type of DestroyNote",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the note to destroy",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TodoMarkDonePayload",
       :description "Autogenerated return type of TodoMarkDone",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "todo",
         :description "The requested todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "Todo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "TodoMarkDoneInput",
       :description "Autogenerated input type of TodoMarkDone",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the todo to mark as done",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TodoRestorePayload",
       :description "Autogenerated return type of TodoRestore",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "todo",
         :description "The requested todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "Todo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "TodoRestoreInput",
       :description "Autogenerated input type of TodoRestore",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the todo to restore",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TodosMarkAllDonePayload",
       :description "Autogenerated return type of TodosMarkAllDone",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedIds",
         :description "Ids of the updated todos",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "ID", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "TodosMarkAllDoneInput",
       :description "Autogenerated input type of TodosMarkAllDone",
       :fields nil,
       :inputFields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DestroySnippetPayload",
       :description "Autogenerated return type of DestroySnippet",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippet",
         :description "The snippet after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Snippet", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "DestroySnippetInput",
       :description "Autogenerated input type of DestroySnippet",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the snippet to destroy",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "UpdateSnippetPayload",
       :description "Autogenerated return type of UpdateSnippet",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippet",
         :description "The snippet after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Snippet", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "UpdateSnippetInput",
       :description "Autogenerated input type of UpdateSnippet",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the snippet to update",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "title",
         :description "Title of the snippet",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "fileName",
         :description "File name of the snippet",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "content",
         :description "Content of the snippet",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "description",
         :description "Description of the snippet",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "visibilityLevel",
         :description "The visibility level of the snippet",
         :type
         {:kind "ENUM", :name "VisibilityLevelsEnum", :ofType nil},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "CreateSnippetPayload",
       :description "Autogenerated return type of CreateSnippet",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippet",
         :description "The snippet after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Snippet", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "CreateSnippetInput",
       :description "Autogenerated input type of CreateSnippet",
       :fields nil,
       :inputFields
       [{:name "title",
         :description "Title of the snippet",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "fileName",
         :description "File name of the snippet",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "content",
         :description "Content of the snippet",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "description",
         :description "Description of the snippet",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "visibilityLevel",
         :description "The visibility level of the snippet",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "ENUM", :name "VisibilityLevelsEnum", :ofType nil}},
         :defaultValue nil}
        {:name "projectPath",
         :description
         "The project full path the snippet is associated with",
         :type {:kind "SCALAR", :name "ID", :ofType nil},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MarkAsSpamSnippetPayload",
       :description "Autogenerated return type of MarkAsSpamSnippet",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippet",
         :description "The snippet after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Snippet", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MarkAsSpamSnippetInput",
       :description "Autogenerated input type of MarkAsSpamSnippet",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the snippet to update",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "__Schema",
       :description
       "A GraphQL Schema defines the capabilities of a GraphQL server. It exposes all available types and directives on the server, as well as the entry points for query, mutation, and subscription operations.",
       :fields
       [{:name "directives",
         :description
         "A list of all directives supported by this server.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "OBJECT", :name "__Directive", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mutationType",
         :description
         "If this server supports mutation, the type that mutation operations will be rooted at.",
         :args [],
         :type {:kind "OBJECT", :name "__Type", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "queryType",
         :description
         "The type that query operations will be rooted at.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "__Type", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "subscriptionType",
         :description
         "If this server support subscription, the type that subscription operations will be rooted at.",
         :args [],
         :type {:kind "OBJECT", :name "__Type", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "types",
         :description "A list of all types supported by this server.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "OBJECT", :name "__Type", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "__Type",
       :description
       "The fundamental unit of any GraphQL Schema is the type. There are many kinds of types in GraphQL as represented by the `__TypeKind` enum.\n\nDepending on the kind of a type, certain fields describe information about that type. Scalar types provide no information beyond a name and description, while Enum types provide their values. Object and Interface types provide the fields they describe. Abstract types, Union and Interface, provide the Object types possible at runtime. List and NonNull types compose other types.",
       :fields
       [{:name "description",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "enumValues",
         :description nil,
         :args
         [{:name "includeDeprecated",
           :description nil,
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "NON_NULL",
           :name nil,
           :ofType
           {:kind "OBJECT", :name "__EnumValue", :ofType nil}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fields",
         :description nil,
         :args
         [{:name "includeDeprecated",
           :description nil,
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "NON_NULL",
           :name nil,
           :ofType {:kind "OBJECT", :name "__Field", :ofType nil}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "inputFields",
         :description nil,
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "NON_NULL",
           :name nil,
           :ofType
           {:kind "OBJECT", :name "__InputValue", :ofType nil}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "interfaces",
         :description nil,
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "NON_NULL",
           :name nil,
           :ofType {:kind "OBJECT", :name "__Type", :ofType nil}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "kind",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "__TypeKind", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "ofType",
         :description nil,
         :args [],
         :type {:kind "OBJECT", :name "__Type", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "possibleTypes",
         :description nil,
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "NON_NULL",
           :name nil,
           :ofType {:kind "OBJECT", :name "__Type", :ofType nil}}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "__Field",
       :description
       "Object and Interface types are described by a list of Fields, each of which has a name, potentially a list of arguments, and a return type.",
       :fields
       [{:name "args",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "OBJECT", :name "__InputValue", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "deprecationReason",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "isDeprecated",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "__Type", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "__Directive",
       :description
       "A Directive provides a way to describe alternate runtime execution and type validation behavior in a GraphQL document.\n\nIn some cases, you need to provide options to alter GraphQL's execution behavior in ways field arguments will not suffice, such as conditionally including or skipping a field. Directives provide this by describing additional information to the executor.",
       :fields
       [{:name "args",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "OBJECT", :name "__InputValue", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "locations",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "ENUM",
             :name "__DirectiveLocation",
             :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "onField",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated true,
         :deprecationReason "Use `locations`."}
        {:name "onFragment",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated true,
         :deprecationReason "Use `locations`."}
        {:name "onOperation",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated true,
         :deprecationReason "Use `locations`."}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "__EnumValue",
       :description
       "One possible value for a given Enum. Enum values are unique values, not a placeholder for a string or numeric value. However an Enum value is returned in a JSON response as a string.",
       :fields
       [{:name "deprecationReason",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "isDeprecated",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "__InputValue",
       :description
       "Arguments provided to Fields or Directives and the input fields of an InputObject are represented as Input Values which describe their type and optionally a default value.",
       :fields
       [{:name "defaultValue",
         :description
         "A GraphQL-formatted string representing the default value for this input value.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "__Type", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "__TypeKind",
       :description
       "An enum describing what kind of type a given `__Type` is.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "SCALAR",
         :description "Indicates this type is a scalar.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "OBJECT",
         :description
         "Indicates this type is an object. `fields` and `interfaces` are valid fields.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "INTERFACE",
         :description
         "Indicates this type is an interface. `fields` and `possibleTypes` are valid fields.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "UNION",
         :description
         "Indicates this type is a union. `possibleTypes` is a valid field.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "ENUM",
         :description
         "Indicates this type is an enum. `enumValues` is a valid field.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "INPUT_OBJECT",
         :description
         "Indicates this type is an input object. `inputFields` is a valid field.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "LIST",
         :description
         "Indicates this type is a list. `ofType` is a valid field.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "NON_NULL",
         :description
         "Indicates this type is a non-null. `ofType` is a valid field.",
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "__DirectiveLocation",
       :description
       "A Directive can be adjacent to many parts of the GraphQL language, a __DirectiveLocation describes one such possible adjacencies.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "QUERY",
         :description "Location adjacent to a query operation.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "MUTATION",
         :description "Location adjacent to a mutation operation.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "SUBSCRIPTION",
         :description "Location adjacent to a subscription operation.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "FIELD",
         :description "Location adjacent to a field.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "FRAGMENT_DEFINITION",
         :description "Location adjacent to a fragment definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "FRAGMENT_SPREAD",
         :description "Location adjacent to a fragment spread.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "INLINE_FRAGMENT",
         :description "Location adjacent to an inline fragment.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "SCHEMA",
         :description "Location adjacent to a schema definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "SCALAR",
         :description "Location adjacent to a scalar definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "OBJECT",
         :description
         "Location adjacent to an object type definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "FIELD_DEFINITION",
         :description "Location adjacent to a field definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "ARGUMENT_DEFINITION",
         :description "Location adjacent to an argument definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "INTERFACE",
         :description "Location adjacent to an interface definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "UNION",
         :description "Location adjacent to a union definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "ENUM",
         :description "Location adjacent to an enum definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "ENUM_VALUE",
         :description "Location adjacent to an enum value definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "INPUT_OBJECT",
         :description
         "Location adjacent to an input object type definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "INPUT_FIELD_DEFINITION",
         :description
         "Location adjacent to an input object field definition.",
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}],
     :directives
     [{:name "include",
       :description
       "Directs the executor to include this field or fragment only when the `if` argument is true.",
       :locations ["FIELD" "FRAGMENT_SPREAD" "INLINE_FRAGMENT"],
       :args
       [{:name "if",
         :description "Included when true.",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :defaultValue nil}]}
      {:name "skip",
       :description
       "Directs the executor to skip this field or fragment when the `if` argument is true.",
       :locations ["FIELD" "FRAGMENT_SPREAD" "INLINE_FRAGMENT"],
       :args
       [{:name "if",
         :description "Skipped when true.",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :defaultValue nil}]}
      {:name "deprecated",
       :description
       "Marks an element of a GraphQL schema as no longer supported.",
       :locations ["FIELD_DEFINITION" "ENUM_VALUE"],
       :args
       [{:name "reason",
         :description
         "Explains why this element was deprecated, usually also including a suggestion for how to access supported similar data. Formatted in [Markdown](https://daringfireball.net/projects/markdown/).",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue "\"No longer supported\""}]}]}}})


(def gitlab-schema-explore
  {:data
   {:__schema
    {:queryType {:name "Query"},
     :mutationType {:name "Mutation"},
     :subscriptionType nil,
     :types
     [{:kind "SCALAR",
       :name "Boolean",
       :description "Represents `true` or `false` values.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "SCALAR",
       :name "String",
       :description
       "Represents textual data as UTF-8 character sequences. This type is most often used by GraphQL to represent free-form human-readable text.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Query",
       :description nil,
       :fields
       [{:name "currentUser",
         :description "Get information about current user",
         :args [],
         :type {:kind "OBJECT", :name "User", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "echo",
         :description "Text to echo back",
         :args
         [{:name "text",
           :description "Text to echo back",
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        
        {:name "metadata",
         :description "Metadata about GitLab",
         :args [],
         :type {:kind "OBJECT", :name "Metadata", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "namespace",
         :description "Find a namespace",
         :args
         [{:name "fullPath",
           :description
           "The full path of the project, group or namespace, e.g., \"gitlab-org/gitlab-foss\"",
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "Namespace", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "project",
         :description "Find a project",
         :args
         [{:name "fullPath",
           :description
           "The full path of the project, group or namespace, e.g., \"gitlab-org/gitlab-foss\"",
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "Project", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippets",
         :description "Find Snippets visible to the current user",
         :args
         [{:name "ids",
           :description
           "Array of global snippet ids, e.g., \"gid://gitlab/ProjectSnippet/1\"",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "ID", :ofType nil}}},
           :defaultValue nil}
          {:name "visibility",
           :description "The visibility of the snippet",
           :type
           {:kind "ENUM", :name "VisibilityScopesEnum", :ofType nil},
           :defaultValue nil}
          {:name "authorId",
           :description "The ID of an author",
           :type {:kind "SCALAR", :name "ID", :ofType nil},
           :defaultValue nil}
          {:name "projectId",
           :description "The ID of a project",
           :type {:kind "SCALAR", :name "ID", :ofType nil},
           :defaultValue nil}
          {:name "type",
           :description "The type of snippet",
           :type {:kind "ENUM", :name "TypeEnum", :ofType nil},
           :defaultValue nil}
          {:name "explore",
           :description "Explore personal snippets",
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "SnippetConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Project",
       :description nil,
       :fields
       [{:name "archived",
         :description "Archived status of the project",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "avatarUrl",
         :description "URL to avatar image file of the project",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "containerRegistryEnabled",
         :description
         "Indicates if the project stores Docker container images in a container registry",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description "Timestamp of the project creation",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description "Short description of the project",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "forksCount",
         :description "Number of times the project has been forked",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fullPath",
         :description "Full path of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "group",
         :description "Group of the project",
         :args [],
         :type {:kind "OBJECT", :name "Group", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "httpUrlToRepo",
         :description "URL to connect to the project via HTTPS",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "importStatus",
         :description
         "Status of project import background job of the project",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issue",
         :description "A single issue of the project",
         :args
         [{:name "iid",
           :description "IID of the issue. For example, \"1\"",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "iids",
           :description "List of IIDs of issues. For example, [1, 2]",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "String", :ofType nil}}},
           :defaultValue nil}
          {:name "state",
           :description "Current state of this issue",
           :type {:kind "ENUM", :name "IssuableState", :ofType nil},
           :defaultValue nil}
          {:name "labelName",
           :description "Labels applied to this issue",
           :type
           {:kind "LIST",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}},
           :defaultValue nil}
          {:name "createdBefore",
           :description "Issues created before this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "createdAfter",
           :description "Issues created after this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "updatedBefore",
           :description "Issues updated before this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "updatedAfter",
           :description "Issues updated after this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "closedBefore",
           :description "Issues closed before this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "closedAfter",
           :description "Issues closed after this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "search",
           :description
           "Search query for finding issues by title or description",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "sort",
           :description "Sort issues by this criteria",
           :type {:kind "ENUM", :name "IssueSort", :ofType nil},
           :defaultValue "created_desc"}],
         :type {:kind "OBJECT", :name "Issue", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issues",
         :description "Issues of the project",
         :args
         [{:name "iid",
           :description "IID of the issue. For example, \"1\"",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "iids",
           :description "List of IIDs of issues. For example, [1, 2]",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "String", :ofType nil}}},
           :defaultValue nil}
          {:name "state",
           :description "Current state of this issue",
           :type {:kind "ENUM", :name "IssuableState", :ofType nil},
           :defaultValue nil}
          {:name "labelName",
           :description "Labels applied to this issue",
           :type
           {:kind "LIST",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}},
           :defaultValue nil}
          {:name "createdBefore",
           :description "Issues created before this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "createdAfter",
           :description "Issues created after this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "updatedBefore",
           :description "Issues updated before this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "updatedAfter",
           :description "Issues updated after this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "closedBefore",
           :description "Issues closed before this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "closedAfter",
           :description "Issues closed after this date",
           :type {:kind "SCALAR", :name "Time", :ofType nil},
           :defaultValue nil}
          {:name "search",
           :description
           "Search query for finding issues by title or description",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "sort",
           :description "Sort issues by this criteria",
           :type {:kind "ENUM", :name "IssueSort", :ofType nil},
           :defaultValue "created_desc"}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "IssueConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issuesEnabled",
         :description
         "(deprecated) Does this project have issues enabled?. Use `issues_access_level` instead",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "jobsEnabled",
         :description
         "(deprecated) Enable jobs for this project. Use `builds_access_level` instead",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lastActivityAt",
         :description "Timestamp of the project last activity",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lfsEnabled",
         :description
         "Indicates if the project has Large File Storage (LFS) enabled",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "A single merge request of the project",
         :args
         [{:name "iid",
           :description "The IID of the merge request, e.g., \"1\"",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "iids",
           :description "The list of IIDs of issues, e.g., [1, 2]",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "String", :ofType nil}}},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequests",
         :description "Merge requests of the project",
         :args
         [{:name "iid",
           :description "The IID of the merge request, e.g., \"1\"",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "iids",
           :description "The list of IIDs of issues, e.g., [1, 2]",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "String", :ofType nil}}},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "MergeRequestConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestsEnabled",
         :description
         "(deprecated) Does this project have merge_requests enabled?. Use `merge_requests_access_level` instead",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestsFfOnlyEnabled",
         :description
         "Indicates if no merge commits should be created and all merges should instead be fast-forwarded, which means that merging is only allowed if the branch could be fast-forwarded.",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description "Name of the project (without namespace)",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nameWithNamespace",
         :description "Full name of the project with its namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "namespace",
         :description "Namespace of the project",
         :args [],
         :type {:kind "OBJECT", :name "Namespace", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "onlyAllowMergeIfAllDiscussionsAreResolved",
         :description
         "Indicates if merge requests of the project can only be merged when all the discussions are resolved",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "onlyAllowMergeIfPipelineSucceeds",
         :description
         "Indicates if merge requests of the project can only be merged with successful jobs",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "openIssuesCount",
         :description "Number of open issues for the project",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description "Path of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pipelines",
         :description "Build pipelines of the project",
         :args
         [{:name "status",
           :description "Filter pipelines by their status",
           :type
           {:kind "ENUM", :name "PipelineStatusEnum", :ofType nil},
           :defaultValue nil}
          {:name "ref",
           :description "Filter pipelines by the ref they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "sha",
           :description
           "Filter pipelines by the sha of the commit they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "PipelineConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "printingMergeRequestLinkEnabled",
         :description
         "Indicates if a link to create or view a merge request should display after a push to Git repositories of the project from the command line",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "publicJobs",
         :description
         "Indicates if there is public access to pipelines and job details of the project, including output logs and artifacts",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "removeSourceBranchAfterMerge",
         :description
         "Indicates if `Delete source branch` option should be enabled by default for all new merge requests of the project",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "repository",
         :description "Git repository of the project",
         :args [],
         :type {:kind "OBJECT", :name "Repository", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "requestAccessEnabled",
         :description
         "Indicates if users can request member access to the project",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sentryDetailedError",
         :description
         "Detailed version of a Sentry error on the project",
         :args
         [{:name "id",
           :description "ID of the Sentry issue",
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "SentryDetailedError", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sharedRunnersEnabled",
         :description
         "Indicates if shared runners are enabled on the project",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippets",
         :description "Snippets of the project",
         :args
         [{:name "ids",
           :description
           "Array of global snippet ids, e.g., \"gid://gitlab/ProjectSnippet/1\"",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "ID", :ofType nil}}},
           :defaultValue nil}
          {:name "visibility",
           :description "The visibility of the snippet",
           :type
           {:kind "ENUM", :name "VisibilityScopesEnum", :ofType nil},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "SnippetConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippetsEnabled",
         :description
         "(deprecated) Does this project have snippets enabled?. Use `snippets_access_level` instead",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sshUrlToRepo",
         :description "URL to connect to the project via SSH",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "starCount",
         :description "Number of times the project has been starred",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "statistics",
         :description "Statistics of the project",
         :args [],
         :type
         {:kind "OBJECT", :name "ProjectStatistics", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "tagList",
         :description "List of project tags",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "ProjectPermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "visibility",
         :description "Visibility of the project",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the project",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "wikiEnabled",
         :description
         "(deprecated) Does this project have wiki enabled?. Use `wiki_access_level` instead",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "ProjectPermissions",
       :description nil,
       :fields
       [{:name "adminOperations",
         :description
         "Whether or not a user can perform `admin_operations` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "adminProject",
         :description
         "Whether or not a user can perform `admin_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "adminRemoteMirror",
         :description
         "Whether or not a user can perform `admin_remote_mirror` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "adminWiki",
         :description
         "Whether or not a user can perform `admin_wiki` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "archiveProject",
         :description
         "Whether or not a user can perform `archive_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "changeNamespace",
         :description
         "Whether or not a user can perform `change_namespace` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "changeVisibilityLevel",
         :description
         "Whether or not a user can perform `change_visibility_level` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createDeployment",
         :description
         "Whether or not a user can perform `create_deployment` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createIssue",
         :description
         "Whether or not a user can perform `create_issue` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createLabel",
         :description
         "Whether or not a user can perform `create_label` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createMergeRequestFrom",
         :description
         "Whether or not a user can perform `create_merge_request_from` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createMergeRequestIn",
         :description
         "Whether or not a user can perform `create_merge_request_in` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createPages",
         :description
         "Whether or not a user can perform `create_pages` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createPipeline",
         :description
         "Whether or not a user can perform `create_pipeline` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createPipelineSchedule",
         :description
         "Whether or not a user can perform `create_pipeline_schedule` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createSnippet",
         :description
         "Whether or not a user can perform `create_snippet` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createWiki",
         :description
         "Whether or not a user can perform `create_wiki` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "destroyPages",
         :description
         "Whether or not a user can perform `destroy_pages` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "destroyWiki",
         :description
         "Whether or not a user can perform `destroy_wiki` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "downloadCode",
         :description
         "Whether or not a user can perform `download_code` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "downloadWikiCode",
         :description
         "Whether or not a user can perform `download_wiki_code` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "forkProject",
         :description
         "Whether or not a user can perform `fork_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pushCode",
         :description
         "Whether or not a user can perform `push_code` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pushToDeleteProtectedBranch",
         :description
         "Whether or not a user can perform `push_to_delete_protected_branch` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readCommitStatus",
         :description
         "Whether or not a user can perform `read_commit_status` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readCycleAnalytics",
         :description
         "Whether or not a user can perform `read_cycle_analytics` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readPagesContent",
         :description
         "Whether or not a user can perform `read_pages_content` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readProject",
         :description
         "Whether or not a user can perform `read_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readProjectMember",
         :description
         "Whether or not a user can perform `read_project_member` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readWiki",
         :description
         "Whether or not a user can perform `read_wiki` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "removeForkProject",
         :description
         "Whether or not a user can perform `remove_fork_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "removePages",
         :description
         "Whether or not a user can perform `remove_pages` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "removeProject",
         :description
         "Whether or not a user can perform `remove_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "renameProject",
         :description
         "Whether or not a user can perform `rename_project` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "requestAccess",
         :description
         "Whether or not a user can perform `request_access` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatePages",
         :description
         "Whether or not a user can perform `update_pages` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updateWiki",
         :description
         "Whether or not a user can perform `update_wiki` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "uploadFile",
         :description
         "Whether or not a user can perform `upload_file` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "SCALAR",
       :name "ID",
       :description
       "Represents a unique identifier that is Base64 obfuscated. It is often used to refetch an object or as key for a cache. The ID type appears in a JSON response as a String; however, it is not intended to be human-readable. When expected as an input type, any string (such as `\"VXNlci0xMA==\"`) or integer (such as `4`) input value will be accepted as an ID.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "SCALAR",
       :name "Int",
       :description
       "Represents non-fractional signed whole numeric values. Int can represent values between -(2^31) and 2^31 - 1.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "SCALAR",
       :name "Time",
       :description "Time represented in ISO 8601",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Namespace",
       :description nil,
       :fields
       [{:name "description",
         :description "Description of the namespace",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fullName",
         :description "Full name of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fullPath",
         :description "Full path of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lfsEnabled",
         :description
         "Indicates if Large File Storage (LFS) is enabled for namespace",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description "Name of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description "Path of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "projects",
         :description "Projects within this namespace",
         :args
         [{:name "includeSubgroups",
           :description "Include also subgroup projects",
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "ProjectConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "requestAccessEnabled",
         :description
         "Indicates if users can request access to namespace",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "rootStorageStatistics",
         :description
         "Aggregated storage statistics of the namespace. Only available for root namespaces",
         :args [],
         :type
         {:kind "OBJECT", :name "RootStorageStatistics", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "visibility",
         :description "Visibility of the namespace",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "RootStorageStatistics",
       :description nil,
       :fields
       [{:name "buildArtifactsSize",
         :description "The CI artifacts size in bytes",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lfsObjectsSize",
         :description "The LFS objects size in bytes",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "packagesSize",
         :description "The packages size in bytes",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "repositorySize",
         :description "The Git repository size in bytes",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "storageSize",
         :description "The total storage in bytes",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "wikiSize",
         :description "The wiki size in bytes",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "ProjectConnection",
       :description "The connection type for Project.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "ProjectEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Project", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "PageInfo",
       :description "Information about pagination in a connection.",
       :fields
       [{:name "endCursor",
         :description
         "When paginating forwards, the cursor to continue.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "hasNextPage",
         :description
         "When paginating forwards, are there more items?",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "hasPreviousPage",
         :description
         "When paginating backwards, are there more items?",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "startCursor",
         :description
         "When paginating backwards, the cursor to continue.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "ProjectEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Project", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Group",
       :description nil,
       :fields
       [{:name "avatarUrl",
         :description "Avatar URL of the group",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description "Description of the namespace",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fullName",
         :description "Full name of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fullPath",
         :description "Full path of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lfsEnabled",
         :description
         "Indicates if Large File Storage (LFS) is enabled for namespace",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description "Name of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "parent",
         :description "Parent group",
         :args [],
         :type {:kind "OBJECT", :name "Group", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description "Path of the namespace",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "projects",
         :description "Projects within this namespace",
         :args
         [{:name "includeSubgroups",
           :description "Include also subgroup projects",
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "ProjectConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "requestAccessEnabled",
         :description
         "Indicates if users can request access to namespace",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "rootStorageStatistics",
         :description
         "Aggregated storage statistics of the namespace. Only available for root namespaces",
         :args [],
         :type
         {:kind "OBJECT", :name "RootStorageStatistics", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "GroupPermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "visibility",
         :description "Visibility of the namespace",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the group",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "GroupPermissions",
       :description nil,
       :fields
       [{:name "readGroup",
         :description
         "Whether or not a user can perform `read_group` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "ProjectStatistics",
       :description nil,
       :fields
       [{:name "buildArtifactsSize",
         :description "Build artifacts size of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "commitCount",
         :description "Commit count of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lfsObjectsSize",
         :description
         "Large File Storage (LFS) object size of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "packagesSize",
         :description "Packages size of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "repositorySize",
         :description "Repository size of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "storageSize",
         :description "Storage size of the project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "wikiSize",
         :description "Wiki size of the project",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Repository",
       :description nil,
       :fields
       [{:name "empty",
         :description "Indicates repository has no visible content",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "exists",
         :description
         "Indicates a corresponding Git repository exists on disk",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "rootRef",
         :description "Default branch of the repository",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "tree",
         :description "Tree of the repository",
         :args
         [{:name "path",
           :description
           "The path to get the tree for. Default value is the root of the repository",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue "\"\""}
          {:name "ref",
           :description
           "The commit ref to get the tree for. Default value is HEAD",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue "\"head\""}
          {:name "recursive",
           :description
           "Used to get a recursive tree. Default is false",
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}],
         :type {:kind "OBJECT", :name "Tree", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Tree",
       :description nil,
       :fields
       [{:name "blobs",
         :description nil,
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "BlobConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lastCommit",
         :description "Last commit for the tree",
         :args [],
         :type {:kind "OBJECT", :name "Commit", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "submodules",
         :description nil,
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "SubmoduleConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "trees",
         :description nil,
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "TreeEntryConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Commit",
       :description nil,
       :fields
       [{:name "author",
         :description "Author of the commit",
         :args [],
         :type {:kind "OBJECT", :name "User", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "authorName",
         :description "Commit authors name",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "authoredDate",
         :description "Timestamp of when the commit was authored",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description "Description of the commit message",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID (global ID) of the commit",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "latestPipeline",
         :description "Latest pipeline of the commit",
         :args
         [{:name "status",
           :description "Filter pipelines by their status",
           :type
           {:kind "ENUM", :name "PipelineStatusEnum", :ofType nil},
           :defaultValue nil}
          {:name "ref",
           :description "Filter pipelines by the ref they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "sha",
           :description
           "Filter pipelines by the sha of the commit they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "Pipeline", :ofType nil},
         :isDeprecated true,
         :deprecationReason "use pipelines"}
        {:name "message",
         :description "Raw commit message",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pipelines",
         :description "Pipelines of the commit ordered latest first",
         :args
         [{:name "status",
           :description "Filter pipelines by their status",
           :type
           {:kind "ENUM", :name "PipelineStatusEnum", :ofType nil},
           :defaultValue nil}
          {:name "ref",
           :description "Filter pipelines by the ref they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "sha",
           :description
           "Filter pipelines by the sha of the commit they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "PipelineConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sha",
         :description "SHA1 ID of the commit",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "signatureHtml",
         :description "Rendered HTML of the commit signature",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Title of the commit message",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the commit",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "User",
       :description nil,
       :fields
       [{:name "avatarUrl",
         :description "URL of the user's avatar",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description "Human-readable name of the user",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippets",
         :description "Snippets authored by the user",
         :args
         [{:name "ids",
           :description
           "Array of global snippet ids, e.g., \"gid://gitlab/ProjectSnippet/1\"",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "ID", :ofType nil}}},
           :defaultValue nil}
          {:name "visibility",
           :description "The visibility of the snippet",
           :type
           {:kind "ENUM", :name "VisibilityScopesEnum", :ofType nil},
           :defaultValue nil}
          {:name "type",
           :description "The type of snippet",
           :type {:kind "ENUM", :name "TypeEnum", :ofType nil},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "SnippetConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "todos",
         :description "Todos of the user",
         :args
         [{:name "action",
           :description "The action to be filtered",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType
             {:kind "ENUM", :name "TodoActionEnum", :ofType nil}}},
           :defaultValue nil}
          {:name "authorId",
           :description "The ID of an author",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "ID", :ofType nil}}},
           :defaultValue nil}
          {:name "projectId",
           :description "The ID of a project",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "ID", :ofType nil}}},
           :defaultValue nil}
          {:name "groupId",
           :description "The ID of a group",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType {:kind "SCALAR", :name "ID", :ofType nil}}},
           :defaultValue nil}
          {:name "state",
           :description "The state of the todo",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType
             {:kind "ENUM", :name "TodoStateEnum", :ofType nil}}},
           :defaultValue nil}
          {:name "type",
           :description "The type of the todo",
           :type
           {:kind "LIST",
            :name nil,
            :ofType
            {:kind "NON_NULL",
             :name nil,
             :ofType
             {:kind "ENUM", :name "TodoTargetEnum", :ofType nil}}},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "TodoConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "UserPermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "username",
         :description
         "Username of the user. Unique within this instance of GitLab",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the user",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "UserPermissions",
       :description nil,
       :fields
       [{:name "createSnippet",
         :description
         "Whether or not a user can perform `create_snippet` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TodoConnection",
       :description "The connection type for Todo.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "TodoEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Todo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TodoEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Todo", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Todo",
       :description "Representing a todo entry",
       :fields
       [{:name "action",
         :description "Action of the todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "TodoActionEnum", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "author",
         :description "The owner of this todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "User", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "body",
         :description "Body of the todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description "Timestamp this todo was created",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "group",
         :description "Group this todo is associated with",
         :args [],
         :type {:kind "OBJECT", :name "Group", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "Id of the todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "project",
         :description "The project this todo is associated with",
         :args [],
         :type {:kind "OBJECT", :name "Project", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "state",
         :description "State of the todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "TodoStateEnum", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "targetType",
         :description "Target type of the todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "TodoTargetEnum", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "TodoActionEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "assigned",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mentioned",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "build_failed",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "marked",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "approval_required",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "unmergeable",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "directly_addressed",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "TodoTargetEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "COMMIT",
         :description "A Commit",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "ISSUE",
         :description "An Issue",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "MERGEREQUEST",
         :description "A MergeRequest",
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "TodoStateEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "pending",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "done",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SnippetConnection",
       :description "The connection type for Snippet.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "SnippetEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Snippet", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SnippetEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Snippet", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Snippet",
       :description "Represents a snippet entry",
       :fields
       [{:name "author",
         :description "The owner of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "User", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "content",
         :description "Content of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description "Timestamp this snippet was created",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description "Description of the snippet",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "discussions",
         :description "All discussions on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "DiscussionConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fileName",
         :description "File Name of the snippet",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "Id of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "notes",
         :description "All notes on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "NoteConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "project",
         :description "The project the snippet is associated with",
         :args [],
         :type {:kind "OBJECT", :name "Project", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "rawUrl",
         :description "Raw URL of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Title of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedAt",
         :description "Timestamp this snippet was updated",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "SnippetPermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "visibilityLevel",
         :description "Visibility Level of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "ENUM", :name "VisibilityLevelsEnum", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the snippet",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces
       [{:kind "INTERFACE", :name "Noteable", :ofType nil}],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INTERFACE",
       :name "Noteable",
       :description nil,
       :fields
       [{:name "discussions",
         :description "All discussions on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "DiscussionConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "notes",
         :description "All notes on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "NoteConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes
       [{:kind "OBJECT", :name "Issue", :ofType nil}
        {:kind "OBJECT", :name "MergeRequest", :ofType nil}
        {:kind "OBJECT", :name "Snippet", :ofType nil}]}
      {:kind "OBJECT",
       :name "NoteConnection",
       :description "The connection type for Note.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "NoteEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Note", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "NoteEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Note", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Note",
       :description nil,
       :fields
       [{:name "author",
         :description "User who wrote this note",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "User", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "body",
         :description "Content of the note",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "bodyHtml",
         :description
         "The GitLab Flavored Markdown rendering of `note`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description "Timestamp of the note creation",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "discussion",
         :description "The discussion this note is a part of",
         :args [],
         :type {:kind "OBJECT", :name "Discussion", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of the note",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "position",
         :description "The position of this note on a diff",
         :args [],
         :type {:kind "OBJECT", :name "DiffPosition", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "project",
         :description "Project associated with the note",
         :args [],
         :type {:kind "OBJECT", :name "Project", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "resolvable",
         :description
         "Indicates if this note can be resolved. That is, if it is a resolvable discussion or simply a standalone note",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "resolvedAt",
         :description "Timestamp of the note's resolution",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "resolvedBy",
         :description "User that resolved the discussion",
         :args [],
         :type {:kind "OBJECT", :name "User", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "system",
         :description
         "Indicates whether this note was created by the system or by a user",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedAt",
         :description "Timestamp of the note's last activity",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "NotePermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "NotePermissions",
       :description nil,
       :fields
       [{:name "adminNote",
         :description
         "Whether or not a user can perform `admin_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "awardEmoji",
         :description
         "Whether or not a user can perform `award_emoji` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createNote",
         :description
         "Whether or not a user can perform `create_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readNote",
         :description
         "Whether or not a user can perform `read_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "resolveNote",
         :description
         "Whether or not a user can perform `resolve_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Discussion",
       :description nil,
       :fields
       [{:name "createdAt",
         :description "Timestamp of the discussion's creation",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of this discussion",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "notes",
         :description "All notes in the discussion",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "NoteConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "replyId",
         :description "ID used to reply to this discussion",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DiffPosition",
       :description nil,
       :fields
       [{:name "diffRefs",
         :description
         "Information about the branch, HEAD, and base at the time of commenting",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "DiffRefs", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "filePath",
         :description "Path of the file that was changed",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "height",
         :description "Total height of the image",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "newLine",
         :description "Line on HEAD SHA that was changed",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "newPath",
         :description "Path of the file on the HEAD SHA",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "oldLine",
         :description "Line on start SHA that was changed",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "oldPath",
         :description "Path of the file on the start SHA",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "positionType",
         :description "Type of file the position refers to",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "ENUM", :name "DiffPositionType", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "width",
         :description "Total width of the image",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "x",
         :description "X position on which the comment was made",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "y",
         :description "Y position on which the comment was made",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DiffRefs",
       :description nil,
       :fields
       [{:name "baseSha",
         :description
         "Merge base of the branch the comment was made on",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "headSha",
         :description
         "SHA of the HEAD at the time the comment was made",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "startSha",
         :description "SHA of the branch being compared against",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "DiffPositionType",
       :description "Type of file the position refers to",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "text",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "image",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DiscussionConnection",
       :description "The connection type for Discussion.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "DiscussionEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Discussion", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DiscussionEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Discussion", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SnippetPermissions",
       :description nil,
       :fields
       [{:name "adminSnippet",
         :description
         "Whether or not a user can perform `admin_snippet` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "awardEmoji",
         :description
         "Whether or not a user can perform `award_emoji` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createNote",
         :description
         "Whether or not a user can perform `create_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readSnippet",
         :description
         "Whether or not a user can perform `read_snippet` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "reportSnippet",
         :description
         "Whether or not a user can perform `report_snippet` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updateSnippet",
         :description
         "Whether or not a user can perform `update_snippet` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "VisibilityLevelsEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "private",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "internal",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "public",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "VisibilityScopesEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "private",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "internal",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "public",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "TypeEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "personal",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "project",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "PipelineConnection",
       :description "The connection type for Pipeline.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "PipelineEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Pipeline", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "PipelineEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Pipeline", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Pipeline",
       :description nil,
       :fields
       [{:name "beforeSha",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "committedAt",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "coverage",
         :description "Coverage percentage",
         :args [],
         :type {:kind "SCALAR", :name "Float", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "detailedStatus",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "DetailedStatus", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "duration",
         :description "Duration of the pipeline in seconds",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "finishedAt",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "iid",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sha",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "startedAt",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "status",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "ENUM", :name "PipelineStatusEnum", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedAt",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "PipelinePermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "PipelinePermissions",
       :description nil,
       :fields
       [{:name "adminPipeline",
         :description
         "Whether or not a user can perform `admin_pipeline` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "destroyPipeline",
         :description
         "Whether or not a user can perform `destroy_pipeline` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatePipeline",
         :description
         "Whether or not a user can perform `update_pipeline` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "PipelineStatusEnum",
       :description nil,
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "CREATED",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "PREPARING",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "PENDING",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "RUNNING",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "FAILED",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "SUCCESS",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "CANCELED",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "SKIPPED",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "MANUAL",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "SCHEDULED",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DetailedStatus",
       :description nil,
       :fields
       [{:name "detailsPath",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "favicon",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "group",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "hasDetails",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "icon",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "label",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "text",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "tooltip",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "SCALAR",
       :name "Float",
       :description
       "Represents signed double-precision fractional values as specified by [IEEE 754](https://en.wikipedia.org/wiki/IEEE_floating_point).",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TreeEntryConnection",
       :description "The connection type for TreeEntry.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "TreeEntryEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "TreeEntry", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TreeEntryEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "TreeEntry", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TreeEntry",
       :description "Represents a directory",
       :fields
       [{:name "flatPath",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sha",
         :description "Last commit sha for entry",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "EntryType", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [{:kind "INTERFACE", :name "Entry", :ofType nil}],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INTERFACE",
       :name "Entry",
       :description nil,
       :fields
       [{:name "flatPath",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sha",
         :description "Last commit sha for entry",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "EntryType", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces nil,
       :enumValues nil,
       :possibleTypes
       [{:kind "OBJECT", :name "Blob", :ofType nil}
        {:kind "OBJECT", :name "Submodule", :ofType nil}
        {:kind "OBJECT", :name "TreeEntry", :ofType nil}]}
      {:kind "ENUM",
       :name "EntryType",
       :description "Type of a tree entry",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "tree",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "blob",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "commit",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SubmoduleConnection",
       :description "The connection type for Submodule.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "SubmoduleEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Submodule", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SubmoduleEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Submodule", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Submodule",
       :description nil,
       :fields
       [{:name "flatPath",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sha",
         :description "Last commit sha for entry",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "treeUrl",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "EntryType", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [{:kind "INTERFACE", :name "Entry", :ofType nil}],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "BlobConnection",
       :description "The connection type for Blob.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "BlobEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Blob", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "BlobEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Blob", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Blob",
       :description nil,
       :fields
       [{:name "flatPath",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lfsOid",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "path",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sha",
         :description "Last commit sha for entry",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "EntryType", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [{:kind "INTERFACE", :name "Entry", :ofType nil}],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestConnection",
       :description "The connection type for MergeRequest.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "MergeRequestEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "MergeRequest", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequest",
       :description nil,
       :fields
       [{:name "allowCollaboration",
         :description
         "Indicates if members of the target project can push to the fork",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "assignees",
         :description "Assignees of the merge request",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "UserConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description
         "Timestamp of when the merge request was created",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "defaultMergeCommitMessage",
         :description
         "Default merge commit message of the merge request",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description
         "Description of the merge request (Markdown rendered as HTML for caching)",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "diffHeadSha",
         :description "Diff head SHA of the merge request",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "diffRefs",
         :description
         "References of the base SHA, the head SHA, and the start SHA for this merge request",
         :args [],
         :type {:kind "OBJECT", :name "DiffRefs", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "discussionLocked",
         :description
         "Indicates if comments on the merge request are locked to members only",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "discussions",
         :description "All discussions on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "DiscussionConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "downvotes",
         :description "Number of downvotes for the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "forceRemoveSourceBranch",
         :description
         "Indicates if the project settings will lead to source branch deletion after merge",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "headPipeline",
         :description
         "The pipeline running on the branch HEAD of the merge request",
         :args [],
         :type {:kind "OBJECT", :name "Pipeline", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "iid",
         :description "Internal ID of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "inProgressMergeCommitSha",
         :description
         "Commit SHA of the merge request if merge is in progress",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "labels",
         :description "Labels of the merge request",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "LabelConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeCommitMessage",
         :description
         "Deprecated - renamed to defaultMergeCommitMessage",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated true,
         :deprecationReason "Renamed to defaultMergeCommitMessage"}
        {:name "mergeCommitSha",
         :description
         "SHA of the merge request commit (set once merged)",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeError",
         :description "Error message due to a merge error",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeOngoing",
         :description "Indicates if a merge is currently occurring",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeStatus",
         :description "Status of the merge request",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeWhenPipelineSucceeds",
         :description
         "Indicates if the merge has been set to be merged when its pipeline succeeds (MWPS)",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeableDiscussionsState",
         :description
         "Indicates if all discussions in the merge request have been resolved, allowing the merge request to be merged",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "milestone",
         :description "The milestone of the merge request",
         :args [],
         :type {:kind "OBJECT", :name "Milestone", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "notes",
         :description "All notes on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "NoteConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "participants",
         :description "Participants in the merge request",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "UserConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pipelines",
         :description "Pipelines for the merge request",
         :args
         [{:name "status",
           :description "Filter pipelines by their status",
           :type
           {:kind "ENUM", :name "PipelineStatusEnum", :ofType nil},
           :defaultValue nil}
          {:name "ref",
           :description "Filter pipelines by the ref they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "sha",
           :description
           "Filter pipelines by the sha of the commit they are run for",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "PipelineConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "project",
         :description "Alias for target_project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "Project", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "projectId",
         :description "ID of the merge request project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "rebaseCommitSha",
         :description "Rebase commit SHA of the merge request",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "rebaseInProgress",
         :description
         "Indicates if there is a rebase currently in progress for the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "reference",
         :description
         "Internal reference of the merge request. Returned in shortened format by default",
         :args
         [{:name "full",
           :description
           "Boolean option specifying whether the reference should be returned in full",
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "shouldBeRebased",
         :description "Indicates if the merge request will be rebased",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "shouldRemoveSourceBranch",
         :description
         "Indicates if the source branch of the merge request will be deleted after merge",
         :args [],
         :type {:kind "SCALAR", :name "Boolean", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sourceBranch",
         :description "Source branch of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sourceBranchExists",
         :description
         "Indicates if the source branch of the merge request exists",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sourceProject",
         :description "Source project of the merge request",
         :args [],
         :type {:kind "OBJECT", :name "Project", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sourceProjectId",
         :description "ID of the merge request source project",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "state",
         :description "State of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "ENUM", :name "MergeRequestState", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "subscribed",
         :description
         "Indicates if the currently logged in user is subscribed to this merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "targetBranch",
         :description "Target branch of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "targetProject",
         :description "Target project of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "Project", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "targetProjectId",
         :description "ID of the merge request target project",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "taskCompletionStatus",
         :description "Completion status of tasks",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "TaskCompletionStatus", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "timeEstimate",
         :description "Time estimate of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Title of the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "titleHtml",
         :description
         "The GitLab Flavored Markdown rendering of `title`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "totalTimeSpent",
         :description
         "Total time reported as spent on the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedAt",
         :description
         "Timestamp of when the merge request was last updated",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "upvotes",
         :description "Number of upvotes for the merge request",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userNotesCount",
         :description "User notes count of the merge request",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT",
           :name "MergeRequestPermissions",
           :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the merge request",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "workInProgress",
         :description
         "Indicates if the merge request is a work in progress (WIP)",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces
       [{:kind "INTERFACE", :name "Noteable", :ofType nil}],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestPermissions",
       :description
       "Check permissions for the current user on a merge request",
       :fields
       [{:name "adminMergeRequest",
         :description
         "Whether or not a user can perform `admin_merge_request` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "cherryPickOnCurrentMergeRequest",
         :description
         "Whether or not a user can perform `cherry_pick_on_current_merge_request` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createNote",
         :description
         "Whether or not a user can perform `create_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pushToSourceBranch",
         :description
         "Whether or not a user can perform `push_to_source_branch` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readMergeRequest",
         :description
         "Whether or not a user can perform `read_merge_request` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "removeSourceBranch",
         :description
         "Whether or not a user can perform `remove_source_branch` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "revertOnCurrentMergeRequest",
         :description
         "Whether or not a user can perform `revert_on_current_merge_request` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updateMergeRequest",
         :description
         "Whether or not a user can perform `update_merge_request` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "MergeRequestState",
       :description "State of a GitLab merge request",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "opened",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "closed",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "locked",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "merged",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Milestone",
       :description nil,
       :fields
       [{:name "createdAt",
         :description "Timestamp of milestone creation",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description "Description of the milestone",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "dueDate",
         :description "Timestamp of the milestone due date",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID of the milestone",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "startDate",
         :description "Timestamp of the milestone start date",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "state",
         :description "State of the milestone",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Title of the milestone",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedAt",
         :description "Timestamp of last milestone update",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "UserConnection",
       :description "The connection type for User.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "UserEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "User", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "UserEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "User", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "LabelConnection",
       :description "The connection type for Label.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "LabelEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Label", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "LabelEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Label", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Label",
       :description nil,
       :fields
       [{:name "color",
         :description "Background color of the label",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description
         "Description of the label (Markdown rendered as HTML for caching)",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "Label ID",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "textColor",
         :description "Text color of the label",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Content of the label",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TaskCompletionStatus",
       :description "Completion status of tasks",
       :fields
       [{:name "completedCount",
         :description "Number of completed tasks",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "count",
         :description "Number of total tasks",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "IssueConnection",
       :description "The connection type for Issue.",
       :fields
       [{:name "edges",
         :description "A list of edges.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "IssueEdge", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "nodes",
         :description "A list of nodes.",
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType {:kind "OBJECT", :name "Issue", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "pageInfo",
         :description "Information to aid in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "PageInfo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "IssueEdge",
       :description "An edge in a connection.",
       :fields
       [{:name "cursor",
         :description "A cursor for use in pagination.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "node",
         :description "The item at the end of the edge.",
         :args [],
         :type {:kind "OBJECT", :name "Issue", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Issue",
       :description nil,
       :fields
       [{:name "assignees",
         :description "Assignees of the issue",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "UserConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "author",
         :description "User that created the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "User", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "closedAt",
         :description "Timestamp of when the issue was closed",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "confidential",
         :description "Indicates the issue is confidential",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createdAt",
         :description "Timestamp of when the issue was created",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description "Description of the issue",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "descriptionHtml",
         :description
         "The GitLab Flavored Markdown rendering of `description`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "discussionLocked",
         :description "Indicates discussion is locked on the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "discussions",
         :description "All discussions on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "DiscussionConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "downvotes",
         :description "Number of downvotes the issue has received",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "dueDate",
         :description "Due date of the issue",
         :args [],
         :type {:kind "SCALAR", :name "Time", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "iid",
         :description "Internal ID of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "labels",
         :description "Labels of the issue",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "LabelConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "milestone",
         :description "Milestone of the issue",
         :args [],
         :type {:kind "OBJECT", :name "Milestone", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "notes",
         :description "All notes on this noteable",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "NoteConnection", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "participants",
         :description "List of participants in the issue",
         :args
         [{:name "after",
           :description
           "Returns the elements in the list that come after the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "before",
           :description
           "Returns the elements in the list that come before the specified cursor.",
           :type {:kind "SCALAR", :name "String", :ofType nil},
           :defaultValue nil}
          {:name "first",
           :description
           "Returns the first _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}
          {:name "last",
           :description "Returns the last _n_ elements from the list.",
           :type {:kind "SCALAR", :name "Int", :ofType nil},
           :defaultValue nil}],
         :type {:kind "OBJECT", :name "UserConnection", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "reference",
         :description
         "Internal reference of the issue. Returned in shortened format by default",
         :args
         [{:name "full",
           :description
           "Boolean option specifying whether the reference should be returned in full",
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "relativePosition",
         :description
         "Relative position of the issue (used for positioning in epic tree and issue boards)",
         :args [],
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "state",
         :description "State of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "IssueState", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "subscribed",
         :description
         "Boolean flag for whether the currently logged in user is subscribed to this issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "taskCompletionStatus",
         :description "Task completion status of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "TaskCompletionStatus", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "timeEstimate",
         :description "Time estimate of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Title of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "titleHtml",
         :description
         "The GitLab Flavored Markdown rendering of `title`",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "totalTimeSpent",
         :description "Total time reported as spent on the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedAt",
         :description "Timestamp of when the issue was last updated",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "upvotes",
         :description "Number of upvotes the issue has received",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userNotesCount",
         :description "Number of user notes of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userPermissions",
         :description
         "Permissions for the current user on the resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "OBJECT", :name "IssuePermissions", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webPath",
         :description "Web path of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "webUrl",
         :description "Web URL of the issue",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces
       [{:kind "INTERFACE", :name "Noteable", :ofType nil}],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "IssuePermissions",
       :description
       "Check permissions for the current user on a issue",
       :fields
       [{:name "adminIssue",
         :description
         "Whether or not a user can perform `admin_issue` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createNote",
         :description
         "Whether or not a user can perform `create_note` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "readIssue",
         :description
         "Whether or not a user can perform `read_issue` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "reopenIssue",
         :description
         "Whether or not a user can perform `reopen_issue` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updateIssue",
         :description
         "Whether or not a user can perform `update_issue` on this resource",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "IssueState",
       :description "State of a GitLab issue",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "opened",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "closed",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "locked",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "IssuableState",
       :description "State of a GitLab issue or merge request",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "opened",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "closed",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}
        {:name "locked",
         :description nil,
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "IssueSort",
       :description "Values for sorting issues",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "updated_desc",
         :description "Updated at descending order",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updated_asc",
         :description "Updated at ascending order",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "created_desc",
         :description "Created at descending order",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "created_asc",
         :description "Created at ascending order",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "DUE_DATE_ASC",
         :description "Due date by ascending order",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "DUE_DATE_DESC",
         :description "Due date by descending order",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "RELATIVE_POSITION_ASC",
         :description "Relative position by ascending order",
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SentryDetailedError",
       :description nil,
       :fields
       [{:name "count",
         :description "Count of occurrences",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "culprit",
         :description "Culprit of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "externalUrl",
         :description "External URL of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "firstReleaseLastCommit",
         :description "Commit the error was first seen",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "firstReleaseShortVersion",
         :description "Release version the error was first seen",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "firstSeen",
         :description "Timestamp when the error was first seen",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "frequency",
         :description "Last 24hr stats of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "OBJECT",
             :name "SentryErrorFrequency",
             :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "id",
         :description "ID (global ID) of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lastReleaseLastCommit",
         :description "Commit the error was last seen",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lastReleaseShortVersion",
         :description "Release version the error was last seen",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "lastSeen",
         :description "Timestamp when the error was last seen",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "message",
         :description "Sentry metadata message of the error",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sentryId",
         :description "ID (Sentry ID) of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sentryProjectId",
         :description "ID of the project (Sentry project)",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sentryProjectName",
         :description "Name of the project affected by the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "sentryProjectSlug",
         :description "Slug of the project affected by the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "shortId",
         :description "Short ID (Sentry ID) of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "status",
         :description "Status of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "ENUM", :name "SentryErrorStatus", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "title",
         :description "Title of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description "Type of the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "userCount",
         :description "Count of users affected by the error",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "SentryErrorStatus",
       :description "State of a Sentry error",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "RESOLVED",
         :description "Error has been resolved",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "RESOLVED_IN_NEXT_RELEASE",
         :description "Error has been ignored until next release",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "UNRESOLVED",
         :description "Error is unresolved",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "IGNORED",
         :description "Error has been ignored",
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "SentryErrorFrequency",
       :description nil,
       :fields
       [{:name "count",
         :description
         "Count of errors received since the previously recorded time",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "time",
         :description "Time the error frequency stats were recorded",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Metadata",
       :description nil,
       :fields
       [{:name "revision",
         :description "Revision",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "version",
         :description "Version",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "Mutation",
       :description nil,
       :fields
       [{:name "addAwardEmoji",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "AddAwardEmojiInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "AddAwardEmojiPayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createDiffNote",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "CreateDiffNoteInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "CreateDiffNotePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createImageDiffNote",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "CreateImageDiffNoteInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "CreateImageDiffNotePayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createNote",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "CreateNoteInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "CreateNotePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "createSnippet",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "CreateSnippetInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "CreateSnippetPayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "destroyNote",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "DestroyNoteInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "DestroyNotePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "destroySnippet",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "DestroySnippetInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "DestroySnippetPayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issueSetConfidential",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "IssueSetConfidentialInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "IssueSetConfidentialPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issueSetDueDate",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "IssueSetDueDateInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "IssueSetDueDatePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "markAsSpamSnippet",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MarkAsSpamSnippetInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MarkAsSpamSnippetPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestSetAssignees",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MergeRequestSetAssigneesInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MergeRequestSetAssigneesPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestSetLabels",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MergeRequestSetLabelsInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MergeRequestSetLabelsPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestSetLocked",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MergeRequestSetLockedInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MergeRequestSetLockedPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestSetMilestone",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MergeRequestSetMilestoneInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MergeRequestSetMilestonePayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestSetSubscription",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MergeRequestSetSubscriptionInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MergeRequestSetSubscriptionPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequestSetWip",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "MergeRequestSetWipInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "MergeRequestSetWipPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "removeAwardEmoji",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "RemoveAwardEmojiInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "RemoveAwardEmojiPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "todoMarkDone",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "TodoMarkDoneInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "TodoMarkDonePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "todoRestore",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "TodoRestoreInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "TodoRestorePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "todosMarkAllDone",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "TodosMarkAllDoneInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "TodosMarkAllDonePayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "toggleAwardEmoji",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "ToggleAwardEmojiInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT",
          :name "ToggleAwardEmojiPayload",
          :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updateNote",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "UpdateNoteInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "UpdateNotePayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updateSnippet",
         :description nil,
         :args
         [{:name "input",
           :description nil,
           :type
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "INPUT_OBJECT",
             :name "UpdateSnippetInput",
             :ofType nil}},
           :defaultValue nil}],
         :type
         {:kind "OBJECT", :name "UpdateSnippetPayload", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "AddAwardEmojiPayload",
       :description "Autogenerated return type of AddAwardEmoji",
       :fields
       [{:name "awardEmoji",
         :description "The award emoji after mutation",
         :args [],
         :type {:kind "OBJECT", :name "AwardEmoji", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "AwardEmoji",
       :description nil,
       :fields
       [{:name "description",
         :description "The emoji description",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "emoji",
         :description "The emoji as an icon",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description "The emoji name",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "unicode",
         :description "The emoji in unicode",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "unicodeVersion",
         :description "The unicode version for this emoji",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "user",
         :description "The user who awarded the emoji",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "User", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "AddAwardEmojiInput",
       :description "Autogenerated input type of AddAwardEmoji",
       :fields nil,
       :inputFields
       [{:name "awardableId",
         :description "The global id of the awardable resource",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "name",
         :description "The emoji name",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "RemoveAwardEmojiPayload",
       :description "Autogenerated return type of RemoveAwardEmoji",
       :fields
       [{:name "awardEmoji",
         :description "The award emoji after mutation",
         :args [],
         :type {:kind "OBJECT", :name "AwardEmoji", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "RemoveAwardEmojiInput",
       :description "Autogenerated input type of RemoveAwardEmoji",
       :fields nil,
       :inputFields
       [{:name "awardableId",
         :description "The global id of the awardable resource",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "name",
         :description "The emoji name",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "ToggleAwardEmojiPayload",
       :description "Autogenerated return type of ToggleAwardEmoji",
       :fields
       [{:name "awardEmoji",
         :description "The award emoji after mutation",
         :args [],
         :type {:kind "OBJECT", :name "AwardEmoji", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "toggledOn",
         :description
         "True when the emoji was awarded, false when it was removed",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "ToggleAwardEmojiInput",
       :description "Autogenerated input type of ToggleAwardEmoji",
       :fields nil,
       :inputFields
       [{:name "awardableId",
         :description "The global id of the awardable resource",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "name",
         :description "The emoji name",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "IssueSetConfidentialPayload",
       :description
       "Autogenerated return type of IssueSetConfidential",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issue",
         :description "The issue after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Issue", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "IssueSetConfidentialInput",
       :description "Autogenerated input type of IssueSetConfidential",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the issue to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the issue to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "confidential",
         :description
         "Whether or not to set the issue as a confidential.",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "IssueSetDueDatePayload",
       :description "Autogenerated return type of IssueSetDueDate",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "issue",
         :description "The issue after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Issue", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "IssueSetDueDateInput",
       :description "Autogenerated input type of IssueSetDueDate",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the issue to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the issue to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "dueDate",
         :description "The desired due date for the issue",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Time", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestSetLabelsPayload",
       :description
       "Autogenerated return type of MergeRequestSetLabels",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "The merge request after mutation",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MergeRequestSetLabelsInput",
       :description
       "Autogenerated input type of MergeRequestSetLabels",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the merge request to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the merge request to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "labelIds",
         :description
         "The Label IDs to set. Replaces existing labels by default.\n",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "ID", :ofType nil}}}},
         :defaultValue nil}
        {:name "operationMode",
         :description
         "Changes the operation mode. Defaults to REPLACE.\n",
         :type
         {:kind "ENUM", :name "MutationOperationMode", :ofType nil},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "MutationOperationMode",
       :description "Different toggles for changing mutator behavior.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "REPLACE",
         :description "Performs a replace operation",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "APPEND",
         :description "Performs an append operation",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "REMOVE",
         :description "Performs a removal operation",
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestSetLockedPayload",
       :description
       "Autogenerated return type of MergeRequestSetLocked",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "The merge request after mutation",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MergeRequestSetLockedInput",
       :description
       "Autogenerated input type of MergeRequestSetLocked",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the merge request to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the merge request to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "locked",
         :description "Whether or not to lock the merge request.\n",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestSetMilestonePayload",
       :description
       "Autogenerated return type of MergeRequestSetMilestone",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "The merge request after mutation",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MergeRequestSetMilestoneInput",
       :description
       "Autogenerated input type of MergeRequestSetMilestone",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the merge request to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the merge request to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "milestoneId",
         :description
         "The milestone to assign to the merge request.\n",
         :type {:kind "SCALAR", :name "ID", :ofType nil},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestSetSubscriptionPayload",
       :description
       "Autogenerated return type of MergeRequestSetSubscription",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "The merge request after mutation",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MergeRequestSetSubscriptionInput",
       :description
       "Autogenerated input type of MergeRequestSetSubscription",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the merge request to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the merge request to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "subscribedState",
         :description "The desired state of the subscription",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestSetWipPayload",
       :description "Autogenerated return type of MergeRequestSetWip",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "The merge request after mutation",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MergeRequestSetWipInput",
       :description "Autogenerated input type of MergeRequestSetWip",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the merge request to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the merge request to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "wip",
         :description
         "Whether or not to set the merge request as a WIP.\n",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MergeRequestSetAssigneesPayload",
       :description
       "Autogenerated return type of MergeRequestSetAssignees",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mergeRequest",
         :description "The merge request after mutation",
         :args [],
         :type {:kind "OBJECT", :name "MergeRequest", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MergeRequestSetAssigneesInput",
       :description
       "Autogenerated input type of MergeRequestSetAssignees",
       :fields nil,
       :inputFields
       [{:name "projectPath",
         :description "The project the merge request to mutate is in",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "iid",
         :description "The iid of the merge request to mutate",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "assigneeUsernames",
         :description
         "The usernames to assign to the merge request. Replaces existing assignees by default.\n",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :defaultValue nil}
        {:name "operationMode",
         :description
         "The operation to perform. Defaults to REPLACE.\n",
         :type
         {:kind "ENUM", :name "MutationOperationMode", :ofType nil},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "CreateNotePayload",
       :description "Autogenerated return type of CreateNote",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "note",
         :description "The note after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Note", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "CreateNoteInput",
       :description "Autogenerated input type of CreateNote",
       :fields nil,
       :inputFields
       [{:name "noteableId",
         :description "The global id of the resource to add a note to",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "body",
         :description "Content of the note",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "discussionId",
         :description
         "The global id of the discussion this note is in reply to",
         :type {:kind "SCALAR", :name "ID", :ofType nil},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "CreateDiffNotePayload",
       :description "Autogenerated return type of CreateDiffNote",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "note",
         :description "The note after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Note", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "CreateDiffNoteInput",
       :description "Autogenerated input type of CreateDiffNote",
       :fields nil,
       :inputFields
       [{:name "noteableId",
         :description "The global id of the resource to add a note to",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "body",
         :description "Content of the note",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "position",
         :description "The position of this note on a diff",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "INPUT_OBJECT",
           :name "DiffPositionInput",
           :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "DiffPositionInput",
       :description nil,
       :fields nil,
       :inputFields
       [{:name "headSha",
         :description
         "SHA of the HEAD at the time the comment was made",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "baseSha",
         :description
         "Merge base of the branch the comment was made on",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "startSha",
         :description "SHA of the branch being compared against",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "paths",
         :description
         "The paths of the file that was changed. Both of the properties of this input are optional, but at least one of them is required",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "INPUT_OBJECT", :name "DiffPathsInput", :ofType nil}},
         :defaultValue nil}
        {:name "oldLine",
         :description "Line on start SHA that was changed",
         :type {:kind "SCALAR", :name "Int", :ofType nil},
         :defaultValue nil}
        {:name "newLine",
         :description "Line on HEAD SHA that was changed",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "DiffPathsInput",
       :description nil,
       :fields nil,
       :inputFields
       [{:name "oldPath",
         :description "The path of the file on the start sha",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "newPath",
         :description "The path of the file on the head sha",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "CreateImageDiffNotePayload",
       :description "Autogenerated return type of CreateImageDiffNote",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "note",
         :description "The note after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Note", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "CreateImageDiffNoteInput",
       :description "Autogenerated input type of CreateImageDiffNote",
       :fields nil,
       :inputFields
       [{:name "noteableId",
         :description "The global id of the resource to add a note to",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "body",
         :description "Content of the note",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "position",
         :description "The position of this note on a diff",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "INPUT_OBJECT",
           :name "DiffImagePositionInput",
           :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "DiffImagePositionInput",
       :description nil,
       :fields nil,
       :inputFields
       [{:name "headSha",
         :description
         "SHA of the HEAD at the time the comment was made",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "baseSha",
         :description
         "Merge base of the branch the comment was made on",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "startSha",
         :description "SHA of the branch being compared against",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "paths",
         :description
         "The paths of the file that was changed. Both of the properties of this input are optional, but at least one of them is required",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "INPUT_OBJECT", :name "DiffPathsInput", :ofType nil}},
         :defaultValue nil}
        {:name "x",
         :description "X position on which the comment was made",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :defaultValue nil}
        {:name "y",
         :description "Y position on which the comment was made",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :defaultValue nil}
        {:name "width",
         :description "Total width of the image",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :defaultValue nil}
        {:name "height",
         :description "Total height of the image",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Int", :ofType nil}},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "UpdateNotePayload",
       :description "Autogenerated return type of UpdateNote",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "note",
         :description "The note after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Note", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "UpdateNoteInput",
       :description "Autogenerated input type of UpdateNote",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the note to update",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "body",
         :description "Content of the note",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DestroyNotePayload",
       :description "Autogenerated return type of DestroyNote",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "note",
         :description "The note after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Note", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "DestroyNoteInput",
       :description "Autogenerated input type of DestroyNote",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the note to destroy",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TodoMarkDonePayload",
       :description "Autogenerated return type of TodoMarkDone",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "todo",
         :description "The requested todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "Todo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "TodoMarkDoneInput",
       :description "Autogenerated input type of TodoMarkDone",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the todo to mark as done",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TodoRestorePayload",
       :description "Autogenerated return type of TodoRestore",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "todo",
         :description "The requested todo",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "Todo", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "TodoRestoreInput",
       :description "Autogenerated input type of TodoRestore",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the todo to restore",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "TodosMarkAllDonePayload",
       :description "Autogenerated return type of TodosMarkAllDone",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "updatedIds",
         :description "Ids of the updated todos",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "ID", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "TodosMarkAllDoneInput",
       :description "Autogenerated input type of TodosMarkAllDone",
       :fields nil,
       :inputFields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "DestroySnippetPayload",
       :description "Autogenerated return type of DestroySnippet",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippet",
         :description "The snippet after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Snippet", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "DestroySnippetInput",
       :description "Autogenerated input type of DestroySnippet",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the snippet to destroy",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "UpdateSnippetPayload",
       :description "Autogenerated return type of UpdateSnippet",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippet",
         :description "The snippet after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Snippet", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "UpdateSnippetInput",
       :description "Autogenerated input type of UpdateSnippet",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the snippet to update",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "title",
         :description "Title of the snippet",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "fileName",
         :description "File name of the snippet",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "content",
         :description "Content of the snippet",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "description",
         :description "Description of the snippet",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "visibilityLevel",
         :description "The visibility level of the snippet",
         :type
         {:kind "ENUM", :name "VisibilityLevelsEnum", :ofType nil},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "CreateSnippetPayload",
       :description "Autogenerated return type of CreateSnippet",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippet",
         :description "The snippet after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Snippet", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "CreateSnippetInput",
       :description "Autogenerated input type of CreateSnippet",
       :fields nil,
       :inputFields
       [{:name "title",
         :description "Title of the snippet",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "fileName",
         :description "File name of the snippet",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "content",
         :description "Content of the snippet",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :defaultValue nil}
        {:name "description",
         :description "Description of the snippet",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}
        {:name "visibilityLevel",
         :description "The visibility level of the snippet",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "ENUM", :name "VisibilityLevelsEnum", :ofType nil}},
         :defaultValue nil}
        {:name "projectPath",
         :description
         "The project full path the snippet is associated with",
         :type {:kind "SCALAR", :name "ID", :ofType nil},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "MarkAsSpamSnippetPayload",
       :description "Autogenerated return type of MarkAsSpamSnippet",
       :fields
       [{:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "errors",
         :description "Reasons why the mutation failed.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "SCALAR", :name "String", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "snippet",
         :description "The snippet after mutation",
         :args [],
         :type {:kind "OBJECT", :name "Snippet", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "INPUT_OBJECT",
       :name "MarkAsSpamSnippetInput",
       :description "Autogenerated input type of MarkAsSpamSnippet",
       :fields nil,
       :inputFields
       [{:name "id",
         :description "The global id of the snippet to update",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "ID", :ofType nil}},
         :defaultValue nil}
        {:name "clientMutationId",
         :description
         "A unique identifier for the client performing the mutation.",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue nil}],
       :interfaces nil,
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "__Schema",
       :description
       "A GraphQL Schema defines the capabilities of a GraphQL server. It exposes all available types and directives on the server, as well as the entry points for query, mutation, and subscription operations.",
       :fields
       [{:name "directives",
         :description
         "A list of all directives supported by this server.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "OBJECT", :name "__Directive", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "mutationType",
         :description
         "If this server supports mutation, the type that mutation operations will be rooted at.",
         :args [],
         :type {:kind "OBJECT", :name "__Type", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "queryType",
         :description
         "The type that query operations will be rooted at.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "__Type", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "subscriptionType",
         :description
         "If this server support subscription, the type that subscription operations will be rooted at.",
         :args [],
         :type {:kind "OBJECT", :name "__Type", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "types",
         :description "A list of all types supported by this server.",
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType {:kind "OBJECT", :name "__Type", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "__Type",
       :description
       "The fundamental unit of any GraphQL Schema is the type. There are many kinds of types in GraphQL as represented by the `__TypeKind` enum.\n\nDepending on the kind of a type, certain fields describe information about that type. Scalar types provide no information beyond a name and description, while Enum types provide their values. Object and Interface types provide the fields they describe. Abstract types, Union and Interface, provide the Object types possible at runtime. List and NonNull types compose other types.",
       :fields
       [{:name "description",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "enumValues",
         :description nil,
         :args
         [{:name "includeDeprecated",
           :description nil,
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "NON_NULL",
           :name nil,
           :ofType
           {:kind "OBJECT", :name "__EnumValue", :ofType nil}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "fields",
         :description nil,
         :args
         [{:name "includeDeprecated",
           :description nil,
           :type {:kind "SCALAR", :name "Boolean", :ofType nil},
           :defaultValue "false"}],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "NON_NULL",
           :name nil,
           :ofType {:kind "OBJECT", :name "__Field", :ofType nil}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "inputFields",
         :description nil,
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "NON_NULL",
           :name nil,
           :ofType
           {:kind "OBJECT", :name "__InputValue", :ofType nil}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "interfaces",
         :description nil,
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "NON_NULL",
           :name nil,
           :ofType {:kind "OBJECT", :name "__Type", :ofType nil}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "kind",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "ENUM", :name "__TypeKind", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "ofType",
         :description nil,
         :args [],
         :type {:kind "OBJECT", :name "__Type", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "possibleTypes",
         :description nil,
         :args [],
         :type
         {:kind "LIST",
          :name nil,
          :ofType
          {:kind "NON_NULL",
           :name nil,
           :ofType {:kind "OBJECT", :name "__Type", :ofType nil}}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "__Field",
       :description
       "Object and Interface types are described by a list of Fields, each of which has a name, potentially a list of arguments, and a return type.",
       :fields
       [{:name "args",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "OBJECT", :name "__InputValue", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "deprecationReason",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "isDeprecated",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "__Type", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "__Directive",
       :description
       "A Directive provides a way to describe alternate runtime execution and type validation behavior in a GraphQL document.\n\nIn some cases, you need to provide options to alter GraphQL's execution behavior in ways field arguments will not suffice, such as conditionally including or skipping a field. Directives provide this by describing additional information to the executor.",
       :fields
       [{:name "args",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "OBJECT", :name "__InputValue", :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "locations",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType
          {:kind "LIST",
           :name nil,
           :ofType
           {:kind "NON_NULL",
            :name nil,
            :ofType
            {:kind "ENUM",
             :name "__DirectiveLocation",
             :ofType nil}}}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "onField",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated true,
         :deprecationReason "Use `locations`."}
        {:name "onFragment",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated true,
         :deprecationReason "Use `locations`."}
        {:name "onOperation",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated true,
         :deprecationReason "Use `locations`."}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "__EnumValue",
       :description
       "One possible value for a given Enum. Enum values are unique values, not a placeholder for a string or numeric value. However an Enum value is returned in a JSON response as a string.",
       :fields
       [{:name "deprecationReason",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "isDeprecated",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "OBJECT",
       :name "__InputValue",
       :description
       "Arguments provided to Fields or Directives and the input fields of an InputObject are represented as Input Values which describe their type and optionally a default value.",
       :fields
       [{:name "defaultValue",
         :description
         "A GraphQL-formatted string representing the default value for this input value.",
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "description",
         :description nil,
         :args [],
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "name",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "String", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}
        {:name "type",
         :description nil,
         :args [],
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "OBJECT", :name "__Type", :ofType nil}},
         :isDeprecated false,
         :deprecationReason nil}],
       :inputFields nil,
       :interfaces [],
       :enumValues nil,
       :possibleTypes nil}
      {:kind "ENUM",
       :name "__TypeKind",
       :description
       "An enum describing what kind of type a given `__Type` is.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "SCALAR",
         :description "Indicates this type is a scalar.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "OBJECT",
         :description
         "Indicates this type is an object. `fields` and `interfaces` are valid fields.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "INTERFACE",
         :description
         "Indicates this type is an interface. `fields` and `possibleTypes` are valid fields.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "UNION",
         :description
         "Indicates this type is a union. `possibleTypes` is a valid field.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "ENUM",
         :description
         "Indicates this type is an enum. `enumValues` is a valid field.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "INPUT_OBJECT",
         :description
         "Indicates this type is an input object. `inputFields` is a valid field.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "LIST",
         :description
         "Indicates this type is a list. `ofType` is a valid field.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "NON_NULL",
         :description
         "Indicates this type is a non-null. `ofType` is a valid field.",
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}
      {:kind "ENUM",
       :name "__DirectiveLocation",
       :description
       "A Directive can be adjacent to many parts of the GraphQL language, a __DirectiveLocation describes one such possible adjacencies.",
       :fields nil,
       :inputFields nil,
       :interfaces nil,
       :enumValues
       [{:name "QUERY",
         :description "Location adjacent to a query operation.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "MUTATION",
         :description "Location adjacent to a mutation operation.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "SUBSCRIPTION",
         :description "Location adjacent to a subscription operation.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "FIELD",
         :description "Location adjacent to a field.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "FRAGMENT_DEFINITION",
         :description "Location adjacent to a fragment definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "FRAGMENT_SPREAD",
         :description "Location adjacent to a fragment spread.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "INLINE_FRAGMENT",
         :description "Location adjacent to an inline fragment.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "SCHEMA",
         :description "Location adjacent to a schema definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "SCALAR",
         :description "Location adjacent to a scalar definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "OBJECT",
         :description
         "Location adjacent to an object type definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "FIELD_DEFINITION",
         :description "Location adjacent to a field definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "ARGUMENT_DEFINITION",
         :description "Location adjacent to an argument definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "INTERFACE",
         :description "Location adjacent to an interface definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "UNION",
         :description "Location adjacent to a union definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "ENUM",
         :description "Location adjacent to an enum definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "ENUM_VALUE",
         :description "Location adjacent to an enum value definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "INPUT_OBJECT",
         :description
         "Location adjacent to an input object type definition.",
         :isDeprecated false,
         :deprecationReason nil}
        {:name "INPUT_FIELD_DEFINITION",
         :description
         "Location adjacent to an input object field definition.",
         :isDeprecated false,
         :deprecationReason nil}],
       :possibleTypes nil}],
     :directives
     [{:name "include",
       :description
       "Directs the executor to include this field or fragment only when the `if` argument is true.",
       :locations ["FIELD" "FRAGMENT_SPREAD" "INLINE_FRAGMENT"],
       :args
       [{:name "if",
         :description "Included when true.",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :defaultValue nil}]}
      {:name "skip",
       :description
       "Directs the executor to skip this field or fragment when the `if` argument is true.",
       :locations ["FIELD" "FRAGMENT_SPREAD" "INLINE_FRAGMENT"],
       :args
       [{:name "if",
         :description "Skipped when true.",
         :type
         {:kind "NON_NULL",
          :name nil,
          :ofType {:kind "SCALAR", :name "Boolean", :ofType nil}},
         :defaultValue nil}]}
      {:name "deprecated",
       :description
       "Marks an element of a GraphQL schema as no longer supported.",
       :locations ["FIELD_DEFINITION" "ENUM_VALUE"],
       :args
       [{:name "reason",
         :description
         "Explains why this element was deprecated, usually also including a suggestion for how to access supported similar data. Formatted in [Markdown](https://daringfireball.net/projects/markdown/).",
         :type {:kind "SCALAR", :name "String", :ofType nil},
         :defaultValue "\"No longer supported\""}]}]}}})

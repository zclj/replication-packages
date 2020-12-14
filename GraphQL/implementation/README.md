
# Table of Contents

1.  [GraphQL API test generation with property-based testing](#doc)
    1.  [Setup](#setup)
        1.  [Install Docker](#docker)
        2.  [Install Clojure](#clojure)
        3.  [Setup Gitlab](#gitlab)
    2.  [Running experiments](#experiments)
        1.  [Setup](#setupexp)
        2.  [Monitoring](#monitoring)
        3.  [Coverage experiments](#coverage)
        4.  [Iterations to coverage experiments](#iterations)
        5.  [Fault finding experiments](#faults)


<a id="doc"></a>

# GraphQL API test generation with property-based testing

This repository contains the necessary artifacts to reproduce our experiments. This is not production software, it is a prof of concept, written with experimentation in mind.


<a id="setup"></a>

## Setup


<a id="docker"></a>

### Install Docker

Instructions at [Docker page](https://www.docker.com/)


<a id="clojure"></a>

### Install Clojure

Instructions at [Clojure page](https://clojure.org/)


<a id="gitlab"></a>

### Setup Gitlab

1.  Start Gitlab container

    -   There is an [included shell script](run-gitlab.sh) to run the used version of GitLab
    -   Experiments where run on GitLab 12.6.3-ce.

2.  Create an access token

    1.  Verify that GitLab is running by `docker ps`
    2.  Browse to `localhost`
    3.  You will be prompted to change password for the root user
    4.  Sign in as root
    5.  Append the url with /admin
    6.  At the admin page select `Users`
    7.  Create a new test user, set the `Access level` to `Admin`
    8.  At the test users page, select `Impersonation Tokens`
    9.  Create a token with the scope of `api`
    10. Save the token
    11. Verify with `curl -v --header "Private-Token: <your token>" http://localhost/api/v4/projects`. It should return a 200 result.


<a id="experiments"></a>

## Running experiments


<a id="setupexp"></a>

### Setup

-   Set the value of `token` to your access token in the files using it.


<a id="monitoring"></a>

### Monitoring

-   logs can be found at <http://localhost/admin/logs>, select 'production.log'


<a id="coverage"></a>

### Coverage experiments

The GitLab coverage experiments can be found in [coverage-experiments.clj](src/gql/coverage_experiments.clj). Each experiment can be evaluated as a Clojure form. Our results are stated in comments below each experiment.


<a id="iterations"></a>

### Iterations to coverage experiments

The GitLab experiment of evaluating how many iterations are needed for coverage can be found in [iterations-to-coverage-experiment.clj](src/gql/iterations_to_coverage_experiment.clj). Each experiment can be evaluated as a Clojure form. Our results are stated in comments below each experiment.


<a id="faults"></a>

### Fault finding experiments

The GitLab experiment of finding faults can be found in [fault-finding-experiment.clj](src/gql/fault_finding_experiment.clj). Note that the \`test-property\` is using the \`string\` configured argument generator, to find the faults. The pre-configured argument generators are found in [generators.clj](src/gql/generators.clj). These generators can be customized to the users liking or a new domain specific generator can be supplied by the user.


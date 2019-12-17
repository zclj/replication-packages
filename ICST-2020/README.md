
# Table of Contents

1.  [Open API with property-based testing](#doc)
    1.  [Setup](#setup)
        1.  [Install Docker](#docker)
        2.  [Install Clojure](#clojure)
        3.  [Setup Gitlab](#gitlab)
    2.  [Running experiments](#experiments)
        1.  [Setup](#setupexp)
        2.  [Monitoring](#monitoring)
        3.  [Stateful experiments](#stateful)


<a id="doc"></a>

# Open API with property-based testing

This repository contains the necessary artifacts to reproduce our experiments. This is not production software, it is written with experimentation in mind.


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

    -   There is an [included shell script](run-gitlab-11-2-0.sh) to run the used version of GitLab
    -   Experiments where run on GitLab 11.2 and submitted bugs where verified on 12.0.3 which was the latest release at the time.

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

The GitLab input experiments can be found in [gitlab-experiments.clj](src/openapi_pbt/gitlab_experiments.clj). In the "Experiments" section, each experiment is listen in a `comment` block. Start by evaluating the complete file in your Clojure REPL, this will set things up, and then evaluate the individual experiment to run one by one.


<a id="setupexp"></a>

### Setup

-   Set the value of `url-root` to your root.
-   Set the value of `access-token` to your token.


<a id="monitoring"></a>

### Monitoring

-   logs can be found at <http://localhost/admin/logs>, select 'production.log'


<a id="stateful"></a>

### Stateful experiments

The stateful experiment that produces a sequence of calls is in [gitlab-stateful-experiment.clj](src/openapi_pbt/gitlab_stateful_experiment.clj). The relevant log to check is `~/temp/gitlab/logs/gitlab-rails/production.log`. A suggestion is to run `cat production.log | grep -C 15 TRDeadlock` to see that we produced the stateful sequence that exposes the bug: [POST, PUT, DELETE] => Deadlock


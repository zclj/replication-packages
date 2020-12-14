# graphql-toy

This repo contains the small implementation used to evaluate the fault finding capability of injected bugs.

The [graphql.clj](./src/clj/graphql_toy/routes/services/graphql.clj) file contain the parts of interest to inject bugs. Each bug can be commented in, server restarted and found be using the implementation of the proposed method.

generated using Luminus version "3.57"

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein run 


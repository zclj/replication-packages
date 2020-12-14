#!/bin/bash

# Clean up
rm -rf "$HOME/temp/gitlab/"*

# Run 11.2.0 version of Gitlab
docker run --detach \
  --hostname gitlab.example.com \
  --publish 443:443 --publish 80:80 --publish 22:22 \
  --name gitlab-13.0.12 \
  --volume "$HOME/temp/gitlab/config":/etc/gitlab \
  --volume "$HOME/temp/gitlab/logs":/var/log/gitlab \
  --volume "$HOME/temp/gitlab/data":/var/opt/gitlab \
  gitlab/gitlab-ce:13.0.12-ce.0

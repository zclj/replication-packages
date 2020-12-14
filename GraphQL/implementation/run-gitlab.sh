#!/bin/bash

# Clean up
rm -rf "$HOME/temp/gitlab/"*

# Run 11.2.0 version of Gitlab
docker run --detach \
  --hostname gitlab.example.com \
  --publish 443:443 --publish 80:80 --publish 22:22 \
  --name gitlab-12.6.3 \
  --restart always \
  --volume "$HOME/temp/gitlab/config":/etc/gitlab \
  --volume "$HOME/temp/gitlab/logs":/var/log/gitlab \
  --volume "$HOME/temp/gitlab/data":/var/opt/gitlab \
  gitlab/gitlab-ce:12.6.3-ce.0

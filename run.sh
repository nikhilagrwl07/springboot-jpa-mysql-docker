#!/usr/bin/env bash

docker rm $(docker ps -a -q)
# mvn clean compile package -DskipTests
docker-compose up

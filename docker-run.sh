#!/usr/bin/env bash

mvn clean && mvn package
docker build --no-cache -t com.example/entry entry/.
docker build --no-cache -t com.example/task task/.
docker-compose -f docker-compose.app.yml up --scale task=2
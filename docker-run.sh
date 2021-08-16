#!/usr/bin/env bash

mvn clean && mvn package
docker build --no-cache -t com.example/entry entry/.
docker-compose -f docker-compose.app.yml up
#docker run -ti --network  wallet_local --rm -p 8601:8601 com.example/entry
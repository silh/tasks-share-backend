#!/usr/bin/env bash

docker stop tasks-share-db || true && docker rm tasks-share-db || true
docker run --name=tasks-share-db -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:11.5-alpine

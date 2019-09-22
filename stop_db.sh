#!/usr/bin/env bash

docker stop tasks-share-db || true && docker rm tasks-share-db || true

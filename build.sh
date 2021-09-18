#!/bin/sh

./mvnw clean package
docker rmi quay.io/qiotmanufacturing/datacenter-event-collector-jvm:1.0.0-alpha7 --force
docker build -f src/main/docker/Dockerfile.jvm -t quay.io/qiotmanufacturing/datacenter-event-collector-jvm:1.0.0-alpha7 .
docker push quay.io/qiotmanufacturing/datacenter-event-collector-jvm:1.0.0-alpha7
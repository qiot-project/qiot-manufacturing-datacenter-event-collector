#!/bin/sh

echo "Datacenter - Event Collector Service"
./mvnw clean package
docker build -f src/main/docker/Dockerfile.jvm -t quay.io/qiotmanufacturing/datacenter-event-collector-jvm:1.0.0-alpha7 .
docker push quay.io/qiotmanufacturing/datacenter-event-collector-jvm:1.0.0-alpha7
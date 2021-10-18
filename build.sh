#!/bin/sh

#mvn -B clean package -Pprod oc:build oc:push \
#          -Dquarkus.native.container-build=true \
#          -Dquarkus.container-image.build=true \
#          -Djkube.docker.push.username=${QUAY_MANUFACTURING_USERNAME} \
#          -Djkube.docker.push.password=${QUAY_MANUFACTURING_PASSWORD}



./mvnw clean package
docker rmi quay.io/qiotmanufacturing/datacenter-event-collector-jvm:1.0.0.beta1-SNAPSHOT --force
docker build -f src/main/docker/Dockerfile.jvm -t quay.io/qiotmanufacturing/datacenter-event-collector-jvm:1.0.0.beta1-SNAPSHOT .
docker push quay.io/qiotmanufacturing/datacenter-event-collector-jvm:1.0.0.beta1-SNAPSHOT 
#!/bin/sh

PV=$(mvn org.apache.maven.plugins:maven-help-plugin:3.2.0:evaluate -Dexpression=project.version -q -DforceStdout)-aarch64
docker login quay.io -u ${QUAY_MANUFACTURING_USERNAME} -p ${QUAY_MANUFACTURING_PASSWORD}
docker run --rm --privileged multiarch/qemu-user-static:register --reset
docker rmi quay.io/qiotmanufacturing/datacenter-event-collector:$PV --force
docker build -t quay.io/qiotmanufacturing/datacenter-event-collector:$PV -f src/main/docker/Dockerfile.jvm.multiarch .
docker push quay.io/qiotmanufacturing/datacenter-event-collector:$PV
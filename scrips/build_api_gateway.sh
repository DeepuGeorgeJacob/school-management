#!/bin/sh
cd ..
echo "Gradle action initiated"
./gradlew api-gateway:clean
echo "Cleaning completed"


echo "========Building api gateway service======="
./gradlew api-gateway:build
echo "========Api gateway build completed======="

# docker build -t api-gateway:0.1 api-gateway

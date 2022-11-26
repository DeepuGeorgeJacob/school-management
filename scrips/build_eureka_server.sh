#!/bin/sh
cd ..
echo "Gradle action initiated"
./gradlew eureka-server:clean
echo "Cleaning completed"


echo "========Building eureka server======="
./gradlew eureka-server:build
echo "========Eureka server build completed======="

docker build -t eureka-server:0.1 eureka-server

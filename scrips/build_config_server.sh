#!/bin/sh

cd ..
echo "Gradle action initiated"
./gradlew config-server:clean
echo "Cleaning completed"


echo "========Building Config Server======="
./gradlew config-server:build
echo "========Config Server build completed======="
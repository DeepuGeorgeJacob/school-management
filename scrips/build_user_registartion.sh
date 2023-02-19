#!/bin/sh
cd ..
echo "Gradle action initiated"
./gradlew user-registration:clean
echo "Cleaning completed"


echo "========Building User registration service======="
./gradlew user-registration:build
echo "========Student service build completed======="

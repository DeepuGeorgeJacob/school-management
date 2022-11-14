#!/bin/sh
cd ..
echo "Gradle action initiated"
./gradlew student:clean
echo "Cleaning completed"


echo "========Building Student service======="
./gradlew student:build
echo "========Student service build completed======="

#!/bin/sh
cd ..
echo "Gradle action initiated"
./gradlew scheduler:clean
echo "Cleaning completed"


echo "========Building scheduler service======="
./gradlew scheduler:build
echo "========Scheduler service build completed======="

docker build -t scheduler:0.1 scheduler

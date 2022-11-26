#!/bin/sh
cd ..
echo "Gradle action initiated"
./gradlew school-library:clean
echo "Cleaning completed"


echo "========Building school library service======="
./gradlew school-library:build
echo "========School library service build completed======="

docker build -t school-library:0.1 school-library

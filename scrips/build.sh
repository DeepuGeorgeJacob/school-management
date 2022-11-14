#!/bin/sh
echo "Gradle action initiated"
./gradlew clean
echo "Cleaning completed"

echo "========Building eureka server======="
./gradlew eureka-server:build
echo "========Eureka server build completed======="

echo "========Building api gateway======="
./gradlew api-gateway:build
echo "========Api gateway build completed======="

echo "========Building Scheduler======="
./gradlew scheduler:build
echo "========Scheduler build completed======="


echo "========Building Student service======="
./gradlew student:build
echo "========Student service build completed======="

echo "========Building School library service======="
./gradlew school-library:build
echo "========Student service build completed======="

echo "Stopping all containers"
docker stop $(docker ps -a -q)

echo "Removing all containers"
docker rm $(docker ps -a -q)

echo "Cleaning up docker images"


docker image rm api-gateway:0.1
docker image rm eureka-server:0.1
docker image rm scheduler:0.1
docker image rm student:0.1
docker image rm school-library:0.1

echo "Creating eureka server image"

cd eureka-server
docker build -t eureka-server:0.1 .
# shellcheck disable=SC2103
cd ..

echo "Creating api gateway service image"

cd api-gateway
docker build -t api-gateway:0.1 .
cd ..

echo "Creating scheduler service image"

cd scheduler
docker build -t scheduler:0.1 .
cd ..

echo "Creating school-library service image"

cd school-library
docker build -t school-library:0.1 .
cd ..

echo "Creating student service image"

cd student
docker build -t student:0.1 .
cd ..

echo "Create network"

docker network rm microservice_network

docker network create microservice_network

echo "Starting micro services"

# Docker run with enviornment variable

# docker run -p 8761:8761 -d --name eureka-server eureka-server:0.1
# docker run -p 9090:9090 -d -e EUREKA_SERVER='http://172.17.0.2:8761/eureka/' --name api-gateway api-gateway:0.1
# docker run -p 7000:7000 -d -e EUREKA_SERVER='http://172.17.0.2:8761/eureka/' --name scheduler scheduler:0.1
# docker run -p 3001:3001 -d -e EUREKA_SERVER='http://172.17.0.2:8761/eureka/' --name school-library school-library:0.1
# docker run -p 4000:4000 -d -e EUREKA_SERVER='http://172.17.0.2:8761/eureka/' --name student student:0.1

# Docker run without enviornment variable (ENV set in docker file)

# docker run -p 8761:8761 -d --name eureka-server eureka-server:0.1
# docker run -p 9090:9090 -d --name api-gateway api-gateway:0.1
# docker run -p 7000:7000 -d --name scheduler scheduler:0.1
# docker run -p 3001:3001 -d --name school-library school-library:0.1
# docker run -p 4000:4000 -d --name student student:0.1

# Docker run with Network (No need to expose any ports that you want to access in by your system)

docker run -p 8761:8761 -d --name eureka-server --network microservice_network eureka-server:0.1
docker run -p 9090:9090 -d --name api-gateway --network microservice_network api-gateway:0.1
docker run -d --name scheduler --network microservice_network scheduler:0.1
docker run -d --name school-library --network microservice_network school-library:0.1
docker run -d --name student --network microservice_network student:0.1







#!/bin/sh

docker network create pg_network

docker run -d \
	--name postgres \
	-e POSTGRES_USER=admin \
	-e POSTGRES_PASSWORD=secretaryship \
	-e PGDATA=/var/lib/postgresql/data/pgdata \
	-v /Users/deepugeorgejacob/projects/school-management:/var/lib/postgresql/data \
	-p 5432:5432 \
	--network pg_network \
	--rm \
	postgres:17.2-alpine

docker run -d \
	-p 80:80 \
  -e PGADMIN_DEFAULT_EMAIL=admin@example.com \
  -e PGADMIN_DEFAULT_PASSWORD=secretaryship \
  --name pgadmin \
  --network pg_network \
  --rm \
  -d dpage/pgadmin4

# Host or address for the connection
# host.docker.internal



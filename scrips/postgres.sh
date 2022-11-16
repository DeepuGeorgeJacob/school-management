#!/bin/sh

docker run -d \
	--name postres \
	-e POSTGRES_PASSWORD=secretaryship \
	-e PGDATA=/var/lib/postgresql/data/pgdata \
	-v /Users/deepugeorgejacob/projects/school-management:/var/lib/postgresql/data \
	-p 5432:5432 \
	--rm \
	postgres:15.1
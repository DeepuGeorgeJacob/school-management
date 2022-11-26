cd ..

cd eureka-server
docker build -t deepugeorgejacob/eureka-server:0.1 .
docker push deepugeorgejacob/eureka-server:0.1
# shellcheck disable=SC2103
cd ..

cd api-gateway
docker build -t deepugeorgejacob/api-gateway:0.1 .
docker push deepugeorgejacob/api-gateway:0.1

cd ..

cd student
docker build -t deepugeorgejacob/student:0.1 .
docker push deepugeorgejacob/student:0.1


cd ..

cd scheduler
docker build -t deepugeorgejacob/scheduler:0.1 .
docker push deepugeorgejacob/scheduler:0.1

cd ..

cd school-library
docker build -t deepugeorgejacob/school-library:0.1 .
docker push deepugeorgejacob/school-library:0.1


## Configure docker and create docker image
1. Download Docker application from [Docker website](https://www.docker.com/)
2. Install it on your machine
3. Clean and build each microservice separately by using [Commands](GradleCommandToBuild.md)
4. Navigate into each microservices' folder using command line tool. eg:- cd student
5. See the Docker file in the microservice folder.
6. Run docker build [command](#Docker Build)



## Docker Build

1. Navigate to microservice folder.
2. Run command `docker build .`. The dot(.) indicates docker file in the same directory or use step 2 (With name)
3. Run command `docker build -t image_name:version .`. eg:- `docker build -t student:1.0 . `
4. Run command `docker image ls` to see the image we build or download

## Other commands

1. Run command `docker run <image name or id> -p port:port` run the application.
2. Run command `docker container ps` to see the running containers.
3. Run Command `docker stop <container id or name>` to stop running

## Sample Command to build docker images with tag

1. Api gateway `docker build -t api-gateway:0.1 .`
2. Eureka server `docker build -t eureka-server:0.1 .`
3. Scheduler `docker build -t scheduler:0.1 .`
4. Student `docker build -t student:0.1 .`
5. School library `docker build -t school-library:0.1 .`

## Sample command to run docker images
1. Eureka server `docker run -p 8761:8761 eureka-server:0.1`
2. Api gateway `docker run -p 9090:9090 api-gateway:0.1`
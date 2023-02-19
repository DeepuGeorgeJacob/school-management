FROM eclipse-temurin:17-alpine

RUN mkdir /opt/app

COPY build/libs/user-registration-0.0.1-SNAPSHOT.jar /opt/app

EXPOSE 1200

# Connect based on the host machine ip address
#ENV EUREKA_SERVER="http://host.docker.internal:8761/eureka/"

# Connect by using real ip address
# ENV EUREKA_SERVER="http://172.17.0.2:8761/eureka/"

# Connect by using microservice name(Conatiner name) if it is same network (see build.sh file)
ENV EUREKA_SERVER="http://eureka-server:8761/eureka/"

CMD ["java", "-jar", "/opt/app/user-registration-0.0.1-SNAPSHOT.jar"]

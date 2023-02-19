FROM eclipse-temurin:17-alpine

RUN mkdir /opt/app

COPY build/libs/config-server-0.0.1-SNAPSHOT.jar /opt/app

EXPOSE 8888

# Connect by using microservice name(Conatiner name) if it is same network (see build.sh file)
ENV EUREKA_SERVER="http://eureka-server:8761/eureka/"

CMD ["java", "-jar", "/opt/app/config-server-0.0.1-SNAPSHOT.jar"]
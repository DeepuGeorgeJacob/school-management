FROM eclipse-temurin:17-alpine

RUN mkdir /opt/app

COPY build/libs/eureka-server-0.0.1-SNAPSHOT.jar /opt/app

EXPOSE 8761

CMD ["java", "-jar", "/opt/app/eureka-server-0.0.1-SNAPSHOT.jar"]
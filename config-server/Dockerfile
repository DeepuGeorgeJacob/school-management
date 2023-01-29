FROM eclipse-temurin:17-alpine

RUN mkdir /opt/app

COPY build/libs/config-server-0.0.1-SNAPSHOT.jar /opt/app

EXPOSE 8888

CMD ["java", "-jar", "/opt/app/config-server-0.0.1-SNAPSHOT.jar"]
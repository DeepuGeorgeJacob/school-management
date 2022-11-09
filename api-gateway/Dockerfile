FROM eclipse-temurin:11

RUN mkdir /opt/app

COPY build/libs/api-gateway-0.0.1-SNAPSHOT.jar /opt/app

EXPOSE 9090


CMD ["java", "-jar", "/opt/app/api-gateway-0.0.1-SNAPSHOT.jar"]
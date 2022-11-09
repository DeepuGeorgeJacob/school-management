FROM eclipse-temurin:11

RUN mkdir /opt/app

COPY build/libs/scheduler-0.0.1-SNAPSHOT.jar /opt/app

EXPOSE 7000

CMD ["java", "-jar", "/opt/app/scheduler-0.0.1-SNAPSHOT.jar"]
FROM eclipse-temurin:11

RUN mkdir /opt/app

COPY build/libs/student-0.0.1-SNAPSHOT.jar /opt/app

EXPOSE 4000

CMD ["java", "-jar", "/opt/app/student-0.0.1-SNAPSHOT.jar"]

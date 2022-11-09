FROM eclipse-temurin:11

RUN mkdir /opt/app

COPY build/libs/school-library-0.0.1-SNAPSHOT.jar /opt/app

EXPOSE 3001

CMD ["java", "-jar", "/opt/app/school-library-0.0.1-SNAPSHOT.jar"]
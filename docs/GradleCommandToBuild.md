## Build application (This configuration need to be added in the CI/CD system)

### Clean and build eureka-server
- ./gradlew eureka-server:clean
- ./gradlew eureka-server:build

### Clean and build api-gateway
- ./gradlew api-gateway:clean 
- ./gradlew api-gateway:build

### Clean and build student
- ./gradlew student:clean
- ./gradlew student:build

### Clean and school-library
- ./gradlew school-library:clean
- ./gradlew school-library:build

### Clean and scheduler
- ./gradlew scheduler:clean
- ./gradlew scheduler:build


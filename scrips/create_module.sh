cd ..
echo "What is your module name?"
# shellcheck disable=SC2162
read name

chmod -R u+w .
mkdir -p "$name"
chmod -R u+w "$name"

mkdir -p "$name"/src/main/java/com/school/management
mkdir -p "$name"/src/main/resources
mkdir -p "$name"/src/test/java
mkdir -p "$name"/src/test/resources

touch "$name"/src/main/resources/application.properties

#!/bin/bash
echo 'plugins {
    id "java"
    id "org.springframework.boot"
    id "io.spring.dependency-management"
}

group = "$applicationGroup"
version = "$springCloudVersion"
sourceCompatibility="$javaVersion"


dependencies {
compileOnly lombok
annotationProcessor lombok

}' > "$name"/build.gradle

echo "include ':$name'" >> settings.gradle
# shellcheck disable=SC2094
sort settings.gradle > sorted_settings.gradle.tmp
mv sorted_settings.gradle.tmp settings.gradle






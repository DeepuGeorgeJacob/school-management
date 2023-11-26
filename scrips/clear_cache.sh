cd ..
rm -r $HOME/.gradle/caches/

./gradlew dependencies

./gradlew clean build
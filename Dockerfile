FROM openjdk
ARG jar_file=./target/*.jar
COPY ${jar_file} ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./app.jar"]

FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install -Dmaven.test.skip=true

FROM openjdk:17-slim

EXPOSE 8080

COPY --from=build /target/ceai-app-0.0.1-SNAPSHOT.jar ceai-app.jar

ENTRYPOINT ["java", "-jar", "ceai-app.jar"]
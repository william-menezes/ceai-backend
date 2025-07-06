FROM openjdk:17-jdk

COPY target/ceai-app-0.0.1-SNAPSHOT.jar /app/ceai-app.jar

CMD ["java", "-jar", "/app/ceai-app.jar"]
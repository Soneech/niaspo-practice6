FROM openjdk:17-oracle
FROM maven:3.8.1-openjdk-17

WORKDIR /app
COPY games-project-1.0.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
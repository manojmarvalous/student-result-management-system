# Dockerfile for student-result-system

# 1. Use an official OpenJDK 17 runtime as base image
FROM openjdk:17-jdk-slim

# 2. Set working directory inside the container
WORKDIR /app

# 3. Copy the jar file from your local target folder to the container
COPY target/student-result-system-0.0.1-SNAPSHOT.jar app.jar

# 4. Expose the port your Spring Boot app runs on
EXPOSE 8080

# 5. Command to run your Spring Boot jar
ENTRYPOINT ["java","-jar","app.jar"]

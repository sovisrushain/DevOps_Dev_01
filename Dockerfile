# Use a Java 17 runtime as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the Spring Boot executable jar file into the container
COPY target/devopsdemo-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 to the outside world
EXPOSE 8080

# Set the default command to run the Spring Boot app
CMD ["java", "-jar", "app.jar"]
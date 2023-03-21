# Use a Java 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Build the application
RUN mvn clean install

# Set the entrypoint to run the application
ENTRYPOINT ["java", "-jar", "target/devopsdemo.jar"]
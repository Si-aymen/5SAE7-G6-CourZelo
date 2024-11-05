FROM openjdk:11-jre-slim

# Set the JAR name as a build argument
ARG JAR_FILE=target/app.jar

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
COPY ${JAR_FILE} app.jar

# Expose the application port
EXPOSE 8090

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

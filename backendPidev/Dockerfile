# Use a base image that includes Java
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app



# Expose the application port (replace with your app's port if different)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

FROM openjdk:11-jre-slim
ARG JAR_FILE=target/app.jar
WORKDIR /app
COPY ${JAR_FILE} app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]

FROM eclipse-temurin:17.0.9_9-jdk-ubi9-minimal
# Setting up work directory
WORKDIR /app
# Copy the jar file into our app
COPY ./target/demo-0.0.1-SNAPSHOT.jar /app

# Exposing port 8080
EXPOSE 8080
# Starting the application
ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
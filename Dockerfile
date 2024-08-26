# Stage 1: Build the JAR file using Gradle
FROM gradle:latest AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

# Stage 2: Create the final image
FROM openjdk:21-oracle
ENV APP_HOME=/app
WORKDIR $APP_HOME

# Copy the JAR file from the build stage
COPY --from=build /home/gradle/src/build/libs/*.jar $APP_HOME/app.jar

# Expose ports
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
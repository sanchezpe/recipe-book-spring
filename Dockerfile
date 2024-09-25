# Use an official OpenJDK runtime as a parent image
FROM amazoncorretto:21

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY /build/libs/recipe-book-spring-0.0.1-SNAPSHOT.jar /app/recipe-book-spring-0.0.1-SNAPSHOT.jar

# Set the command to run the JAR file
CMD ["java", "-Xmx512m", "-XX:MaxRAM=512m", "-XX:+UseSerialGC", "-jar", "/app/recipe-book-spring-0.0.1-SNAPSHOT.jar"]
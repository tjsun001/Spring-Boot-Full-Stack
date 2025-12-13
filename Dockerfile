# Build argument for Java version
#FROM eclipse-temurin:17-jdk-jammy AS builder
ARG JAVA_VERSION=21


# Stage 1: Build the application
#FROM maven:3.9.4 AS builder
FROM eclipse-temurin:21-jdk-jammy AS builder
WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw
COPY pom.xml .
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=builder /app/target/product-service.jar app.jar
EXPOSE 5050
ENTRYPOINT ["java", "-jar", "app.jar"]
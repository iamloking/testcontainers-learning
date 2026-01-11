# ---------- STAGE 1: Build ----------
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy build descriptors first (for Docker layer caching)
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Download dependencies (cached if pom.xml unchanged)
RUN ./mvnw dependency:go-offline

# Copy application source code
COPY src src

# Build the Spring Boot fat JAR
RUN ./mvnw clean package -DskipTests

# ---------- STAGE 2: Runtime ----------
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy only the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Documentation only; actual binding happens at runtime
EXPOSE 8080

# Default startup command for the container
ENTRYPOINT ["java", "-jar", "app.jar"]

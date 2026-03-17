# backend/Dockerfile
FROM eclipse-temurin:21-jdk-jammy AS build

# Installer Maven dans l'image
RUN apt-get update && apt-get install -y maven

WORKDIR /app
COPY pom.xml ./
COPY src ./src

# Build avec Maven installé dans l'image
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
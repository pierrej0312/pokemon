# backend/Dockerfile
FROM eclipse-temurin:21-jdk-jammy AS build

# Installer Maven
RUN apt-get update && apt-get install -y maven git

WORKDIR /app

# Copier pom.xml d'abord pour profiter du cache Docker
COPY pom.xml ./

# Installer les dépendances y compris plugins (comme jacoco)
RUN mvn dependency:resolve-plugins

# Copier le code source
COPY src ./src

# Build le projet sans tests (ou active les tests si tu veux coverage)
RUN mvn clean package -DskipTests

# Image finale pour exécuter le JAR
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
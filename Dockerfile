# Étape 1 : Utiliser une image Maven pour construire l'application
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app

# Copier le fichier pom.xml et les fichiers sources
COPY pom.xml .
COPY src ./src

# Construire l'application
RUN mvn package -DskipTests

# Étape 2 : Utiliser une image JDK légère pour exécuter l'application
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copier le fichier JAR généré depuis l'étape de build
COPY --from=build /app/target/tp-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 9000

# Lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]-spring.jar"]
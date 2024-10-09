# Dockerfile
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
LABEL version="1.0.0"
LABEL maintainer="rmnlzo8331@gmail.com"
EXPOSE 9000
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} tp.jar 
ENTRYPOINT ["java","-jar","/tp.jar"]
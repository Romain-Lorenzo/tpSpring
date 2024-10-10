# Dockerfile
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
LABEL version="1.0.0"
LABEL maintainer="guillaume.nagiel@gmail.com"
EXPOSE 9000
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} tp-spring.jar 
ENTRYPOINT ["java","-jar","/tp-spring.jar"]
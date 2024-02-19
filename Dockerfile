FROM arm64v8/eclipse-temurin:17.0.10_7-jdk-ubi9-minimal
EXPOSE 8080
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
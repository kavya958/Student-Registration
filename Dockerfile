FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/*.war app.war
ENTRYPOINT ["java", "-jar", "app.war"]



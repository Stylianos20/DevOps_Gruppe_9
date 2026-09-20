# Nutze ein offizielles Java 17 Image als Basis
FROM eclipse-temurin:17-jdk-alpine

# Kopiere die von Maven gebaute JAR-Datei in den Container
COPY target/devops-demo-0.0.1-SNAPSHOT.jar app.jar

# Öffne Port 8080
EXPOSE 8080

# Startbefehl für die Anwendung
ENTRYPOINT ["java", "-jar", "/app.jar"]
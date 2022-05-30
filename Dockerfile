FROM openjdk:11-jre-slim
COPY target/SimpleBackend-0.0.1-SNAPSHOT.jar /opt/app.jar
CMD ["java", "-jar", "/opt/app.jar"]
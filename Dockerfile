FROM amazoncorretto:18

COPY target/portfolio-backend-p-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
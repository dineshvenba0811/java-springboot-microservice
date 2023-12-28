FROM eclipse-temurin
MAINTAINER "dineshvenba0811@gmail.com"
WORKDIR /app
COPY target/eureka-naming-server-0.0.1-SNAPSHOT.jar /app/discovery-server.jar
ENTRYPOINT ["java", "-jar", "discovery-server.jar"]

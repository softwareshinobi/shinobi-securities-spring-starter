FROM maven:3.8.7-openjdk-18-slim AS mavenBuild

WORKDIR /

COPY . .

RUN mvn install -DskipTests

FROM eclipse-temurin:18-jre-alpine

COPY --from=mavenBuild /target/shinobi-spring-security-starter-1.0.jar /shinobi-spring-security-starter.jar

COPY --from=mavenBuild /src/main/resources/application.properties /application.properties

CMD ["java", "-jar", "/shinobi-spring-security-starter.jar"] 

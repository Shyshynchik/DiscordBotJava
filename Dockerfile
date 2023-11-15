FROM jelastic/maven:3.9.5-openjdk-21 AS builder
WORKDIR /app

## Copy gradle project files
COPY pom.xml ./
COPY src ./src
RUN sh -c "mvn install"

FROM openjdk:21-slim
EXPOSE 8080
WORKDIR /app
COPY --from=builder /app/target/discrod-0.0.1-SNAPSHOT.jar discrod-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "discrod-0.0.1-SNAPSHOT.jar"]
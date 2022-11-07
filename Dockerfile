FROM maven:3.8-openjdk-11-slim AS builder

WORKDIR build

COPY pom.xml .

RUN mvn -B dependency:resolve dependency:resolve-plugins

COPY src ./src

RUN mvn package

RUN java -Djarmode=layertools -jar target/*.jar extract

FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

COPY --from=builder build/dependencies .
COPY --from=builder build/spring-boot-loader .
COPY --from=builder build/snapshot-dependencies .
COPY --from=builder build/application .

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
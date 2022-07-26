FROM openjdk:18-alpine as build
WORKDIR /carmind-back

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod 777 ./mvnw
RUN ./mvnw install -DskipTests

ENV TZ=America/Argentina/Buenos_Aires
ENV DEBIAN_FRONTEND=noninteractive
RUN apk update && apk add tzdata

RUN chmod 777 ./target/carmind-back.jar

ENTRYPOINT ["java","-jar","./target/carmind-back.jar"]

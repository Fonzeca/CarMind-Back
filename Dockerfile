FROM openjdk:18-alpine

ENV TZ=America/Argentina/Buenos_Aires
ENV DEBIAN_FRONTEND=noninteractive
RUN apt-get update, apt-get install -y tzdata

ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
FROM openjdk:11-jdk

RUN apt-get update && apt-get -y install sudo

ARG JAR_FILE="build/libs/my-web-algorithm-*.jar"

COPY ${JAR_FILE} app.jar

ENV PROFILE docker

ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar","/app.jar"]
FROM openjdk:17-jdk-slim

MAINTAINER jeseo

COPY build/libs/configserver-0.0.1-SNAPSHOT.jar configserver-0.0.1-SNAPSHOT.jar

RUN apt-get update && apt-get upgrade -y
RUN apt-get install curl -y

ENTRYPOINT ["java", "-jar", "configserver-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17-jdk-slim

MAINTAINER jeseo

COPY build/libs/eureka-0.0.1-SNAPSHOT.jar eureka-0.0.1-SNAPSHOT.jar

RUN apt-get update && apt-get upgrade -y
RUN apt-get install curl -y

ENTRYPOINT ["java", "-jar", "eureka-0.0.1-SNAPSHOT.jar"]
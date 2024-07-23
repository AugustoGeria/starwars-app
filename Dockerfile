
FROM maven:3.9.0 AS maven
LABEL MAINTAINER="augustogeria2@gmail.com"

WORKDIR /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn clean package

# For Java 8,
FROM openjdk:8-jdk-alpine

ARG JAR_FILE=starwars-app-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

# Copy the ApplicationChallenge-0.0.1-SNAPSHOT.jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","starwars-app-0.0.1-SNAPSHOT.jar"]
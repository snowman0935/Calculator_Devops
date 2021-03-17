FROM openjdk:8
MAINTAINER Sreevardhan  seethana.sreevardhan@iiitb.org
COPY ./target/Calculator-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "Calculator.jar"]
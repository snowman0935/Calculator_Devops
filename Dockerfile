FROM openjdk:8
MAINTAINER Sreevardhan  seethana.sreevardhan@iiitb.org
COPY ./out/artifacts/Calculator_jar/Calculator.jar ./
WORKDIR ./
CMD ["java", "-jar", "Calculator.jar"]
#FROM openjdk:17-jdk
#COPY target/firstjobapp-0.0.1-SNAPSHOT.jar .
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar","firstjobapp-0.0.1-SNAPSHOT"]
#

FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ./target/firstjobapp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
# find jdk package on dockerhub
FROM openjdk:17.0.1
#FROM openjdk:11.0.16
#FROM adoptopenjdk/openjdk11:jre
WORKDIR usr/app
COPY target/fake-user-app-0.0.2-WITHDB.jar fake-user-app-0.0.2-WITHDB.jar
ENTRYPOINT ["java", "-jar", "fake-user-app-0.0.2-WITHDB.jar"]
#ENTRYPOINT ["java", "fake-user-app-0.0.1-SNAPSHOT.jar"]
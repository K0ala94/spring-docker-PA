FROM openjdk:8-jdk-alpine
ARG JAR_FILE
COPY /target/LoggingDAL-0.0.1-SNAPSHOT.jar /docker/loggingDal.jar
ENTRYPOINT ["java","-jar","/docker/loggingDal.jar"]
FROM openjdk:8-jdk-alpine
ARG WAR_FILE
COPY /target/SpringBootTest-0.0.1-SNAPSHOT.war /tmp/accountent.war
ENTRYPOINT ["java","-jar","/tmp/accountent.war"]
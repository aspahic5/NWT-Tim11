FROM java:8-jdk-alpine

COPY ./target/MS_authentication-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch MS_authentication-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","MS_authentication-0.0.1-SNAPSHOT.jar"]  


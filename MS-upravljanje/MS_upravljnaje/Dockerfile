FROM java:8-jdk-alpine

COPY ./target/MS_upravljnaje-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch MS_upravljnaje-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","MS_upravljnaje-0.0.1-SNAPSHOT.jar"]  


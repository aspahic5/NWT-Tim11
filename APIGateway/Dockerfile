FROM java:8-jdk-alpine

COPY ./target/APIGateway-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch APIGateway-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","APIGateway-0.0.1-SNAPSHOT.jar"]  


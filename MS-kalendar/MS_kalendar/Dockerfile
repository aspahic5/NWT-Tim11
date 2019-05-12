
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ADD target/MS_kalendar-0.0.1-SNAPSHOT.jar ms_kalendar.jar
EXPOSE 8082
ENTRYPOINT exec java $JAVA_OPTS -jar ms_kalendar.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar ms_kalendar.jar

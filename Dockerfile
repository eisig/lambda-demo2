FROM openjdk:8-jdk-alpine 
RUN apk --no-cache add curl
COPY target/my-app2*.jar my-app2.jar
CMD java ${JAVA_OPTS} -jar my-app2.jar
FROM openjdk:11.0.7-jdk

ARG VERSION
#ENV APP_VERSION=${VERSION}
ENV APP_VERSION="0.0.1-SNAPSHOT"

LABEL maintainer="Anderson Botelho Cerqueira <andersonbcdev@gmail.com>"

RUN mkdir -p /opt/app

#ADD "application/build/distributions/application-${APP_VERSION}.jar" /opt/app/
ADD /build/libs/desafio-0.0.1-SNAPSHOT.jar /opt/app/desafio.jar


EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app/desafio.jar"]
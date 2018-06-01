FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/ncp-service-0.0.1-SNAPSHOT-standalone.jar /ncp-service/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/ncp-service/app.jar"]

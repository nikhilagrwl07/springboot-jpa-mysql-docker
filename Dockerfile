FROM openjdk:alpine
MAINTAINER nikhil.agrawal <nikhil.agrwl07@gmail.com>
ADD target/springboot-jpa-mysql-docker-0.0.1-SNAPSHOT.jar springboot-jpa-mysql-docker.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "/springboot-jpa-mysql-docker.jar"]
EXPOSE 8080
FROM openjdk:10-jdk
ARG JAR_FILE=target/IntecaTaskApp-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} inteca-task-app.jar
RUN bash -c 'touch /inteca-task-app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/inteca-task-app.jar"]
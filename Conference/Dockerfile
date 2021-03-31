FROM adoptopenjdk:8-jre-hotspot
ARG JAR_FILE=target/conference-0.1.jar
COPY ${JAR_FILE} app.jar
WORKDIR /src
EXPOSE 80
ENTRYPOINT ["java","-jar","/app.jar"]

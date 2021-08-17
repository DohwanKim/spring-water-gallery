FROM openjdk:11-jre-slim
COPY target/water-gallery-0.0.1-SNAPSHOT.jar water-gallery-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/water-gallery-0.0.1-SNAPSHOT.jar"]

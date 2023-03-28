FROM openjdk
COPY target/micro1.jar
ENTRYPOINT ["java","-jar","micro1.jar"]

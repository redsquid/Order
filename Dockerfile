FROM openjdk:11
COPY target/Order-1.0.jar /
CMD ["java", "-jar", "/Order-1.0.jar"]
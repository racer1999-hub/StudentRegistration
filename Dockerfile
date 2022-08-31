FROM openjdk:8
ADD target/StudentRegistration-2.3.4.jar StudentRegistration-2.3.4.jar
EXPOSE 8070
ENTRYPOINT ["java","-jar","StudentRegistration-2.3.4.jar"]

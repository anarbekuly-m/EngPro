FROM openjdk:17-alpine
WORKDIR /APP
COPY Pro/engPro.jar engPro.jar
CMD ["java", "-jar", "engPro.jar"]
FROM openjdk:8-jdk
ADD build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
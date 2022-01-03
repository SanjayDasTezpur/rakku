FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG DEPENDENCY=build/libs
COPY ${DEPENDENCY}/rokko-*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
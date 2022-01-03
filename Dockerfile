FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
RUN ls -l
RUN PWD
RUN gradlew build
USER spring:spring
ARG DEPENDENCY=build/libs
COPY ${DEPENDENCY}/rokko-*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
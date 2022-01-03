FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
RUN gradlew build
RUN ls -l
RUN PWD
USER spring:spring
ARG DEPENDENCY=build/libs
COPY ${DEPENDENCY}/rokko-*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
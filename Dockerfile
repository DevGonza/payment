FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/payments-0.0.1.jar
COPY ${JAR_FILE} app_payments.jar
ENTRYPOINT ["java", "-jar", "app_payments.jar"]
EXPOSE 8080

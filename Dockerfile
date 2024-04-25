FROM maven:3.8.4-openjdk-17-slim AS build

# Atualiza a lista de pacotes e instala o nc e default-mysql-client
RUN apt-get update && apt-get install -y netcat default-mysql-client

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
COPY wait-for-mysql.sh wait-for-mysql.sh
RUN chmod +x wait-for-mysql.sh
EXPOSE 8080
ENTRYPOINT ["/wait-for-mysql.sh", "db", "java","-jar","/application.jar"]
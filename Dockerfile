# Use a imagem do Maven com o JDK 17 como imagem base
FROM maven:3.8.4-openjdk-17-slim AS build

# Atualiza a lista de pacotes e instala o nc e default-mysql-client
RUN apt-get update && apt-get install -y netcat default-mysql-client

# Copia o diretório atual (seu projeto Maven) para o contêiner
COPY . /usr/src/app

# Define o diretório de trabalho
WORKDIR /usr/src/app

# Compila o projeto e cria o pacote com o Maven
RUN mvn clean package

# Verifica se o arquivo JAR foi gerado
RUN if [ ! -f target/*.jar ]; then echo "O arquivo JAR não foi encontrado" && exit 1; fi

# Move o arquivo JAR gerado para o diretório raiz
RUN mv target/*.jar /application.jar

# Expõe a porta 8080
EXPOSE 8080

# Define o comando de entrada para iniciar o aplicativo
ENTRYPOINT ["java","-jar","/application.jar"]
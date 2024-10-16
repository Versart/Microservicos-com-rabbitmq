# Usar uma imagem base do OpenJDK 22
FROM openjdk:22-slim AS build

# Instalar Maven manualmente
RUN apt-get update && apt-get install -y maven

# Configurar diretório de trabalho
WORKDIR /app

# Copiar o pom.xml e as dependências do projeto
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar o código-fonte do projeto
COPY src ./src

# Compilar o projeto sem rodar os testes
RUN mvn clean package -DskipTests

# Usar novamente a imagem do OpenJDK para rodar a aplicação
FROM openjdk:22-slim
WORKDIR /app

# Copiar o .jar da fase anterior
COPY --from=build /app/target/*.jar app.jar

# Expor a porta do Spring Boot
EXPOSE 8081

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
# Estágio 1: Build da aplicação com Maven
# Usamos uma imagem que já contém o JDK e o Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos de configuração do Maven para aproveitar o cache de dependências
COPY pom.xml .
COPY .mvn .mvn

# Baixa as dependências do projeto
RUN mvn dependency:go-offline

# Copia o restante do código fonte
COPY src ./src

# Executa o build do projeto, gerando o arquivo .jar
# -DskipTests para pular a execução dos testes durante o build da imagem
RUN mvn package -DskipTests

# Estágio 2: Criação da imagem final
# Usamos uma imagem mais leve, contendo apenas o JRE, para rodar a aplicação
FROM eclipse-temurin:21-jre-jammy

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo .jar gerado no estágio de build para a imagem final
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta que a aplicação Spring Boot usa por padrão
EXPOSE 8080

# Comando para iniciar a aplicação quando o container for executado
ENTRYPOINT ["java", "-jar", "app.jar"]
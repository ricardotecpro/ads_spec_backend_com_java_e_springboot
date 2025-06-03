# Imagem base
FROM openjdk:17-jdk-alpine

# Diretório dentro do container
WORKDIR /app

# Copia toda a pasta src (preservando a estrutura de diretórios)
COPY src/ /app/src/

# Compila
RUN javac src/main/java/com/example/calculadora/Calculadora.java

# Executa
CMD ["java", "-cp", "src/main/java", "com.example.calculadora.Calculadora"]

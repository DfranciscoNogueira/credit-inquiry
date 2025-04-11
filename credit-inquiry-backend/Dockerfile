# Build da aplicação
FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Imagem de execução
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/credit-inquiry-1.0.0-SNAPSHOT.jar app.jar

# Configuração de variáveis de ambiente
ENV DATABASE_URL=jdbc:postgresql://host.docker.internal:5432/postgres
ENV DATABASE_USERNAME=postgres
ENV DATABASE_PASSWORD=root

# Expondo a porta (ajuste conforme necessário)
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

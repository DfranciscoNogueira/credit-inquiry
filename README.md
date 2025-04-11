# CONSULTA DE CRÉDITOS

### Configurações para rodar a API
O banco de dados utilizado é o Postgresql e as configurações sobre conexão com o banco de dados esta no arquivo de configuração src/main/resources/application.yaml para que funcione de forma correta altere as seguintes propriedades de acordo com o seu banco de dados:

```yaml

* spring.datasource.username
* spring.datasource.password
* spring.datasource.url
```
Ou altere ou crie as seguintes variaveis de ambiente:

```bash
DATABASE_URL=jdbc:postgresql://localhost:5432/postgres
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=root
```

```bash
OBS: verique tambem as variaveis de ambiente do docker-compose.yml e Dockerfile, caso esteja utilizando o docker para rodar o banco de dados.
```

Finalizado rode o script src/main/resources/db/creation_and_initialization.sql para criar as tabelas no banco de dados e inserts iniciais.

### Backend
O Backend pode ser executado de 3 maneiras: 

- a primeira é através do comando mvn spring-boot:run, que irá compilar o projeto e executar a aplicação, ou através do comando mvn clean package, que irá compilar o projeto e gerar um arquivo jar na pasta target, que pode ser executado com o comando java -jar target/credit-inquiry-1.0.1-SNAPSHOT.jar.

- a segunda opção é executar a classe principal RunApplication.java, que está localizada na pasta src/main/java/com/credit/ utilizando a IDE da sua preferencia.

- a terceira opção é utilizar o docker para executar a aplicação, para isso é necessário ter o docker instalado e rodando na sua máquina. Após isso, execute o comando "docker build -t credit-inquiry ." na pasta raiz do projeto, que irá criar uma imagem docker com o nome credit-inquiry. Após isso, execute o comando  e logo apos o "docker run -p 8080:8080 credit-inquiry", que irá executar a aplicação na porta 8080.

Com isso vc ja tem os recursos para rodar a aplicação, agora é só acessar a url http://localhost:8080/api/ e fazer as consultas.

### Frontend

O Frontend pode ser executado de 2 maneiras:

- a primeira é indo a ate a raiz do projeto (onde está o arquivo package.json) e rodar o comando "npm install" (estou usando o node 14, mas caso de ruim vc pode dar um --force) para instalar as dependências do projeto, e logo após rodar o comando "npm start" para iniciar o servidor de desenvolvimento. Após isso, acesse a url http://localhost:4200/ para acessar a aplicação.
- a segunda opção é utilizar o docker para executar a aplicação, para isso é necessário ter o docker instalado e rodando na sua máquina. Após isso, execute o comando "docker build -t credit-inquiry ." na pasta raiz do projeto (onde está o arquivo package.json), que irá criar uma imagem docker com o nome credit-inquiry. Após isso, execute o comando "docker run -p 4200:4200 credit-inquiry", que irá executar a aplicação na porta 4200.

Pronto com isso vc ja pode ver a tela em http://localhost:4200

### Kafka

Como bonus coloquei um exemplo de uso do kafka, então, toda vez que uma consulta ocorrer ele enviara para o uma fila uma notificação, para facilitar aqui estou usando o site "Free Apache Kafka Online Testing Tool" https://gauravsalvi.com/projects/kafka-online-test/ essa ferramenta permite que você teste o Kafka diretamente no navegador, sem necessidade de configuração ou download. Você pode usar os valores padrão para uma demonstração rápida ou configurar os detalhes do cluster Kafka.

Para usar o Kafka, você precisará configurar as seguintes propriedades no arquivo src/main/resources/application.yaml:


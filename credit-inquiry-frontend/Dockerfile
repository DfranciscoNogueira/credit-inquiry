# Definindo a imagem base do Node.js
FROM node:14 AS development

# Criando o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiando os arquivos de dependência
COPY package*.json ./

# Instalando as dependências
RUN npm install

# Copiando todo o código fonte para o contêiner
COPY . .

# Expondo a porta 4200
EXPOSE 4200

# Comando para iniciar o servidor de desenvolvimento Angular
CMD ["npm", "start", "--", "--host=0.0.0.0"]

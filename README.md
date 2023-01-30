# Projeto para CRUD de clientes

### Descrição
 Objetivo do projeto é contruir um CRUD de duas entidades que vão ser orquestradas por APIS REST.
 
____
Esse projeto usa banco de dados em memória, dessa forma não é preciso criar nenhuma infraestrutura para testar as apis,
somente fazer o build com o comando:

    mvn clean install
e Subir o jar gerado na pasta:

    /cliente/target/cliente-0.0.1-SNAPSHOT.jar

com o comando:
    
    java -jar cliente-0.0.1-SNAPSHOT.jar

e acessar o Swagger-ui:

    http://localhost:8080/swagger-ui.html#/



### Tecnologias utilizadas
* JAVA 11
* SPRING BOOT 2.7.7
* DATABASE H2
* Lombock

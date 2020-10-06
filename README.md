# API Restful - Gerenciamento de Ordem de serviços

API RESTful para sistema de gestão de Ordem de Serviços, construída com Java 8, Spring 2.1+ e H2 database memory.

O Crud é fornecido através das classes de RestControllers e distribuindo a funcionalidade das chamadas com seus respectivos  endpoints. 

# Começando
As instruções a seguir permitirão que você copie o projeto e rode em sua máquina local para desenvolvimento e/ou testes.

# Pré Requisito
- JDK 1.8.0_121 ou superior
- Eclipse IDE for Enterprise Java Developers
- Internet Web Browser (Chrome, Mozilla FireFox etc)
- PostMan ou outra ferramenta que tem como objetivo testar serviços RESTful (Web APIs) por meio do envio de requisições HTTP 

# Ambiente utilizado
Java 8, Spring JPA, Maven, Spring Data, Spring Boot, H2, Swagger, Mockito, JUnit, Hibernate. (tecnologias estão no arquivo pom.xml)
IDE: Eclipse IDE for Enterprise Java Developers. Version: 2019-06 (4.12.0) / Build id: 20190614-1200

# Instalação
- Clonar o repositório na máquina em um repositório local e executar o projeto através da classe OsapiApplication.java em rc\main\java\br\com\bruno\osapi.

# Orientações Gerais
Importanto o projeto no Eclipse como projeto existente Maven, verificar necessidade de rodar comandos SQL através do arquivo data.sql no seguinte caminho: src\main\resources\data.sql. Este arquivo será lido pelo H2 toda vez em que o projeto for iniciado pela classe de execução para startar o servidor com o projeto OsapiApplication.java. Caminho: src\main\java\br\com\bruno\osapi\OsapiApplication.java

As classes de serviço responsáveis pelos endpoints podem ser acessadas através do pacote controllers, em src\main\java\br\com\bruno\osapi\controller.

Link da API via Swagger:
Rodar o projeto local e acessar localhost:8080/swagger-ui.html

Link da API via postman:
https://documenter.getpostman.com/view/5423947/TVKEXx4G


<p align="center">
  <img src="https://ibb.co/StNH0TK"  title="Swagger Api Ordem De Serviço">
</p>

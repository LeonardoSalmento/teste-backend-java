# Teste-backend-java
API desenvolvida em java com Spring boot, JPA e MySQL.

## Funcionalidades
:small_blue_diamond: Inserção de dados através da URL - http://localhost:8080/banks

:small_blue_diamond: Listagem de todos os bancos através da URL - http://localhost:8080/banks

:small_blue_diamond: Consulta de banco por id através da URL - http://localhost:8080/banks/:id

:small_blue_diamond: Consulta de banco por código de compensação através da URL - http://localhost:8080/banks/filter/:codigoCompensacao

:small_blue_diamond: Edição de dados através da URL - http://localhost:8080/banks/:id

:small_blue_diamond: Exclusão de dados através da URL - http://localhost:8080/banks/:id


## Pré-requisitos:
Banco de dados já criado no MySQL

## Instalação
Após clonar o repositório, acessar a pasta *BankAPI/src/main/resources* e abrir o arquivo ***application.properties***, preencher as variáveis conforme os dados do seu banco:

### Ex:
```
spring.datasource.url=jdbc:mysql://localhost:3306/DB
spring.datasource.username=root
spring.datasource.password=root1234
```
Você substituirá o **DB** pelo nome do seu banco de dados.
E também o **username** e o **password** que você usa para acessar o seu servidor do banco.

Após isso, já é possível fazer o build do projeto.

### Exemplo de objeto para inserção:
```
{
	"compensationCode": "3",
	"name":"Banco da Amazonia S.A."
}
```

## Banco de dados
O banco deve possuir uma tabela com as seguintes colunas.


### Bank

codigo_compensacao  | nome
--------------------|------
String|String

### Olá. Eu sou Savio. 👋
<img align="right" width="200" height="161" src="https://github.com/Saviocarval/vuttr/blob/master/images/back-end.jpg">

Aceitei o desafio da Bossabox em construir uma API e banco de dados para a aplicação VUTTR (Very Useful Tools to Remember). A aplicação é um simples repositório para gerenciar ferramentas com seus respectivos nomes, links, descrições e tags.

### Sobre o desenvolvimento
- Projeto foi desenvolvido utilizando o Spring Boot.
- Persistencia de dados feita com Spring Data Jpa e banco de dados Mysql.
- Versionamento de codigo com git.
- Autenticação com JWT (JsonWebToken)
- Projeto documentodo com swagger [Swagger](https://vuttr-api-tools.herokuapp.com/swagger-ui.html)
- Deploy realizado no HEROKU [vuttr-api-tools.herokuapp.com](https://vuttr-api-tools.herokuapp.com)


<code><img height="20" src="https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/spring-boot/spring-boot.png"></code>
<code><img height="20" src="https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/mysql/mysql.png"></code>
<code><img height="20" src="https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/git/git.png"></code>
<code><img height="20" src="https://raw.githubusercontent.com/swagger-api/swagger.io/wordpress/images/assets/SWU-logo-clr.png"></code> 
<code><img height="20" src="https://camo.githubusercontent.com/20d1881207b2f0cc1801d73aba895eac538cbe15/68747470733a2f2f6434797438786c396237696e2e636c6f756466726f6e742e6e65742f6173736574732f686f6d652f6c6f676f747970652d6865726f6b752e706e67"></code> 
<code><img height="20" src="https://camo.githubusercontent.com/74d9eb8a0b1aacf85908bdfe799cfe3982006672/687474703a2f2f7374617469632e6a626f73732e6f72672f68696265726e6174652f696d616765732f68696265726e6174655f6c6f676f5f7768697465626b675f32303070782e706e67"></code>



### Rotas

### GET

- Paginação 

ex. GET/tools?page=0&size=10 

- Ordenação

ex. GET/tools?sort=title,asc&sort=id,desc

- Busca por tags

ex. GET/tools?tag=node   (node é a tag sendo buscada neste exemplo)

- Busca por tags com paginação e ordenação

ex. GET/tools?tag=node&page=0&size=10&sort=title,asc&sort=id,desc

- Buscar por id 

ex. GET/tools/:id

#### POST

- Cadastrar uma nova ferramenta
ex. POST/tools 

Content-Type: application/json -- Authorization Bearer Token

{
    "title": "hotel",
    "link": "https://github.com/typicode/hotel",
    "description": "Local app manager. Start apps within your browser, developer tool with local .localhost domain and https out of the box.",
     "tags":["node", "organizing", "webapps", "domain", "developer", "https", "proxy"]
}

- Autenricação 

ex. POST/auth
{
  "username": "string",
  "password": "string"  
}

#### DELETE

-- Remover uma ferramenta por ID
Authorization Bearer Token
ex. DELETE/tools/:id


### Autenticação

Rotas POST e DELETE requerem autenticação tipo Bearer Token no cabeçalho Authorization.
Token pode ser obtido na rota /auth, conforme ex, acima. 
username: administrador
password: 1234



##  Contate-me :speech_balloon:
[![Twitter Badge](https://img.shields.io/badge/-@_saviocarvalho_-1ca0f1?style=flat-square&labelColor=1ca0f1&logo=twitter&logoColor=white&link=https://twitter.com/_saviocarvalho_)](https://twitter.com/_saviocarvalho_) [![Linkedin Badge](https://img.shields.io/badge/-saviocarvalho-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/saviocarvalho/)](https://www.linkedin.com/in/saviocarvalho/) [![Gmail Badge](https://img.shields.io/badge/-savio.carvalhox@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:savio.carvalhox@gmail.com)](mailto:savio.carvalhox@gmail.com) [![Instagram Badge](https://img.shields.io/badge/-@saviocarvalho__-e4405f?style=flat-square&labelColor=f94877&logo=instagram&logoColor=white&link=https://www.instagram.com/saviocarvalho__/)](https://www.instagram.com/saviocarvalho__/)



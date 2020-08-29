### Olá. Eu sou Savio. 👋
<img align="right" width="200" height="161" src="https://github.com/Saviocarval/vuttr/blob/master/images/back-end.jpg">

Aceitei o desafio da Bossabox em construir uma API e banco de dados para a aplicação VUTTR (Very Useful Tools to Remember). A aplicação é um simples repositório para gerenciar ferramentas com seus respectivos nomes, links, descrições e tags.

### Sobre o desenvolvimento
<code><img height="20" src="https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/spring-boot/spring-boot.png"></code>
Progeto foi desenvolvido utilizando o framework Spring.

<code><img height="20" src="https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/mysql/mysql.png"></code>
Persistencia de dados feita com Spring Data Jpa e banco de dados Mysql.

<code><img height="20" src="https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/git/git.png"></code>
Versionamento do codigo com git.

Deploy realizado no heroku e documentado com swagger [Link](https://vuttr-api-tools.herokuapp.com/swagger-ui.html)

### Rotas

## GET

- Paginação 
ex. [GET]/tools?page=0&size=10 

- Ordenação
ex. [GET]/tools?sort=title,asc&sort=id,desc

- Busca por tags
ex. [GET]/tools?tag=node   (node é a tag sendo buscada neste exemplo)

- Busca por tags com paginação e ordenação
ex. [GET]/tools?tag=node&page=0&size=10&sort=title,asc&sort=id,desc

- Buscar por id 
ex. [GET]/tools/:id

## POST

- Cadastrar uma nova ferramenta
ex. [POST]/tools 

Content-Type: application/json

{
    "title": "hotel",
    "link": "https://github.com/typicode/hotel",
    "description": "Local app manager. Start apps within your browser, developer tool with local .localhost domain and https out of the box.",
     "tags":["node", "organizing", "webapps", "domain", "developer", "https", "proxy"]
}

## DELETE

-- Remover uma ferramenta por ID
ex. [DELETE]/tools/:id



[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/fabsvas/fatec-uol-backend)

# fatec-uol-backend
Repositório de desenvolvimento do back-end do Aprendizado por Projeto Integrador (API) da FATEC São José dos Campos.

## :pushpin: Informações da API
Nesta seção você terá acesso as informações para requisições da API.

```
<base_url>: Significa a URL base do backend.
Ambiente publicado: https://pure-refuge-94212.herokuapp.com/
```

Root
```
GET: <base_url>/api
RESPONSE: Bem vindo a API do BOL.com.br!
```

### Registration
Exemplo de corpo da requisição (POST, PUT)
```
{
    "email": "<email>",
    "password": "<password>",
    "name": "<name>",
    "cellphone": "<celular>",
    "userAgent": "<userAgent>",
    "nameBrowser": "<nameBrowser>",
    "versionBrowser": "<versionBrowser>",
    "system": "<system>",
    "gpuModel":  "<gpuModel>",
    "ip": "<ip>",
    "keyboardInput": "<keyboardInput>",
}
```

GET
```
<base_url>/api/registration
```

GET
```
<base_url>/api/registration/:id
```

POST
```
<base_url>/api/registration
```

PUT
```
<base_url>/api/registration/:id
```

DELETE
```
<base_url>/api/registration/:id
```

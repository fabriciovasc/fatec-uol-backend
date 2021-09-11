[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/fabsvas/fatec-uol-backend)

# fatec-uol-backend
Repositório criado para o back-end do projeto UOL/Fatec

## Setup
- Iniciar com o [gitpod.io](https://gitpod.io/#https://github.com/fabsvas/fatec-uol-backend)

## Iniciar
Build
```
mvn spring-boot:run
```
Testes
```
mvn test
```

## API Rest
Raiz
```
GET: <base_url>/api
RESPONSE: Bem vindo a API do BOL.com.br!
```

Profile
```
GET: <base_url>/api/profile
RESPONSE: [Profile]

GET: <base_url>/api/profile/:id
RESPONSE: Profile
```

Registration
```
GET: <base_url>/api/registration
RESPONSE: [Registration]

GET: <base_url>/api/registration/:id
RESPONSE: Registration

POST: <base_url>/api/registration
BODY: {
  email, password, name, cellphone, audioHash, webGLHash, canvasHash
}
RESPONSE: Registration

```

POST Exemplo API
```
{
  "email": "<email>",
	"password": "<password>",
	"name": "<name>",
	"cellphone": "<celular>",
	"audioHash": "<hashqualquer>",
	"webGLHash": "<hashqualquer>",
	"canvasHash": "<hashqualquer>"
}
```

## Atualizar submódulo 
```
git checkout master
git pull
git log --oneline origin/master -3
git checkout -q <last_commit_hash>
cd api-fatec-uol
git add .
git commit -m "message"
git push
```



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



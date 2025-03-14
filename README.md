# lambda-java-21


## build

Usar o plugin *maven-shade* para gerar um fat jar contendo todas as dependências.

## test

### failure

```
curl -X POST <lambda-url> -H "Content-Type: application/json" -d '{"username":"value1","password":"abc"}'
```

### success

```
curl -X POST <lambda-url> -H "Content-Type: application/json" -d '{"username":"admin","password":"123"}'
```
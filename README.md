### Derived from https://github.com/basav22/spring-boot-template
# Spring Boot Template 

* Spring Boot + Web + JPA + REST
* Gradle Wrapper
* Lombok
* MapStruct
* Swagger
* H2 (embedded database)
* JUnit 5
* JaCoCo Java Code Coverage

  ## How to run application

#### using gradle wrapper
```bash
./gradlew clean bootRun
```

#### using docker-compose

```bash
docker-compose up --build -d
```

## Actuator
* `http://localhost:4072/actuator/health` - health information (status)
* `http://localhost:4072/actuator/info` - application basic information

## API Documentation
* `http://localhost:4072/v3/api-docs` - API Docs [JSON]
* `http://localhost:4072/v3/api-docs.yaml` - API Docs [YAML]
* `http://localhost:4072/swagger-ui.html` - Swagger UI

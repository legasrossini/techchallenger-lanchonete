# techchallenger-lanchonete
Tech Challenger FIAP - Arquitetura de Software

    techchallenger-lanchonete/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── br/
    │   │   │       └── com/
    │   │   │           └── fiap/
    │   │   │               └── lanchonete/
    │   │   │                   ├── LanchoneteApplication.java
    │   │   │                   ├── infrastructure/
    │   │   │                   │   ├── configs/
    │   │   │                   │   │   └── ModelMapperConfig.java
    │   │   │                   │   └── adapters/
    │   │   │                   │       ├── repositories/
    │   │   │                   │       │   ├── ClienteJpaRepository.java
    │   │   │                   │       │   └── ProdutoJpaRepository.java
    │   │   │                   │       └── entity/
    │   │   │                   └── ...
    │   │   └── resources/
    │   │       ├── application.properties
    │   │       └── ...
    │   └── test/
    │       └── ...
    ├── db/
    │   └── init.sql
    ├── Dockerfile
    ├── docker-compose.yml
    ├── pom.xml
    └── README.md
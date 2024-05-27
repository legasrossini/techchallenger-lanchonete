# techchallenger-lanchonete
Tech Challenger FIAP - Arquitetura de Software

    techchallenger-lanchonete/
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───br
    │   │   │       └───com
    │   │   │           └───fiap
    │   │   │               └───lanchonete
    │   │   │                   ├───application
    │   │   │                   │   └───adapters
    │   │   │                   │       └───controllers
    │   │   │                   ├───domain
    │   │   │                   │   ├───adapters
    │   │   │                   │   │   └───services
    │   │   │                   │   ├───dtos
    │   │   │                   │   └───ports
    │   │   │                   │       ├───interfaces
    │   │   │                   │       └───repositories
    │   │   │                   └───infrastructure
    │   │   │                       ├───adapters
    │   │   │                       │   ├───entity
    │   │   │                       │   └───repositories
    │   │   │                       ├───configs
    │   │   │                       │   └───mappers
    │   │   │                       ├───enums
    │   │   │                       └───exceptions
    │   │   └───resources
    │   └───test
    │       └───java
    │           └───br
    │               └───com
    │                   └───fiap
    │                       └───lanchonete
    │                           └───controllers
    ├── db/
    │   └── init.sql
    ├── Dockerfile
    ├── docker-compose.yml
    ├── pom.xml
    └── README.md

# Informações para executar e testar a aplicação.

* A aplicação é executada em um container docker.
* Tendo um client em execução, navegar até a raiz do projeto "techchallenger-lanchonete" e executar o comando ```docker-compose up```
* Com o container em execução, haverá uma instância MySQL que foi utilizada para armazenamento dos dados, juntamente com a aplicação.
* Há uma interface para testes da API, acessível em [localhost:8080/swagger-ui.html](localhost:8080/swagger-ui.html)
* Com exceção da tabela "categoria", o banco é iniciado vazio, sendo necessário efetuar o cadastro de produtos e clientes (se desejado) antes de efetuar os testes de geração de pedidos.
* Para visualizar as categorias disponíveis, navegar até o grupo "Categorias" na interface acima, expandir o endpoint "GET" e clicar em "Try it out", o que habilitará o botão "Execute" para efetuar o request. Após a execução, a lista de categorias com seus respectivos IDs serão listadas na área logo abaixo ao botão "Execute".

## Efetuar cadastros para permitir gerar um pedido
O objetivo final da aplicação nessa fase é a geração de um pedido. Para tal, anteriormente é necessário cadastrar, ao menos, os produtos que farão parte dos pedidos.
Para tal, acessar o grupo "Produtos" e expandir o método POST. Para efetuar o cadastro do produto, informar o nome, descrição, preço e a categoria (basta o id). Ao executar o request a aplicação retornará o ID do produto cadastrado. Ele será necessário para gerar os pedidos.
Para visualizar todos os produtos existentes, expandir o GET /lanchonete/v1/produtos, o qual trará todos os produtos disponíveis para serem solicitados nos pedidos.
Conforme definição, a identificação do cliente é opcional, mas caso desejado, acessar o grupo "Clientes" e expandir o método POST ali constante. O CPF é o identificador do cliente, sendo necessário também informar o nome e um email de contato.

## Geração de um pedido
Para gerar um pedido, acessar o grupo "Pedidos" e expandir o método POST ali presente.
Caso seja um pedido de um cliente identificado, preencher no atributo "cpfCliente" um CPF existente na base de dados. Caso não, basta remover o atributo do json de request.
Em seguida é necessário informar em produtos um ou mais combos a serem solicitados. Cada combo pode possuir somente um lanche, um acompanhamento, uma bebida e uma sobremesa. Todos os atributos são opcionais, porém é necessário que ao menos um deles seja informado. Caso se deseje solicitar mais de um lanche por exemplo, gerar um novo combo dentro do array "produtos", informando os itens desejados, que seguem as mesmas regras. Todas as categorias são opcionais, mas ao menos uma é obrigatória.
É também necessário atentar para a categoria do ID de produto informado. Um produto da categoria "Lanche" apenas pode ser enviado no atributo lanche do objeto presente no array de produtos, sob pena do request ser rejeitado. O mesmo vale para as demais categorias.
Estando o pedido montado, clicar em "Execute" para enviar o mesmo para a fila, onde o mesmo estará com o status de "RECEBIDO".
Para visualizar todos os produtos na fila, expandir o método GET do grupo de pedidos e executar a consulta. Serão listados todos os produtos já realizados.

## Informações adicionais
No CRUD de produtos, o método DELETE efetua um "soft delete", atualizando a flag "ativo" para false. Ao listar os produtos, aqueles com status "ativo = false" não serão retornados. Porém na consulta de produto por ID, mesmo que esse esteja desativado, o mesmo é retornado para fins de consulta. A listagem de categorias também só lista os produtos ativos. Por fim, somente é possível efetuar pedidos para produtos ativos.
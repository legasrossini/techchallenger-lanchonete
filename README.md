
# Tech Challenge - FIAP
O projeto lanchonete foi desenvolvido para aplicar os conceitos aprendidos no curso de pós graduação em arquitetura de software da faculdade FIAP, esses conceitos consistem no desenvolvimento a partir do refinamento utilizando a metodologia de eventstorm (DDD), aplicando a arquitetura hexagonal e o docker.
Toda a documentação DDD do Event Storm para o refinamento se encontra disponível no [miro](https://miro.com/app/board/uXjVKC2h5jE=/).

## Autores
Turma: 7 SOAT.
- [@pinheirojks](https://github.com/pinheirojks)
- [@legasrossini](https://github.com/legasrossini)
- [@maurimurakami](https://github.com/maurimurakami)
- [@Piovezan1207](https://github.com/Piovezan1207)

# Tecnologias utilizadas
* A aplicação foi desenvolvida utilizando Java 17, framework Spring Boot, com a utilização do banco de dados MySql. Além disso foi utilizado o Docker para a execução da aplicação e do banco de dados e o Swagger para a documentação da API.

# Premissas para a execução do projeto.
* Ter o [docker](https://www.docker.com/products/docker-desktop/) instalado na máquina.
* Realizar o checkout da branch [Main](https://github.com/legasrossini/techchallenger-lanchonete).

# Passo a passo para a execução do projeto.
* Após o checkout da branch Main, acessar a raiz do projeto "techchallenger-lanchonete" onde se encontra o arquivo docker-compose.yml.
* Com o terminal aberto na raiz do projeto, executar o comando `docker-compose up` para iniciar a aplicação.
* Após a execução do comando, a aplicação estará disponível em [localhost:8080](localhost:8080).
* A aplicação estará disponível para testes na interface do Swagger, acessível em [localhost:8080/swagger-ui.html](localhost:8080/swagger-ui.html).
* Como a aplicação foi desenvolvida utilizando o framework Spring Boot e MySql dentro do Docker, pode levar um tempo de inicialização um pouco mais longo, pois a aplicação aguarda que o banco esteja dísponivel para ser iniciada. Após a execução do comando `docker-compose up`, aguardar alguns minutos até que a aplicação esteja disponível.
* Para encerrar a execução da aplicação, basta executar o comando `docker-compose down`.

# Funcionalidades
- Cadastro de clientes
- Identificação do cliente via CPF
- Criar, editar e remover produtos
- Buscar produtos por categoria
- Fake checkout, apenas enviar os produtos escolhidos para a fila. O checkout é a finalização do pedido
- Listar os pedidos

# Observações
* Com exceção da tabela "categoria", o banco é iniciado vazio, sendo necessário efetuar o cadastro de produtos e clientes (se desejado) antes de efetuar os testes de geração de pedidos.
* Para visualizar as categorias disponíveis, navegar até o grupo "Categorias" na interface acima, expandir o endpoint "GET" e clicar em "Try it out", o que habilitará o botão "Execute" para efetuar o request. Após a execução, a lista de categorias com seus respectivos IDs serão listadas na área logo abaixo ao botão "Execute".
* No CRUD de produtos, o método DELETE efetua um "soft delete", atualizando a flag "ativo" para false. Ao listar os produtos, aqueles com status "ativo = false" não serão retornados. Porém na consulta de produto por ID, mesmo que esse esteja desativado, o mesmo é retornado para fins de consulta. A listagem de categorias também só lista os produtos ativos. Por fim, somente é possível efetuar pedidos para produtos ativos.

### Efetuar cadastros para permitir gerar um pedido
O objetivo final da aplicação nessa fase é a geração de um pedido. Para tal, anteriormente é necessário cadastrar, ao menos, os produtos que farão parte dos pedidos.
Para tal, acessar o grupo "Produtos" e expandir o método POST. Para efetuar o cadastro do produto, informar o nome, descrição, preço e a categoria (basta o id). Ao executar o request a aplicação retornará o ID do produto cadastrado. Ele será necessário para gerar os pedidos.
Para visualizar todos os produtos existentes, expandir o GET /lanchonete/v1/produtos, o qual trará todos os produtos disponíveis para serem solicitados nos pedidos.
Conforme definição, a identificação do cliente é opcional, mas caso desejado, acessar o grupo "Clientes" e expandir o método POST ali constante. O CPF é o identificador do cliente, sendo necessário também informar o nome e um email de contato.

### Geração de um pedido
Para gerar um pedido, acessar o grupo "Pedidos" e expandir o método POST ali presente.
Caso seja um pedido de um cliente identificado, preencher no atributo "cpfCliente" um CPF existente na base de dados. Caso não, basta remover o atributo do json de request.
Em seguida é necessário informar em produtos um ou mais combos a serem solicitados. Cada combo pode possuir somente um lanche, um acompanhamento, uma bebida e uma sobremesa. Todos os atributos são opcionais, porém é necessário que ao menos um deles seja informado. Caso se deseje solicitar mais de um lanche por exemplo, gerar um novo combo dentro do array "produtos", informando os itens desejados, que seguem as mesmas regras. Todas as categorias são opcionais, mas ao menos uma é obrigatória.
É também necessário atentar para a categoria do ID de produto informado. Um produto da categoria "Lanche" apenas pode ser enviado no atributo lanche do objeto presente no array de produtos, sob pena do request ser rejeitado. O mesmo vale para as demais categorias.
Estando o pedido montado, clicar em "Execute" para enviar o mesmo para a fila, onde o mesmo estará com o status de "RECEBIDO".
Para visualizar todos os produtos na fila, expandir o método GET do grupo de pedidos e executar a consulta. Serão listados todos os produtos já realizados.

### Sobre as APIs

### PRODUTOS

#### Consulta um produto por ID, trazendo o registro mesmo que esteja inativo

```http
  GET /lanchonete/v1/produtos/{idProduto}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `idProduto` | `string` | **Obrigatório**. ID do produto a ser consultado |

#### Cadastra ou atualiza um produto. Se o ID for localizado, atualiza, caso contrário cria um novo

```http
  PUT /lanchonete/v1/produtos/{idProduto}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `idProduto`      | `string` | **Obrigatório**. ID do produto a ser modificado. |

#### Efetua a exclusão (lógica) de um produto por ID

```http
  DELETE /lanchonete/v1/produtos/{idProduto}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `idProduto`      | `string` | **Obrigatório**. ID do produto a ser deletado. |


#### Lista todos os produtos ativos

```http
  GET /lanchonete/v1/produtos
```

#### Cadastra um novo produto

```http
  POST /lanchonete/v1/produtos
```
Obrigatório - Request body
```json
{
  "nome": "string",
  "descricao": "string",
  "preco": 0,
  "categoria": {
    "id": 1
  }
}
```

#### Lista todos os produtos ativos por categoria. Para visualizar as categorias disponíveis, consulte o endpoint /categorias

```http
  GET /lanchonete/v1/produtos/categoria/{idCategoria}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `idCategoria`      | `string` | **Obrigatório**. ID da categoria. |


### PEDIDOS

#### Lista todos os pedidos

```http
  GET /lanchonete/v1/pedidos
```

#### Gera o pedido do cliente

```http
  POST /lanchonete/v1/pedidos
```
Obrigatório - Request body
```json
{
  "cpfCliente": "string",
  "produtos": [
    {
      "lanche": {
        "id": "string"
      },
      "acompanhamento": {
        "id": "string"
      },
      "bebida": {
        "id": "string"
      },
      "sobremesa": {
        "id": "string"
      }
    }
  ]
}
```

### CATEGORIAS

#### Lista todas as categorias disponíveis

```http
  GET /lanchonete/v1/categorias
```

### CLIENTES

#### Cadastra um novo cliente

```http
  POST /lanchonete/v1/clientes
```
Obrigatório - Request body
```json
{
  "cpf": "string",
  "nome": "string",
  "email": "string"
}
```

#### Consulta o cliente por CPF

```http
  GET /lanchonete/v1/clientes/{cpfCliente}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `cpfCliente`      | `string` | **Obrigatório**. CPF do cliente a ser consultado. |## Arquitetura

CREATE TABLE IF NOT EXISTS cliente (
    cpf_cliente VARCHAR(11) NOT NULL,
    nome_cliente VARCHAR(100) NOT NULL,
    email_cliente VARCHAR(100) NOT NULL,
    PRIMARY KEY (cpf_cliente)
);

CREATE TABLE IF NOT EXISTS categoria (
    id_categoria INT NOT NULL,
    nome_categoria VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_categoria)
);

CREATE TABLE IF NOT EXISTS produto (
    id_produto VARCHAR(100) NOT NULL,
    nome_produto VARCHAR(255) NOT NULL,
    descricao_produto VARCHAR(255),
    preco_produto DECIMAL(10, 2) NOT NULL,
    id_categoria INT NOT NULL,
    PRIMARY KEY (id_produto),
    FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria)
);

CREATE TABLE IF NOT EXISTS pedido (
    id_pedido VARCHAR(100) NOT NULL,
    cliente VARCHAR(11) NOT NULL,
);

INSERT INTO categoria (id_categoria, nome_categoria) VALUES
(1, 'Lanche'),
(2, 'Acompanhamento'),
(3, 'Bebida'),
(4, 'Sobremesa');
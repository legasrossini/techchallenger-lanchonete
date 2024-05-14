CREATE TABLE IF NOT EXISTS cliente (
    cpf VARCHAR(11) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY (cpf)
);

CREATE TABLE IF NOT EXISTS categoria (
    id INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS produto (
    id VARCHAR(100) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    preco DECIMAL(10, 2) NOT NULL,
    id_categoria INT NOT NULL,
    ativo TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (id),
    FOREIGN KEY (id_categoria) REFERENCES categoria (id)
);

CREATE TABLE IF NOT EXISTS pedido (
    id VARCHAR(100) NOT NULL,
    cpf_cliente VARCHAR(11),
    data_hora TIMESTAMP,
    valor DECIMAL(10,2),
    status INT,
    PRIMARY KEY (id),
    FOREIGN KEY(cpf_cliente) REFERENCES cliente (cpf)
);


CREATE TABLE IF NOT EXISTS pedido_produto
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido VARCHAR(100),
    id_produto VARCHAR(100),
    combo_num INT,
    preco DECIMAL(10,2),
    FOREIGN KEY(id_pedido) REFERENCES pedido (id),
    FOREIGN KEY(id_produto) REFERENCES produto (id)
);



INSERT INTO categoria (id, nome) VALUES
(1, 'Lanche'),
(2, 'Acompanhamento'),
(3, 'Bebida'),
(4, 'Sobremesa');











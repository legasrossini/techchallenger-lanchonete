CREATE TABLE IF NOT EXISTS produtos (
    id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2),
    categoria VARCHAR(100),
    PRIMARY KEY (id)
);
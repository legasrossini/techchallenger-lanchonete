CREATE TABLE IF NOT EXISTS clientes (
    cpf VARCHAR(11) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    PRIMARY KEY (cpf)
);
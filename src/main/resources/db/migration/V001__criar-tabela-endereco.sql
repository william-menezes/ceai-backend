CREATE TABLE IF NOT EXISTS endereco (
    idEndereco SERIAL PRIMARY KEY,
    logradouro VARCHAR(255) NOT NULL,
    numero INT NULL,
    complemento VARCHAR(100) NULL,
    cep VARCHAR(10) NULL,
    bairro VARCHAR(100) NULL
)
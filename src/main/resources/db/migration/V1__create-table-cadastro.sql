CREATE TABLE TB_cadastro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    datanascimento DATE,
    email VARCHAR(100) ,
    endereco VARCHAR(255) ,
    telefone VARCHAR(15)
);
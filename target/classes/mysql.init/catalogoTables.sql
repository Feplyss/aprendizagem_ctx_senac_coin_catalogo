CREATE DATABASE catalogo;

USE catalogo;

CREATE TABLE IF NOT EXISTS periodo(
    periodo_id BIGINT(20) NOT NULL auto_increment,
    periodo_nome VARCHAR(45),
    periodo_status INT(11),
    PRIMARY KEY (periodo_id)
);

CREATE TABLE IF NOT EXISTS curso_tipo(
    curso_tipo_id INT(11) NOT NULL auto_increment,
    curso_tipo_descricao VARCHAR(45) NOT NULL,
    curso_tipo_status INT(11) NOT NULL,
    PRIMARY KEY (curso_tipo_id)
);

CREATE TABLE IF NOT EXISTS curso(
    curso_id BIGINT(20) NOT NULL auto_increment,
    curso_nome VARCHAR(255) NOT NULL,
    curso_codigo VARCHAR(50) NOT NULL,
    curso_horas INT(11) NOT NULL,
    curso_status INT(11) NOT NULL,
    curso_tipo_id INT(11) NOT NULL,
    PRIMARY KEY (curso_id),
    FOREIGN KEY (curso_tipo_id) REFERENCES curso_tipo(curso_tipo_id)
);

CREATE TABLE IF NOT EXISTS item_catalogo (
    item_catalogo_id BIGINT(20) NOT NULL auto_increment,
    item_catalogo_titulo VARCHAR(255) NOT NULL,
    item_catalogo_descricao VARCHAR(255),
    item_catalogo_valor BIGINT(20) NOT NULL,
    item_catalogo_imagem LONGBLOB NOT NULL,
    periodo_id BIGINT(20) NOT NULL,
    curso_id BIGINT(20) NOT NULL,
    PRIMARY KEY (item_catalogo_id),
    FOREIGN KEY (periodo_id) REFERENCES periodo(periodo_id),
    FOREIGN KEY (curso_id) REFERENCES curso(curso_id)
);

INSERT INTO periodo
(periodo_nome, periodo_status)
VALUES('2023.1', 0);

INSERT INTO curso_tipo
(curso_tipo_descricao, curso_tipo_status)
VALUES('Graduação', 0);


INSERT INTO curso
(curso_nome, curso_codigo, curso_horas, curso_status, curso_tipo_id)
VALUES('Análise e Desenvolvimento de Sistemas', 12345, 2000, 0, 1);

INSERT INTO item_catalogo
(item_catalogo_titulo, item_catalogo_descricao, item_catalogo_valor, item_catalogo_imagem, periodo_id, curso_id)
VALUES('Tarefa 1', 'Análise de requisitos', 100, 'blob', 1, 1);

INSERT INTO item_catalogo
(item_catalogo_titulo, item_catalogo_descricao, item_catalogo_valor, item_catalogo_imagem, periodo_id, curso_id)
VALUES('Tarefa 2', 'Diagrama de caso de uso', 200, 'blob', 1, 1);
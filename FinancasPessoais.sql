CREATE database financas;

USE financas;

CREATE TABLE categoria(
	id INT(11) NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tipos_movimentacao(
	id INT(11) NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE movimentacao(
	id INT(11) NOT NULL AUTO_INCREMENT,
	tipo INT(11) NOT NULL,
    categoria INT(11) NOT NULL,
    datas DATE,
    valor DOUBLE,
    descricao VARCHAR(50),
    pago BOOLEAN,
    PRIMARY KEY (id),
    FOREIGN KEY (tipo) REFERENCES tipos_movimentacao (id),
    FOREIGN KEY (categoria) REFERENCES categoria (id)
);


INSERT INTO `categoria` VALUES (1,'Alimentação'),(2,'Educação'),(3,'Esportes'),(4,'Lazer'),(5,'Moradia'),(6,'Outros'),(7,'Presentes'),(8,'Roupas'),(9,'Salário'),(10,'Saúde'),(11,'Transporte'),(12,'Viagem');

INSERT INTO `tipos_movimentacao` VALUES (1,'Receita'),(2,'Despesa');

INSERT INTO movimentacao VALUES(1, 1, 1, '2018-09-09', 1258.63, 'Teste 1', TRUE);
INSERT INTO movimentacao VALUES(2, 2, 2, '2018-03-25', 987, 'Teste 2', FALSE);     
INSERT INTO movimentacao VALUES(3, 1, 3, '2018-01-25', 100.27 , 'Teste 6', TRUE); 
INSERT INTO movimentacao VALUES(4, 2, 3, '2018-01-25', 100.27 , 'Teste 6', TRUE); 
INSERT INTO movimentacao VALUES(100, 2, 3, '2018-01-25', 100.27 , 'Teste 6', TRUE); 

SELECT * FROM categoria; 
SELECT * FROM tipos_movimentacao;    
SELECT * FROM movimentacao;   
SELECT DISTINCT YEAR(datas) AS ano FROM movimentacao ORDER BY ano DESC;
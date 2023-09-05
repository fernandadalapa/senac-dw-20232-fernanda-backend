INSERT INTO exemplos.fabricantes (nome, cnpj)
VALUES('3 corações', '11222333000022');

INSERT INTO exemplos.fabricantes (nome, cnpj)
VALUES('Melita', '10222333000022');

INSERT INTO exemplos.fabricantes (nome, cnpj)
VALUES('Italac', '55222333000022');

INSERT INTO exemplos.fabricantes (nome, cnpj)
VALUES('Tirol', '88222333000022');

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Café', 1, 12.5, 0.5, sysdate());

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Café', 2, 10.0, 0.5, sysdate());

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Leite', 3, 80.5, 0.2, sysdate());

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Leite', 4, 70.2, 0.3, sysdate());

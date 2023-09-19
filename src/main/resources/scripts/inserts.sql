INSERT INTO exemplos.fabricantes (nome, cnpj, cidade, uf)
VALUES('3 corações', '11222333000022', 'São José', 'SC');

INSERT INTO exemplos.fabricantes (nome, cnpj, cidade, uf)
VALUES('Melita', '10222333000022', 'Florianópolis', 'SC');

INSERT INTO exemplos.fabricantes (nome, cnpj, cidade, uf)
VALUES('Italac', '55222333000022', 'Palhoça', 'SC');

INSERT INTO exemplos.fabricantes (nome, cnpj, cidade, uf)
VALUES('Tirol', '88222333000022', 'Pomerode', 'SC');

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Café', 1, 12.5, 0.5, sysdate());

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Café', 2, 10.0, 0.5, sysdate());

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Leite', 3, 80.5, 0.2, sysdate());

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Leite', 4, 70.2, 0.3, sysdate());

<<<<<<< HEAD
INSERT INTO CLIENTE(nome, endereco, email, telefone) VALUES('Bruno', 'vila nova', 'brunojgirardi@gmail.com', '99123835');
INSERT INTO CLIENTE(nome, endereco, email, telefone) VALUES('Maria', 'vila nova', 'marialemes@gmail.com', '99991125');

INSERT INTO EXECUTOR_ORDEM_SERVICO(nome) VALUES('ESTEVAN');
INSERT INTO EXECUTOR_ORDEM_SERVICO(nome) VALUES('JHONAS');

INSERT INTO ORDEM_SERVICO(data_criacao, data_fechamento, descricao, equipamento, marca, modelo, status, cliente_id, executor_ordem_servico_id) VALUES('2020-05-05 18:00:00',  null, 'travamento', 'videogame', 'Sony', 'ps5', 'FINALIZADA', 1, 1);
INSERT INTO ORDEM_SERVICO(data_criacao, data_fechamento, descricao, equipamento, marca, modelo, status, cliente_id, executor_ordem_servico_id) VALUES('2020-05-05 18:00:00',  null, 'leitor queimado', 'videogame', 'Sony', 'ps4', 'EMATENDIMENTO', 1, 1);
INSERT INTO ORDEM_SERVICO(data_criacao, data_fechamento, descricao, equipamento, marca, modelo, status, cliente_id, executor_ordem_servico_id) VALUES('2020-05-10 18:00:00',  null, 'superaquecimento', 'videogame', 'Microsoft', 'xbox one', 'ABERTA', 2, null);
=======
INSERT INTO CLIENTE(nome, endereco, email, telefone) VALUES('Bruno', 'vila nova', 'brunojgirardi@gmail.com', '99123835');
INSERT INTO CLIENTE(nome, endereco, email, telefone) VALUES('Maria', 'vila nova', 'marialemes@gmail.com', '99991125');

INSERT INTO EXECUTOR_ORDEM_SERVICO(nome) VALUES('ESTEVAN');
INSERT INTO EXECUTOR_ORDEM_SERVICO(nome) VALUES('JHONAS');

INSERT INTO ORDEM_SERVICO(data_criacao, data_fechamento, descricao, equipamento, marca, modelo, status, cliente_id, executor_ordem_servico_id) VALUES('2020-05-05 18:00:00',  null, 'travamento', 'videogame', 'Sony', 'ps5', 'FINALIZADA', 1, 1);
INSERT INTO ORDEM_SERVICO(data_criacao, data_fechamento, descricao, equipamento, marca, modelo, status, cliente_id, executor_ordem_servico_id) VALUES('2020-05-05 18:00:00',  null, 'leitor queimado', 'videogame', 'Sony', 'ps4', 'EMATENDIMENTO', 1, 1);
INSERT INTO ORDEM_SERVICO(data_criacao, data_fechamento, descricao, equipamento, marca, modelo, status, cliente_id, executor_ordem_servico_id) VALUES('2020-05-10 18:00:00',  null, 'superaquecimento', 'videogame', 'Microsoft', 'xbox one', 'ABERTA', 2, null);
>>>>>>> 582d4c0d73dd8a2a3149de2ef90ed4dcb92d373c
INSERT INTO ORDEM_SERVICO(data_criacao, data_fechamento, descricao, equipamento, marca, modelo, status, cliente_id, executor_ordem_servico_id) VALUES('2020-05-10 18:00:00',  null, 'fonte queimada', 'videogame', 'Microsoft', 'xbox 360', 'SUSPENSA', 2, 2);
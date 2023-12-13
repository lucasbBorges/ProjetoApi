set foreign_key_checks = 0;

delete from cliente;
delete from atividade;
delete from meio_pagamento;
delete from pagamento;

set foreign_key_checks = 1;

alter table cliente auto_increment = 1;
alter table atividade auto_increment = 1;
alter table meio_pagamento auto_increment = 1;
alter table pagamento auto_increment = 1;

insert into cliente (id, nome, email, celular, data_atualizacao, data_cadastro) values (1, 'Lucas Bortoli Borges', 'lucas@gmail.com', '51989366472', utc_timestamp, utc_timestamp);
insert into cliente (id, nome, email, celular, data_atualizacao, data_cadastro) values (2, 'Marcos Juliano Lima Borges', 'marcos@gmail.com', '51989366472', utc_timestamp, utc_timestamp);
insert into cliente (id, nome, email, celular, data_atualizacao, data_cadastro) values (3, 'Pedro de Oliveira Schine', 'pedro@gmail.com', '51989366472', utc_timestamp, utc_timestamp);
insert into cliente (id, nome, email, celular, data_atualizacao, data_cadastro) values (4, 'Bruno Lammel Lucas', 'bruno@gmail.com', '51989366472', utc_timestamp, utc_timestamp);

insert into meio_pagamento (id, descricao) values (1, 'DINHEIRO');
insert into meio_pagamento (id, descricao) values (2, 'PIX');

insert into atividade (id, descricao) values (1, 'CONSULTA');
insert into atividade (id, descricao) values (2, 'LIMPEZA DE CUMBUCA');
insert into atividade (id, descricao) values (3, 'TRABALHOS');

INSERT INTO PAGAMENTO (ID, CLIENTE_ID, meio_pagamento_id, DATA_PAGAMENTO, VALOR)
VALUES (1,1,1, utc_timestamp, 100);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, meio_pagamento_id, DATA_PAGAMENTO, VALOR)
VALUES (2,1,2, utc_timestamp, 150);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, meio_pagamento_id, DATA_PAGAMENTO, VALOR)
VALUES (3,1,1, utc_timestamp, 70);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, meio_pagamento_id, DATA_PAGAMENTO, VALOR)
VALUES (4,2,1, utc_timestamp, 200);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, meio_pagamento_id, DATA_PAGAMENTO, VALOR)
VALUES (5,2,2, utc_timestamp, 60);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, meio_pagamento_id, DATA_PAGAMENTO, VALOR)
VALUES (6,3,2, utc_timestamp, 300);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, meio_pagamento_id, DATA_PAGAMENTO, VALOR)
VALUES (7,4,1, utc_timestamp, 400);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, meio_pagamento_id, DATA_PAGAMENTO, VALOR)
VALUES (8,4,2, utc_timestamp, 70);
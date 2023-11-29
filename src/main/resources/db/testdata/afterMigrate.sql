set foreign_key_checks = 0;

delete from cliente;
delete from pagamento;

set foreign_key_checks = 1;

alter table cliente auto_increment = 1;
alter table pagamento auto_increment = 1;

insert into cliente (id, nome, email, celular, data_atualizacao, data_cadastro) values (1, 'Lucas Bortoli Borges', 'lucas@gmail.com', 51989366472, utc_timestamp, utc_timestamp);
insert into cliente (id, nome, email, celular, data_atualizacao, data_cadastro) values (2, 'Marcos Juliano Lima Borges', 'marcos@gmail.com', 51989366472, utc_timestamp, utc_timestamp);
insert into cliente (id, nome, email, celular, data_atualizacao, data_cadastro) values (3, 'Pedro de Oliveira Schine', 'pedro@gmail.com', 51989366472, utc_timestamp, utc_timestamp);
insert into cliente (id, nome, email, celular, data_atualizacao, data_cadastro) values (4, 'Bruno Lammel Lucas', 'bruno@gmail.com', 51989366472, utc_timestamp, utc_timestamp);

INSERT INTO PAGAMENTO (ID, CLIENTE_ID, TIPO_PAGAMENTO, DATA_PAGAMENTO, VALOR)
VALUES (1,1,'DINHEIRO', utc_timestamp, 100);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, TIPO_PAGAMENTO, DATA_PAGAMENTO, VALOR)
VALUES (2,1,'PIX', utc_timestamp, 150);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, TIPO_PAGAMENTO, DATA_PAGAMENTO, VALOR)
VALUES (3,1,'DINHEIRO', utc_timestamp, 70);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, TIPO_PAGAMENTO, DATA_PAGAMENTO, VALOR)
VALUES (4,2,'DINHEIRO', utc_timestamp, 200);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, TIPO_PAGAMENTO, DATA_PAGAMENTO, VALOR)
VALUES (5,2,'PIX', utc_timestamp, 60);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, TIPO_PAGAMENTO, DATA_PAGAMENTO, VALOR)
VALUES (6,3,'PIX', utc_timestamp, 300);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, TIPO_PAGAMENTO, DATA_PAGAMENTO, VALOR)
VALUES (7,4,'DINHEIRO', utc_timestamp, 400);
INSERT INTO PAGAMENTO (ID, CLIENTE_ID, TIPO_PAGAMENTO, DATA_PAGAMENTO, VALOR)
VALUES (8,4,'PIX', utc_timestamp, 70);
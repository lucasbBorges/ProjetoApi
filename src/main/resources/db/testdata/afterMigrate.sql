set foreign_key_checks = 0;

delete from cliente;

set foreign_key_checks = 1;

alter table cliente auto_increment = 1;

insert into cliente (id, nome, email, celular, data_atualizacao, data_cadastro) values (1, 'Lucas Bortoli Borges', 'lucas@gmail.com', 51989366472, utc_timestamp, utc_timestamp);
insert into cliente (id, nome, email, celular, data_atualizacao, data_cadastro) values (2, 'Marcos Juliano Lima Borges', 'marcos@gmail.com', 51989366472, utc_timestamp, utc_timestamp);
insert into cliente (id, nome, email, celular, data_atualizacao, data_cadastro) values (3, 'Pedro de Oliveira Schine', 'pedro@gmail.com', 51989366472, utc_timestamp, utc_timestamp);
insert into cliente (id, nome, email, celular, data_atualizacao, data_cadastro) values (4, 'Bruno Lammel Lucas', 'bruno@gmail.com', 51989366472, utc_timestamp, utc_timestamp);
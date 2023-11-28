create table cliente (
	id bigint not null auto_increment,
	nome varchar(100) not null,
	email varchar(100) not null,
	celular bigint not null,
	data_atualizacao datetime not null,
	data_cadastro datetime not null,

	primary key (id)
) engine=InnoDB default charset=utf8;

ALTER TABLE cliente
ADD UNIQUE INDEX unique_email (email);

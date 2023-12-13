create table atividade (
	id bigint not null auto_increment,
	descricao varchar(20) not null,

	primary key (id)
) engine=InnoDB default charset=utf8;
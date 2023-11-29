create table pagamento (
	id bigint not null auto_increment,
	cliente_id bigint not null,
	tipo_pagamento varchar(20) not null,
	data_pagamento datetime not null,
    valor decimal(10,2) not null,

	primary key (id)
) engine=InnoDB default charset=utf8;

alter table pagamento add constraint fk_cliente_pagamento
foreign key (cliente_id) references cliente (id);
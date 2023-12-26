alter table cliente add ativo tinyint(1) not null;
update cliente set ativo = true;
-- DROP
ALTER TABLE pagamento
DROP COLUMN data_pagamento;

ALTER TABLE cliente
DROP COLUMN data_atualizacao;

ALTER TABLE cliente
DROP COLUMN data_cadastro;

-- ADD
ALTER TABLE pagamento
ADD COLUMN data_pagamento DATE;

ALTER TABLE cliente
ADD COLUMN data_atualizacao DATE;

ALTER TABLE cliente
ADD COLUMN data_cadastro DATE;




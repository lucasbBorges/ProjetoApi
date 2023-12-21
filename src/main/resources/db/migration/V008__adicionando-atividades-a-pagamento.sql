ALTER TABLE pagamento
ADD COLUMN atividade_id bigint,
ADD CONSTRAINT fk_atividade
  FOREIGN KEY (atividade_id)
  REFERENCES atividade (id);
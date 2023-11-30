ALTER TABLE pagamento
DROP COLUMN tipo_pagamento;

ALTER TABLE pagamento
ADD COLUMN meio_pagamento_id bigint,
ADD CONSTRAINT fk_meio_pagamento
  FOREIGN KEY (meio_pagamento_id)
  REFERENCES meio_pagamento (id);
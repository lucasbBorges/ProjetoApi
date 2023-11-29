package com.project.api.domain.exceptions.pagamento;

import com.project.api.domain.exceptions.ResourceExistenteException;

public class PagamentoExistenteException extends ResourceExistenteException {
    private static final String mensagem = "Pagamento ja cadastrado";

    public PagamentoExistenteException() {
        super(mensagem);
    }
}

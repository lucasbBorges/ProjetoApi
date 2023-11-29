package com.project.api.domain.exceptions.pagamento;

import com.project.api.domain.exceptions.ResourceEmUsoException;

public class PagamentoEmUsoException extends ResourceEmUsoException {
    private static final String mensagem = "Pagamento não pode ser excluido";

    public PagamentoEmUsoException(){
        super(mensagem);
    }
}

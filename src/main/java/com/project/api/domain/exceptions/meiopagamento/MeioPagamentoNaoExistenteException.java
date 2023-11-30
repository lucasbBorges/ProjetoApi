package com.project.api.domain.exceptions.meiopagamento;

import com.project.api.domain.exceptions.ResourceNaoExistenteException;

public class MeioPagamentoNaoExistenteException extends ResourceNaoExistenteException {
    private static final String mensagem = "Meio de pagamento não existe";

    public MeioPagamentoNaoExistenteException(){
        super(mensagem);
    }
}

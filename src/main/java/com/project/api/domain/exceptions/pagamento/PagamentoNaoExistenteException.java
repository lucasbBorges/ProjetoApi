package com.project.api.domain.exceptions.pagamento;

import com.project.api.domain.exceptions.ResourceNaoExistenteException;

public class PagamentoNaoExistenteException extends ResourceNaoExistenteException {
    private static final String mensagem = "Pagamento nao cadastrado.";

    public PagamentoNaoExistenteException(){
        super(mensagem);
    }
}

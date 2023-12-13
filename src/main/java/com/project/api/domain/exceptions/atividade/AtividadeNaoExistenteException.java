package com.project.api.domain.exceptions.atividade;

import com.project.api.domain.exceptions.ResourceNaoExistenteException;

public class AtividadeNaoExistenteException extends ResourceNaoExistenteException {
    private final static String mensagem = "Atividade não existente";

    public AtividadeNaoExistenteException(){
        super(mensagem);
    }
}

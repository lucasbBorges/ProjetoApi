package com.project.api.domain.exceptions.atividade;

import com.project.api.domain.exceptions.ResourceEmUsoException;

public class AtividadeEmUsoException extends ResourceEmUsoException {
    private final static String mensagem = "Atividade não pode ser excluida";

    public AtividadeEmUsoException(){
        super(mensagem);
    }
}

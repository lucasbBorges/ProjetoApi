package com.project.api.domain.exceptions.atividade;

import com.project.api.domain.exceptions.ResourceExistenteException;

public class AtividadeExistenteException extends ResourceExistenteException {
    private static final String mensagem = "Atividade já cadastrada";

    public AtividadeExistenteException(){
        super(mensagem);
    }
}

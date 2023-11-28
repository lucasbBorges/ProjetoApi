package com.project.api.domain.exceptions.cliente;

import com.project.api.domain.exceptions.ResourceEmUsoException;

public class ClienteEmUsoException extends ResourceEmUsoException {

    private static final String mensagem = "Cliente em uso. Nao pode ser excluido.";
    public ClienteEmUsoException(){
        super(mensagem);
    }
}

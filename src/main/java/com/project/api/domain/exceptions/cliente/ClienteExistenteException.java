package com.project.api.domain.exceptions.cliente;

import com.project.api.domain.exceptions.ResourceEmUsoException;

public class ClienteExistenteException extends ResourceEmUsoException {
    private static final String mensagem = "Email ja cadastrado.";
    public ClienteExistenteException(){
        super(mensagem);
    }
}

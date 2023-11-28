package com.project.api.domain.exceptions.cliente;

import com.project.api.domain.exceptions.ResourceNaoExistenteException;

public class ClienteNaoExistenteException extends ResourceNaoExistenteException {
    private static final String mensagem = "Cliente nao existente";
    public ClienteNaoExistenteException(){
        super(mensagem);
    }
}

package com.project.api.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.CONFLICT)
public class ResourceExistenteException extends RuntimeException{
    public ResourceExistenteException(String mensagem){
        super(mensagem);
    }
}

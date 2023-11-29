package com.project.api.coreapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private String nome;
    private String email;
    private Long celular;
}

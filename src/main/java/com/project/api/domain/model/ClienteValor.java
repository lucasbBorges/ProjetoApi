package com.project.api.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ClienteValor {
    private String cliente;
    private BigDecimal valor;
}

package com.project.api.domain.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AtividadeValor {
    private String atividade;
    private BigDecimal valor;
}

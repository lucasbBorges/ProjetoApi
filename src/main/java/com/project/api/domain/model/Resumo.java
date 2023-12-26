package com.project.api.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Resumo {
    private BigDecimal valor;
    private List<AtividadeValor> atividadeValorList;
}

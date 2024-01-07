package com.project.api.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class FaturamentoMes {
    private int ano;
    private int mes;
    private BigDecimal valor;
}

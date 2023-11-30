package com.project.api.coreapi.model.input;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PagamentoInput {
    private BigDecimal valor;
    private ClienteInput cliente;
    private MeioPagamentoInput meioPagamento;
    private LocalDateTime dataPagamento;

}

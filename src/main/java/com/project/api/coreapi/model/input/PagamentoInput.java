package com.project.api.coreapi.model.input;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagamentoInput {
    private BigDecimal valor;
    private ClienteInput cliente;
    private MeioPagamentoInput meioPagamento;
    private LocalDateTime dataPagamento;

}

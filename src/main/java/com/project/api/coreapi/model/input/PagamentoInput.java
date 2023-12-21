package com.project.api.coreapi.model.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class PagamentoInput {
    private BigDecimal valor;
    private ClienteInput cliente;
    private MeioPagamentoInput meioPagamento;
    private AtividadeInput atividade;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataPagamento;

}

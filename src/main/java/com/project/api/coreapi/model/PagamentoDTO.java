package com.project.api.coreapi.model;

import com.project.api.domain.model.Atividade;
import com.project.api.domain.model.MeioPagamento;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class PagamentoDTO {
    private Long id;
    private BigDecimal valor;
    private MeioPagamento meioPagamento;
    private Atividade atividade;
    private LocalDate dataPagamento;
    private ClienteDTO cliente;
}

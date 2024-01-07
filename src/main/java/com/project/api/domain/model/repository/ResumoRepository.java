package com.project.api.domain.model.repository;

import com.project.api.domain.model.AtividadeValor;
import com.project.api.domain.model.ClienteValor;
import com.project.api.domain.model.FaturamentoMes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ResumoRepository {
    BigDecimal buscarResumoFaturamento(LocalDate dataIni, LocalDate dataFim);
    List<AtividadeValor> buscarAtividadeValor(LocalDate dataIni, LocalDate dataFim);
    List<ClienteValor> buscarClienteValor(LocalDate dataIni, LocalDate dataFim);
    List<FaturamentoMes> buscarFaturamentoMesAMes (LocalDate dataIni, LocalDate dataFim);
}


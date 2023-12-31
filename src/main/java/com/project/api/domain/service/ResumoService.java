package com.project.api.domain.service;

import com.project.api.domain.model.AtividadeValor;
import com.project.api.domain.model.ClienteValor;
import com.project.api.domain.model.FaturamentoMes;
import com.project.api.domain.model.Resumo;
import com.project.api.domain.model.repository.ResumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ResumoService {
    private final ResumoRepository resumoRepository;

    @Autowired
    public ResumoService(ResumoRepository resumoRepository) {
        this.resumoRepository = resumoRepository;
    }

    public Resumo buscarResumo(LocalDate dataIni, LocalDate dataFim){
        Resumo resumo = new Resumo();
        resumo.setValor(buscarFaturamento(dataIni, dataFim));
        resumo.setAtividadeValorList(buscarAtividadeValorList(dataIni, dataFim));
        resumo.setClienteValorList(buscarClienteValorList(dataIni, dataFim));
        resumo.setFaturamentoMesList(buscarFaturamentoMesList(dataIni, dataFim));
        return resumo;
    }

    private BigDecimal buscarFaturamento(LocalDate dataIni, LocalDate dataFim){
        return resumoRepository.buscarResumoFaturamento(dataIni, dataFim);
    }

    private List<AtividadeValor> buscarAtividadeValorList(LocalDate dataIni, LocalDate dataFim){
        return resumoRepository.buscarAtividadeValor(dataIni, dataFim);
    }

    private List<ClienteValor> buscarClienteValorList(LocalDate dataIni, LocalDate dataFim){
        return resumoRepository.buscarClienteValor(dataIni, dataFim);
    }

    private List<FaturamentoMes> buscarFaturamentoMesList(LocalDate dataIni, LocalDate dataFim){
        return resumoRepository.buscarFaturamentoMesAMes(dataIni, dataFim);
    }
}

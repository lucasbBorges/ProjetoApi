package com.project.api.domain.model.repository.impl;

import com.project.api.domain.model.AtividadeValor;
import com.project.api.domain.model.ClienteValor;
import com.project.api.domain.model.repository.ResumoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ResumoRepositoryImpl implements ResumoRepository {
    @PersistenceContext
    EntityManager manager;

    @Override
    public BigDecimal buscarResumoFaturamento(LocalDate dataIni, LocalDate dataFim) {
        String sql = "SELECT SUM(VALOR) " +
                     "FROM PAGAMENTO " +
                     "WHERE DATA_PAGAMENTO BETWEEN '" + dataIni.toString() + "' AND '" + dataFim.toString() + "'";
        Query query = manager.createNativeQuery(sql);
        return (BigDecimal) query.getSingleResult();
    }

    @Override
    public List<AtividadeValor> buscarAtividadeValor(LocalDate dataIni, LocalDate dataFim) {
        String sql = "SELECT ATIVIDADE.DESCRICAO, SUM(P.VALOR) " +
                    "FROM PAGAMENTO P " +
                    "LEFT JOIN ATIVIDADE ON P.ATIVIDADE_ID = ATIVIDADE.ID " +
                    "WHERE P.DATA_PAGAMENTO BETWEEN '" + dataIni.toString() + "' AND '" + dataFim.toString() + "' " +
                    "GROUP BY ATIVIDADE.DESCRICAO";
        Query query = manager.createNativeQuery(sql);
        List<Object[]> resultList = query.getResultList();

        return resultList
                .stream()
                .map(list -> {
                    AtividadeValor atividadeValor = new AtividadeValor();
                    atividadeValor.setAtividade((String) list[0]);
                    atividadeValor.setValor((BigDecimal) list[1]);
                    return atividadeValor;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ClienteValor> buscarClienteValor(LocalDate dataIni, LocalDate dataFim) {
        String sql = "SELECT CLIENTE.NOME, SUM(PAGAMENTO.VALOR) " +
                    "FROM PAGAMENTO " +
                    "LEFT JOIN CLIENTE ON PAGAMENTO.CLIENTE_ID = CLIENTE.ID " +
                    "WHERE PAGAMENTO.DATA_PAGAMENTO BETWEEN '" + dataIni.toString() + "' AND '" + dataFim.toString() + "' " +
                    "GROUP BY CLIENTE.NOME";

        Query query = manager.createNativeQuery(sql);
        List<Object[]> resultList = query.getResultList();

        return resultList
                .stream()
                .map(list -> {
                    ClienteValor clienteValor = new ClienteValor();
                    clienteValor.setCliente((String) list[0]);
                    clienteValor.setValor((BigDecimal) list[1]);
                    return clienteValor;
                })
                .collect(Collectors.toList());
    }
}

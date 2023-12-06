package com.project.api.domain.model.repository;

import com.project.api.domain.model.Cliente;
import com.project.api.domain.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByClienteId(Long id);
    List<Pagamento> findByClienteIdAndDataPagamentoBetween(Long id, LocalDate dataIni, LocalDate dataFim);
    List<Pagamento> findByDataPagamentoBetween(LocalDate dataIni, LocalDate dataFim);
}

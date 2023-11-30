package com.project.api.domain.model.repository;

import com.project.api.domain.model.MeioPagamento;
import com.project.api.domain.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeioPagamentoRepository extends JpaRepository<MeioPagamento, Long> {
}

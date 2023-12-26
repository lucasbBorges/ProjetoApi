package com.project.api.domain.model.repository;

import com.project.api.domain.model.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    public Boolean existsByDescricao(String descricao);
    public List<Atividade> findByDescricaoContaining(String descricao);
}

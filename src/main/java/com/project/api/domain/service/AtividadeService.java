package com.project.api.domain.service;

import com.project.api.domain.exceptions.atividade.AtividadeNaoExistenteException;
import com.project.api.domain.exceptions.meiopagamento.MeioPagamentoNaoExistenteException;
import com.project.api.domain.model.Atividade;
import com.project.api.domain.model.MeioPagamento;
import com.project.api.domain.model.repository.AtividadeRepository;
import com.project.api.domain.model.repository.MeioPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {
    @Autowired
    AtividadeRepository atividadeRepository;

    public List<Atividade> listar(){
        return atividadeRepository.findAll();
    }

    public Atividade buscar(Long id){
        return atividadeRepository.findById(id)
                .orElseThrow(AtividadeNaoExistenteException::new);
    }
}

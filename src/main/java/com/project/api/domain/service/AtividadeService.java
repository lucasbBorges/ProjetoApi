package com.project.api.domain.service;

import com.project.api.domain.exceptions.atividade.AtividadeEmUsoException;
import com.project.api.domain.exceptions.atividade.AtividadeNaoExistenteException;
import com.project.api.domain.exceptions.cliente.ClienteEmUsoException;
import com.project.api.domain.exceptions.meiopagamento.MeioPagamentoNaoExistenteException;
import com.project.api.domain.model.Atividade;
import com.project.api.domain.model.Cliente;
import com.project.api.domain.model.MeioPagamento;
import com.project.api.domain.model.ResourceEnum;
import com.project.api.domain.model.repository.AtividadeRepository;
import com.project.api.domain.model.repository.MeioPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public List<Atividade> buscarPorNome (String nome){
        return atividadeRepository.findByDescricaoContaining(nome);
    }

    public Atividade salvar (Atividade atividade){
        return atividadeRepository.save(atividade);
    }

    public void deletar(Long id){
        try{
            Atividade atividade = buscar(id);
            atividadeRepository.delete(atividade);
        }catch (DataIntegrityViolationException e){
            throw new AtividadeEmUsoException();
        }
    }
}

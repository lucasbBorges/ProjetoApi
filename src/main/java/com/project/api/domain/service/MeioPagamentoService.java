package com.project.api.domain.service;

import com.project.api.domain.exceptions.meiopagamento.MeioPagamentoNaoExistenteException;
import com.project.api.domain.model.MeioPagamento;
import com.project.api.domain.model.repository.MeioPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeioPagamentoService {
    @Autowired
    MeioPagamentoRepository meioPagamentoRepository;

    public List<MeioPagamento> listar(){
        return meioPagamentoRepository.findAll();
    }

    public MeioPagamento buscar(Long id){
        return meioPagamentoRepository.findById(id)
                .orElseThrow(MeioPagamentoNaoExistenteException::new);
    }
}

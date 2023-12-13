package com.project.api.coreapi.controller;

import com.project.api.domain.model.Atividade;
import com.project.api.domain.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    AtividadeService atividadeService;

    @GetMapping
    public List<Atividade> listarAtividades(){
        return atividadeService.listar();
    }

    @GetMapping("/{atividadeid}")
    public Atividade buscarAtividade(@PathVariable("atividadeid") Long id){
        return atividadeService.buscar(id);
    }
}

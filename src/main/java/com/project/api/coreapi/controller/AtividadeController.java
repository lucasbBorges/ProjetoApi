package com.project.api.coreapi.controller;

import com.project.api.domain.model.Atividade;
import com.project.api.domain.model.ResourceEnum;
import com.project.api.domain.service.AtividadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/nome/{nomeatividade}")
    public List<Atividade> buscarPorNome(@PathVariable("nomeatividade") String nome){
        return atividadeService.buscarPorNome(nome);
    }

    @PostMapping
    public Atividade cadastrarAtividade(@RequestBody Atividade atividade){
        return atividadeService.salvar(atividade, ResourceEnum.RESOURCE_POST);
    }

    @PutMapping("/{atividadeid}")
    public Atividade alterarAtividade(@PathVariable("atividadeid") Long id,
                                      @RequestBody Atividade atividade) {
        Atividade atividadeAtual = atividadeService.buscar(id);
        BeanUtils.copyProperties(atividade, atividadeAtual, "id");
        return atividadeService.salvar(atividadeAtual, ResourceEnum.RESOURCE_PUT);
    }

    @DeleteMapping("/{atividadeid}")
    public void deletar(@PathVariable("atividadeid") Long id){
        atividadeService.deletar(id);
    }
}

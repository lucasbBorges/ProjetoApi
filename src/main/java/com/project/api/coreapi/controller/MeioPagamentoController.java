package com.project.api.coreapi.controller;

import com.project.api.domain.model.MeioPagamento;
import com.project.api.domain.service.MeioPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meio-pagamento")
public class MeioPagamentoController {
    @Autowired
    MeioPagamentoService meioPagamentoService;

    @GetMapping
    public List<MeioPagamento> listarMeiosPagamento(){
        return meioPagamentoService.listar();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{meioPagamentoId}")
    public MeioPagamento buscarMeioPagamento(@PathVariable("meioPagamentoId") Long id){
        return meioPagamentoService.buscar(id);
    }
}

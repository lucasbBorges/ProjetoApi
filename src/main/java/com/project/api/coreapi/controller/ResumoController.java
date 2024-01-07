package com.project.api.coreapi.controller;

import com.project.api.coreapi.model.PagamentoDTO;
import com.project.api.domain.model.Atividade;
import com.project.api.domain.model.AtividadeValor;
import com.project.api.domain.model.Resumo;
import com.project.api.domain.service.ResumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/resumo")
public class ResumoController {
    @Autowired
    private ResumoService resumoService;

    @GetMapping
    public Resumo listar(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataIni,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim
    ){
        return resumoService.buscarResumo(dataIni, dataFim);
    }
}

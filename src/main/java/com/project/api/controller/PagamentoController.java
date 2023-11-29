package com.project.api.controller;

import com.project.api.domain.model.Pagamento;
import com.project.api.domain.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    PagamentoService pagamentoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Pagamento> listarPagamento(){
        return pagamentoService.listar();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{pagamentoid}")
    public Pagamento buscarPagamento(@PathVariable("pagamentoid") Long id){
        return pagamentoService.buscar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cliente/{clienteid}")
    public List<Pagamento> buscarPagamentoPorNome(@PathVariable("clienteid") Long id){
        return pagamentoService.buscarPorCliente(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Pagamento cadastrarPagamento(@RequestBody Pagamento pagamento){
        return pagamentoService.salvar(pagamento);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{pagamentoid}")
    public Pagamento alterarPagamento(@PathVariable("pagamentoid") Long id,
                                      @RequestBody Pagamento pagamento) {
        return pagamentoService.salvar(pagamento);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{pagamento}")
    public void remover(@PathVariable("pagamentoid") Long id) {
        pagamentoService.deletar(id);
    }
}

package com.project.api.coreapi.controller;

import com.project.api.coreapi.model.ClienteDTO;
import com.project.api.coreapi.model.PagamentoDTO;
import com.project.api.domain.model.Pagamento;
import com.project.api.domain.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    PagamentoService pagamentoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PagamentoDTO> listarPagamento(){
        return toModelList(pagamentoService.listar());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{pagamentoid}")
    public PagamentoDTO buscarPagamento(@PathVariable("pagamentoid") Long id){
        return toModel(pagamentoService.buscar(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cliente/{clienteid}")
    public List<PagamentoDTO> buscarPagamentoPorNome(@PathVariable("clienteid") Long id){
        return toModelList(pagamentoService.buscarPorCliente(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public PagamentoDTO cadastrarPagamento(@RequestBody Pagamento pagamento){
        return toModel(pagamentoService.salvar(pagamento));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{pagamentoid}")
    public PagamentoDTO alterarPagamento(@PathVariable("pagamentoid") Long id,
                                      @RequestBody Pagamento pagamento) {
        return toModel(pagamentoService.salvar(pagamento));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{pagamentoid}")
    public void remover(@PathVariable("pagamentoid") Long id) {
        pagamentoService.deletar(id);
    }

    private PagamentoDTO toModel(Pagamento pagamento){
        PagamentoDTO pagamentoDTO = new PagamentoDTO();
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId(pagamento.getCliente().getId());
        clienteDTO.setNome(pagamento.getCliente().getNome());
        clienteDTO.setEmail(pagamento.getCliente().getEmail());
        clienteDTO.setCelular(pagamento.getCliente().getCelular());

        pagamentoDTO.setId(pagamento.getId());
        pagamentoDTO.setValor(pagamento.getValor());
        pagamentoDTO.setTipoPagamento(pagamento.getMeioPagamento().getDescricao());
        pagamentoDTO.setDataPagamento(pagamento.getDataPagamento());
        pagamentoDTO.setCliente(clienteDTO);

        return pagamentoDTO;
    }

    private List<PagamentoDTO> toModelList(List<Pagamento> pagamentos){
        return pagamentos.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}

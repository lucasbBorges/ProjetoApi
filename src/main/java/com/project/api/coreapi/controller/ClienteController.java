package com.project.api.coreapi.controller;

import com.project.api.coreapi.model.ClienteDTO;
import com.project.api.domain.exceptions.cliente.ClienteExistenteException;
import com.project.api.domain.model.Cliente;
import com.project.api.domain.model.ResourceEnum;
import com.project.api.domain.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteService.listar();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{clienteId}")
    public Cliente buscarCliente(@PathVariable("clienteId") Long id) {
        return clienteService.buscar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/nome/{nome}")
    public List<Cliente> buscarClientePorNome(@PathVariable("nome") String nome) {
        return clienteService.buscarPorNome(nome);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente, ResourceEnum.RESOURCE_POST);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{clienteid}")
    public Cliente alterarCliente(@PathVariable("clienteid") Long id
            , @RequestBody Cliente cliente) {
        Cliente clienteAtual, clienteVerifica;

        clienteVerifica = clienteService.buscarPorEmail(cliente.getEmail());
        clienteAtual = clienteService.buscar(id);

        clienteService.alteracaoEhValida(clienteVerifica, clienteAtual);

        BeanUtils.copyProperties(cliente, clienteAtual, "id",
                "dataCadastro");
        return clienteService.salvar(clienteAtual, ResourceEnum.RESOURCE_PUT);
    }

    @PutMapping("/{clienteid}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void ativar(@PathVariable("clienteid") Long clienteId) {
        clienteService.ativar(clienteId);
    }

    @DeleteMapping("/{clienteid}/ativo")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@PathVariable("clienteid") Long clienteId) {
        clienteService.inativar(clienteId);
    }

}

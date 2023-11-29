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
    public List<ClienteDTO> listarClientes(){
        return toModelList(clienteService.listar());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{clienteId}")
    public ClienteDTO buscarCliente(@PathVariable("clienteId") Long id) {
        return toModel(clienteService.buscar(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/nome/{nome}")
    public List<ClienteDTO> buscarClientePorNome(@PathVariable("nome") String nome) {
        return toModelList(clienteService.buscarPorNome(nome));
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public ClienteDTO cadastrarCliente(@RequestBody Cliente cliente) {
        return toModel(clienteService.salvar(cliente, ResourceEnum.RESOURCE_POST));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{clienteid}")
    public ClienteDTO alterarCliente(@PathVariable("clienteid") Long id
            , @RequestBody Cliente cliente) {
        Cliente clienteAtual, clienteVerifica;

        clienteVerifica = clienteService.buscarPorEmail(cliente.getEmail());
        clienteAtual = clienteService.buscar(id);

        clienteService.alteracaoEhValida(clienteVerifica, clienteAtual);

        BeanUtils.copyProperties(cliente, clienteAtual, "id",
                "dataCadastro");
        return toModel(clienteService.salvar(clienteAtual, ResourceEnum.RESOURCE_PUT));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{clienteid}")
    public void remover(@PathVariable("clienteid") Long id) {
        clienteService.deletar(id);
    }

    private ClienteDTO toModel(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNome(cliente.getNome());
        clienteDTO.setEmail(clienteDTO.getEmail());
        clienteDTO.setCelular(cliente.getCelular());

        return clienteDTO;
    }

    private List<ClienteDTO> toModelList(List<Cliente> clientes){
        return clientes.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}

package com.project.api.domain.service;

import com.project.api.domain.exceptions.cliente.ClienteEmUsoException;
import com.project.api.domain.exceptions.cliente.ClienteExistenteException;
import com.project.api.domain.exceptions.cliente.ClienteNaoExistenteException;
import com.project.api.domain.model.Cliente;
import com.project.api.domain.model.ResourceEnum;
import com.project.api.domain.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorEmail(String email){
        return clienteRepository.findByEmail(email);
    }

    public List<Cliente> buscarPorNome(String nome) {return clienteRepository.findByNomeContaining(nome);}
    public Cliente buscar(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(ClienteNaoExistenteException::new);
    }

    public Cliente salvar(Cliente cliente, ResourceEnum ENUM){
        if (clienteRepository.findByEmail(cliente.getEmail()) != null){
            if (ENUM == ResourceEnum.RESOURCE_POST) {
                throw new ClienteExistenteException();
            } else {
                System.out.println("");
            }
        }
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id){
        try{
            Cliente cozinha = buscar(id);
            clienteRepository.delete(cozinha);
        }catch (DataIntegrityViolationException e){
            throw new ClienteEmUsoException();
        }
    }
}

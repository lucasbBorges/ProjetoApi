package com.project.api.domain.service;

import com.project.api.domain.exceptions.pagamento.PagamentoEmUsoException;
import com.project.api.domain.exceptions.pagamento.PagamentoNaoExistenteException;
import com.project.api.domain.model.Cliente;
import com.project.api.domain.model.Pagamento;
import com.project.api.domain.model.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ClienteService clienteService;

    public List<Pagamento> listar(){
        return pagamentoRepository.findAll();
    }

    public Pagamento buscar(Long id){
        return pagamentoRepository.findById(id)
                .orElseThrow(PagamentoNaoExistenteException::new);
    }

    public List<Pagamento> buscarPorCliente(Long id){
        return pagamentoRepository.findByClienteId(id);
    }

    public Pagamento salvar(Pagamento pagamento){
        Cliente cliente = clienteService.buscar(pagamento.getId());

        return pagamentoRepository.save(pagamento);
    }

    public void deletar(Long id){
        try{
            Pagamento pagamento = buscar(id);
            pagamentoRepository.delete(pagamento);
        }catch (DataIntegrityViolationException e){
            throw new PagamentoEmUsoException();
        }
    }
}

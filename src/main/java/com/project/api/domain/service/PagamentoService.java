package com.project.api.domain.service;

import com.project.api.domain.exceptions.pagamento.PagamentoEmUsoException;
import com.project.api.domain.exceptions.pagamento.PagamentoNaoExistenteException;
import com.project.api.domain.model.Cliente;
import com.project.api.domain.model.MeioPagamento;
import com.project.api.domain.model.Pagamento;
import com.project.api.domain.model.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private MeioPagamentoService meioPagamentoService;

    @Autowired
    private ClienteService clienteService;

    public List<Pagamento> listar(){
        return pagamentoRepository.findAll();
    }

    public Pagamento buscar(Long id){
        return pagamentoRepository.findById(id)
                .orElseThrow(PagamentoNaoExistenteException::new);
    }

    public List<Pagamento> buscarPorCliente(Long clienteId, LocalDate dataIni, LocalDate dataFim){
        if (dataIni == null || dataFim == null){
            return pagamentoRepository.findByClienteId(clienteId);
        } else if(clienteId == null){
            return pagamentoRepository.findByDataPagamentoBetween(dataIni, dataFim);
        }
        return pagamentoRepository.findByClienteIdAndDataPagamentoBetween(
                clienteId, dataIni, dataFim
        );
    }

    public Pagamento salvar(Pagamento pagamento){
        Cliente cliente = clienteService.buscar(pagamento.getCliente().getId());
        MeioPagamento meioPagamento = meioPagamentoService.buscar(pagamento.getMeioPagamento().getId());

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

package com.project.api.coreapi.assembler;

import com.project.api.coreapi.model.input.PagamentoInput;
import com.project.api.domain.model.Atividade;
import com.project.api.domain.model.Cliente;
import com.project.api.domain.model.MeioPagamento;
import com.project.api.domain.model.Pagamento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoInputDisassembler {
    @Autowired
    private ModelMapper modelMapper;

    public Pagamento toDomainObject(PagamentoInput pagamentoInput) {
        return modelMapper.map(pagamentoInput, Pagamento.class);
    }

    public void copyToDomainObject(PagamentoInput pagamentoInput, Pagamento pagamento){
        pagamento.setCliente(new Cliente());
        pagamento.setMeioPagamento(new MeioPagamento());
        pagamento.setAtividade(new Atividade());
        modelMapper.map(pagamentoInput, pagamento);
    }
}

package com.project.api.coreapi.assembler;

import com.project.api.coreapi.model.input.PagamentoInput;
import com.project.api.domain.model.Pagamento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoInputDisassembler {
    @Autowired
    private ModelMapper modelMapper;

    public Pagamento toDomainObject(PagamentoInput restauranteInput) {
        return modelMapper.map(restauranteInput, Pagamento.class);
    }
}
package br.com.api.credit.mapper;


import br.com.api.credit.dto.CreditDTO;
import br.com.api.credit.model.Credit;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreditMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public CreditMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CreditDTO toDTO(Credit credit) {
        return modelMapper.map(credit, CreditDTO.class);
    }

    public List<CreditDTO> toDTOList(List<Credit> credits) {
        return credits.stream().map(this::toDTO).toList();
    }

}
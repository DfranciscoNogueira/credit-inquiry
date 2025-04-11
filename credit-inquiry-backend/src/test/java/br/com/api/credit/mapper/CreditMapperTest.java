package br.com.api.credit.mapper;

import br.com.api.credit.dto.CreditDTO;
import br.com.api.credit.model.Credit;
import br.com.api.credit.stub.CreditStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CreditMapperTest {

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CreditMapper creditMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToDTO() {

        Credit credit = CreditStub.getCredit();
        CreditDTO creditDTO = CreditStub.getCreditDTO();

        when(this.modelMapper.map(credit, CreditDTO.class)).thenReturn(creditDTO);

        CreditDTO result = this.creditMapper.toDTO(credit);

        assertEquals(creditDTO.getTypeCredit(), result.getTypeCredit());
        assertEquals(creditDTO.getBaseCalculate(), result.getBaseCalculate());

    }

    @Test
    void testToDTOList() {

        Credit credit1 = CreditStub.getCredit();
        Credit credit2 = CreditStub.getCredit();

        List<Credit> credits = Arrays.asList(credit1, credit2);

        CreditDTO creditDTO1 = CreditStub.getCreditDTO();
        CreditDTO creditDTO2 = CreditStub.getCreditDTO();

        List<CreditDTO> creditDTOs = Arrays.asList(creditDTO1, creditDTO2);

        when(modelMapper.map(credit1, CreditDTO.class)).thenReturn(creditDTO1);
        when(modelMapper.map(credit2, CreditDTO.class)).thenReturn(creditDTO2);

        List<CreditDTO> result = creditMapper.toDTOList(credits);

        assertEquals(creditDTOs.size(), result.size());
        assertEquals(creditDTOs.get(0).getBaseCalculate(), result.get(0).getBaseCalculate());
        assertEquals(creditDTOs.get(1).getNumberNfse(), result.get(1).getNumberNfse());

    }

}
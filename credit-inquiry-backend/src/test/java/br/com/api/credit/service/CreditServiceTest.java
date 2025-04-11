package br.com.api.credit.service;

import br.com.api.credit.dto.CreditDTO;
import br.com.api.credit.mapper.CreditMapper;
import br.com.api.credit.model.Credit;
import br.com.api.credit.repository.CreditRepository;
import br.com.api.credit.stub.CreditStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CreditServiceTest {

    @Mock
    private CreditRepository repository;

    @Mock
    private CreditMapper mapper;

    @InjectMocks
    private CreditService creditService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByNumberNfse() {

        String numberNfse = "12345";

        Credit credit1 = CreditStub.getCredit();
        Credit credit2 = CreditStub.getCredit();

        List<Credit> credits = Arrays.asList(credit1, credit2);

        CreditDTO creditDTO1 = CreditStub.getCreditDTO();
        CreditDTO creditDTO2 = CreditStub.getCreditDTO();

        List<CreditDTO> creditDTOs = Arrays.asList(creditDTO1, creditDTO2);

        when(this.repository.findByNumberNfse(numberNfse)).thenReturn(credits);
        when(this.mapper.toDTOList(credits)).thenReturn(creditDTOs);

        List<CreditDTO> result = this.creditService.findByNumberNfse(numberNfse);

        assertEquals(creditDTOs.size(), result.size());
        assertEquals(creditDTOs.get(0).getNumberNfse(), result.get(0).getNumberNfse());
        assertEquals(creditDTOs.get(1).getBaseCalculate(), result.get(1).getBaseCalculate());

    }

    @Test
    void testFindByNumberCredit() {

        String numberCredit = "67890";

        Credit credit1 = CreditStub.getCredit();
        Credit credit2 = CreditStub.getCredit();

        List<Credit> credits = Arrays.asList(credit1, credit2);

        CreditDTO creditDTO1 = CreditStub.getCreditDTO();
        CreditDTO creditDTO2 = CreditStub.getCreditDTO();

        List<CreditDTO> creditDTOs = Arrays.asList(creditDTO1, creditDTO2);

        when(this.repository.findByNumberCredit(numberCredit)).thenReturn(credits);
        when(this.mapper.toDTOList(credits)).thenReturn(creditDTOs);

        List<CreditDTO> result = this.creditService.findByNumberCredit(numberCredit);

        assertEquals(creditDTOs.size(), result.size());
        assertEquals(creditDTOs.get(0).getNumberNfse(), result.get(0).getNumberNfse());
        assertEquals(creditDTOs.get(1).getBaseCalculate(), result.get(1).getBaseCalculate());

    }

}
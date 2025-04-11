package br.com.api.credit.controller;


import br.com.api.credit.config.CreditMockConfig;
import br.com.api.credit.dto.CreditDTO;
import br.com.api.credit.service.CreditService;
import br.com.api.credit.stub.CreditStub;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(CreditMockConfig.class)
@WebMvcTest(CreditController.class)
class CreditControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CreditService creditService;

    @Test
    void testByNfse() throws Exception {

        String numberNfse = "12345";

        CreditDTO creditDTO1 = CreditStub.getCreditDTO();
        CreditDTO creditDTO2 = CreditStub.getCreditDTO();

        List<CreditDTO> creditDTOs = Arrays.asList(creditDTO1, creditDTO2);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String expectedJson = objectMapper.writeValueAsString(creditDTOs);

        when(this.creditService.findByNumberNfse(anyString())).thenReturn(creditDTOs);

        this.mockMvc.perform(get("/creditos/{numberNfse}", numberNfse)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }

    @Test
    void testFindByNumberCredit() throws Exception {

        String numberCredit = "67890";
        CreditDTO creditDTO1 = CreditStub.getCreditDTO();
        CreditDTO creditDTO2 = CreditStub.getCreditDTO();

        List<CreditDTO> creditDTOs = Arrays.asList(creditDTO1, creditDTO2);

        when(this.creditService.findByNumberCredit(numberCredit)).thenReturn(creditDTOs);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String expectedJson = objectMapper.writeValueAsString(creditDTOs);

        when(this.creditService.findByNumberCredit(numberCredit)).thenReturn(creditDTOs);

        this.mockMvc.perform(get("/creditos/credito/{numberCredit}", numberCredit)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson));

    }
}
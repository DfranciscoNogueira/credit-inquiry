package br.com.api.credit.config;

import br.com.api.credit.service.CreditService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class CreditMockConfig {

    @Bean
    public CreditService creditService() {
        return Mockito.mock(CreditService.class);
    }

}
package br.com.api.credit.service;

import br.com.api.credit.dto.CreditDTO;
import br.com.api.credit.mapper.CreditMapper;
import br.com.api.credit.model.Credit;
import br.com.api.credit.repository.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService {

    private final CreditRepository repository;
    private final CreditMapper mapper;

    public CreditService(CreditRepository repository, CreditMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CreditDTO> findByNumberNfse(String numberNfse) {
        List<Credit> credits = this.repository.findByNumberNfse(numberNfse);
        return this.mapper.toDTOList(credits);
    }

    public List<CreditDTO> findByNumberCredit(String numberCredit) {
        List<Credit> credits = this.repository.findByNumberCredit(numberCredit);
        return this.mapper.toDTOList(credits);
    }

}

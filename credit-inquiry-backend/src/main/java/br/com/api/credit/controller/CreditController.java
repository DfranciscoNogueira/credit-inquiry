package br.com.api.credit.controller;

import br.com.api.credit.dto.CreditDTO;
import br.com.api.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/creditos")
@CrossOrigin(origins = "http://localhost:4200")
public class CreditController {

    private final CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/{numberNfse}")
    public List<CreditDTO> byNfse(@PathVariable String numberNfse) {
        return this.creditService.findByNumberNfse(numberNfse);
    }

    @GetMapping("/credito/{numberCredit}")
    public List<CreditDTO> byNumberCredit(@PathVariable String numberCredit) {
        return this.creditService.findByNumberCredit(numberCredit);
    }

}

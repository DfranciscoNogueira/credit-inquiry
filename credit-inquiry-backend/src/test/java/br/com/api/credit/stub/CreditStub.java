package br.com.api.credit.stub;

import br.com.api.credit.dto.CreditDTO;
import br.com.api.credit.model.Credit;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditStub {

    public static final String NUMBER_NFSE = "123456789";
    public static final String NUMBER_CREDIT = "987654321";
    public static final BigDecimal AMOUNT = BigDecimal.ONE;
    public static final String TYPE = "MOCK";

    public static CreditDTO getCreditDTO() {
        CreditDTO creditDTO = new CreditDTO();
        creditDTO.setNumberCredit(NUMBER_CREDIT);
        creditDTO.setNumberNfse(NUMBER_NFSE);
        creditDTO.setDateConstitution(LocalDate.now());
        creditDTO.setValueIssqn(AMOUNT);
        creditDTO.setTypeCredit(TYPE);
        creditDTO.setSimpleNational(true);
        creditDTO.setAliquot(AMOUNT);
        creditDTO.setValueInvoiced(AMOUNT);
        creditDTO.setValueDeduction(AMOUNT);
        creditDTO.setBaseCalculate(AMOUNT);
        return creditDTO;
    }

    public static Credit getCredit() {
        Credit credit = new Credit();
        credit.setId(1L);
        credit.setNumberCredit(NUMBER_CREDIT);
        credit.setNumberNfse(NUMBER_NFSE);
        credit.setDateConstitution(LocalDate.now());
        credit.setValueIssqn(AMOUNT);
        credit.setTypeCredit(TYPE);
        credit.setSimpleNational(true);
        credit.setAliquot(AMOUNT);
        credit.setValueInvoiced(AMOUNT);
        credit.setValueDeduction(AMOUNT);
        credit.setBaseCalculate(AMOUNT);
        return credit;
    }

}

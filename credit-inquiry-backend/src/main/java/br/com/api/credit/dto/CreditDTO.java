package br.com.api.credit.dto;

import br.com.api.credit.config.MoneySerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditDTO {

    @JsonProperty("numeroCredito")
    private String numberCredit;

    @JsonProperty("numeroNfse")
    private String numberNfse;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty("dataConstituicao")
    private LocalDate dateConstitution;

    @JsonProperty("valorIssqn")
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal valueIssqn;

    @JsonProperty("tipoCredito")
    private String typeCredit;

    @JsonProperty("simplesNacional")
    private boolean simpleNational;

    @JsonProperty("aliquota")
    private BigDecimal aliquot;

    @JsonProperty("valorFaturado")
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal valueInvoiced;

    @JsonProperty("valorDeducao")
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal valueDeduction;

    @JsonProperty("baseCalculo")
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal baseCalculate;

    public String getNumberCredit() {
        return numberCredit;
    }

    public void setNumberCredit(String numberCredit) {
        this.numberCredit = numberCredit;
    }

    public String getNumberNfse() {
        return numberNfse;
    }

    public void setNumberNfse(String numberNfse) {
        this.numberNfse = numberNfse;
    }

    public LocalDate getDateConstitution() {
        return dateConstitution;
    }

    public void setDateConstitution(LocalDate dateConstitution) {
        this.dateConstitution = dateConstitution;
    }

    public BigDecimal getValueIssqn() {
        return valueIssqn;
    }

    public void setValueIssqn(BigDecimal valueIssqn) {
        this.valueIssqn = valueIssqn;
    }

    public String getTypeCredit() {
        return typeCredit;
    }

    public void setTypeCredit(String typeCredit) {
        this.typeCredit = typeCredit;
    }

    public boolean isSimpleNational() {
        return simpleNational;
    }

    public void setSimpleNational(boolean simpleNational) {
        this.simpleNational = simpleNational;
    }

    public BigDecimal getAliquot() {
        return aliquot;
    }

    public void setAliquot(BigDecimal aliquot) {
        this.aliquot = aliquot;
    }

    public BigDecimal getValueInvoiced() {
        return valueInvoiced;
    }

    public void setValueInvoiced(BigDecimal valueInvoiced) {
        this.valueInvoiced = valueInvoiced;
    }

    public BigDecimal getValueDeduction() {
        return valueDeduction;
    }

    public void setValueDeduction(BigDecimal valueDeduction) {
        this.valueDeduction = valueDeduction;
    }

    public BigDecimal getBaseCalculate() {
        return baseCalculate;
    }

    public void setBaseCalculate(BigDecimal baseCalculate) {
        this.baseCalculate = baseCalculate;
    }

}
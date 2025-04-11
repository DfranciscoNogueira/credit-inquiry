package br.com.api.credit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "credito")
public class Credit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "numero_credito")
    private String numberCredit;

    @NotNull
    @Size(max = 50)
    @Column(name = "numero_nfse")
    private String numberNfse;

    @NotNull
    @Column(name = "data_constituicao")
    private LocalDate dateConstitution;

    @NotNull
    @Column(name = "valor_issqn")
    private BigDecimal valueIssqn;

    @NotNull
    @Size(max = 50)
    @Column(name = "tipo_credito")
    private String typeCredit;

    @NotNull
    @Column(name = "simples_nacional")
    private boolean simpleNational;

    @NotNull
    @Column(name = "aliquota")
    private BigDecimal aliquot;

    @NotNull
    @Column(name = "valor_faturado")
    private BigDecimal valueInvoiced;

    @NotNull
    @Column(name = "valor_deducao")
    private BigDecimal valueDeduction;

    @NotNull
    @Column(name = "base_calculo")
    private BigDecimal baseCalculate;

    public Credit() {
    }

    public Credit(Long id, String numberCredit, String numberNfse, LocalDate dateConstitution, BigDecimal valueIssqn, String typeCredit, boolean simpleNational, BigDecimal aliquot, BigDecimal valueInvoiced, BigDecimal valueDeduction, BigDecimal baseCalculate) {
        this.id = id;
        this.numberCredit = numberCredit;
        this.numberNfse = numberNfse;
        this.dateConstitution = dateConstitution;
        this.valueIssqn = valueIssqn;
        this.typeCredit = typeCredit;
        this.simpleNational = simpleNational;
        this.aliquot = aliquot;
        this.valueInvoiced = valueInvoiced;
        this.valueDeduction = valueDeduction;
        this.baseCalculate = baseCalculate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
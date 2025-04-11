package br.com.api.credit.repository;

import br.com.api.credit.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {

    List<Credit> findByNumberNfse(String numberNfse);

    List<Credit> findByNumberCredit(String numberCredit);

}
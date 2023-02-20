package com.example.fex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * A repository interface for managing CurrencyPair objects in the database.
 */
@Repository
public interface CurrencyPairRepository extends JpaRepository<CurrencyPair, Long> {

    Optional<CurrencyPair> findBySourceCurrencyAndTargetCurrency(String sourceCurrency, String targetCurrency);

    List<CurrencyPair> findByActiveTrue();

}

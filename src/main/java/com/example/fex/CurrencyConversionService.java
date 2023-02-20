package com.example.fex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyConversionService {

    @Autowired
    private CurrencyPairRepository currencyPairRepository;

    public double convertCurrency(String sourceCurrency, String targetCurrency, double amount) throws CurrencyPairNotFoundException {
        Optional<CurrencyPair> currencyPair = currencyPairRepository.findBySourceCurrencyAndTargetCurrency(sourceCurrency, targetCurrency);
        if (currencyPair.isEmpty()) {
            throw new CurrencyPairNotFoundException("No active currency pair found for the given source and target currencies.");
        }
        double exchangeRate = currencyPair.get().getExchangeRate();
        return amount * exchangeRate;
    }

}



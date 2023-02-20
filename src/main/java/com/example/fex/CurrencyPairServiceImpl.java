package com.example.fex;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * An implementation of the CurrencyPairService interface that interacts with the database through a CurrencyPairRepository.
 */
@Service
public class CurrencyPairServiceImpl implements CurrencyPairService {

    @Autowired
    private CurrencyPairRepository currencyPairRepository;

    @Override
    public CurrencyPair addCurrencyPair(CurrencyPair currencyPair) {
        return currencyPairRepository.save(currencyPair);
    }

    @Override
    public CurrencyPair updateCurrencyPair(Long id, CurrencyPair currencyPair) throws CurrencyPairNotFoundException {
        CurrencyPair existingCurrencyPair = currencyPairRepository.findById(id)
                .orElseThrow(() -> new CurrencyPairNotFoundException("Currency pair not found for id: " + id));
        existingCurrencyPair.setSourceCurrency(currencyPair.getSourceCurrency());
        existingCurrencyPair.setTargetCurrency(currencyPair.getTargetCurrency());
        existingCurrencyPair.setExchangeRate(currencyPair.getExchangeRate());
        existingCurrencyPair.setActive(true);
        return currencyPairRepository.save(existingCurrencyPair);
    }

    @Override
    public CurrencyPair deactivateCurrencyPair(Long id) throws CurrencyPairNotFoundException {
        CurrencyPair existingCurrencyPair = currencyPairRepository.findById(id)
                .orElseThrow(() -> new CurrencyPairNotFoundException("Currency pair not found for id: " + id));
        existingCurrencyPair.setActive(false);
        return currencyPairRepository.save(existingCurrencyPair);
    }

    @Override
    public CurrencyPair activateCurrencyPair(Long id) throws CurrencyPairNotFoundException {
        CurrencyPair existingCurrencyPair = currencyPairRepository.findById(id)
                .orElseThrow(() -> new CurrencyPairNotFoundException("Currency pair not found for id: " + id));
        existingCurrencyPair.setActive(true);
        return currencyPairRepository.save(existingCurrencyPair);
    }


    @Override
    public List<CurrencyPair> getAllCurrencyPairs() {
        return currencyPairRepository.findAll();
    }

    @Override
    public CurrencyPair getCurrencyPairById(long l) {
        return currencyPairRepository.getReferenceById(l);
    }
}

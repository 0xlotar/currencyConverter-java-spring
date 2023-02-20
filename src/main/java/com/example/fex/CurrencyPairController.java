package com.example.fex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A Spring Boot REST controller that handles requests for managing currency pairs.
 * This controller exposes endpoints for adding, updating, and [de]activating currency pairs.
 */
@RestController
@RequestMapping("/management")
public class CurrencyPairController {

    @Autowired
    private CurrencyPairService currencyPairService;

    /**
     * Adds a new currency pair to the database.
     *
     * @param currencyPair the CurrencyPair object to be added
     * @return the CurrencyPair object that was added
     */

    @PostMapping("/currency_pair")
    public CurrencyPair addCurrencyPair(@RequestBody CurrencyPair currencyPair) {
        return currencyPairService.addCurrencyPair(currencyPair);
    }

    @PutMapping("/currency_pair/{id}")
    public CurrencyPair updateCurrencyPair(@PathVariable Long id, @RequestBody CurrencyPair currencyPair) throws CurrencyPairNotFoundException {
        return currencyPairService.updateCurrencyPair(id, currencyPair);
    }

    @PutMapping("/currency_pair/{id}/deactivate")
    public CurrencyPair deactivateCurrencyPair(@PathVariable Long id) throws CurrencyPairNotFoundException {
        return currencyPairService.deactivateCurrencyPair(id);
    }

    @PutMapping("/currency_pair/{id}/activate")
    public CurrencyPair activateCurrencyPair(@PathVariable Long id) throws CurrencyPairNotFoundException {
        return currencyPairService.activateCurrencyPair(id);
    }

    @GetMapping("/currency_pairs")
    public List<CurrencyPair> getAllCurrencyPairs() {
        return currencyPairService.getAllCurrencyPairs();
    }


}

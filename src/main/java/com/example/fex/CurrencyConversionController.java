package com.example.fex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/end_user")
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionService currencyConversionService;

    @GetMapping("/currency_conversion")
    public double convertCurrency(@RequestParam String sourceCurrency, @RequestParam String targetCurrency, @RequestParam double amount) throws CurrencyPairNotFoundException {
        return currencyConversionService.convertCurrency(sourceCurrency, targetCurrency, amount);
    }



}

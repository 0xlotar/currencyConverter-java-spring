package com.example.fex;

public class CurrencyPairNotFoundException extends Exception {
    public CurrencyPairNotFoundException(String message) {
        super(message);
    }
}

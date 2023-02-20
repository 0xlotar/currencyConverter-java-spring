package com.example.fex;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * A representation of a currency pair, consisting of a source currency and a target currency.
 * The exchange rate for converting from the source to the target currency is also included.
 */
@Entity
@Table(name = "currency_pair")
@Getter
@Setter
public class CurrencyPair {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "source_currency")
        private String sourceCurrency;

        @Column(name = "target_currency")
        private String targetCurrency;

        @Column(name = "exchange_rate")
        private double exchangeRate;

        @Column(name = "active")
        private boolean active;

        // getters and setters
}
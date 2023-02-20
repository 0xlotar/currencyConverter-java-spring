package com.example.fex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CurrencyPairServiceImplTest {

    @Mock
    private CurrencyPairRepository currencyPairRepository;

    @InjectMocks
    private CurrencyPairServiceImpl currencyPairService;

    @Test
    public void testGetAllCurrencyPairs() {
        // Setup
        CurrencyPair cp1 = new CurrencyPair();
        cp1.setId(1L);
        cp1.setSourceCurrency("USD");
        cp1.setTargetCurrency("EUR");
        cp1.setExchangeRate(0.82);
        cp1.setActive(true);

        CurrencyPair cp2 = new CurrencyPair();
        cp2.setId(2L);
        cp2.setSourceCurrency("USD");
        cp2.setTargetCurrency("JPY");
        cp2.setExchangeRate(109.05);
        cp2.setActive(true);

        List<CurrencyPair> currencyPairs = Arrays.asList(cp1, cp2);
        when(currencyPairRepository.findAll()).thenReturn(currencyPairs);

        // Execution
        List<CurrencyPair> actualCurrencyPairs = currencyPairService.getAllCurrencyPairs();

        // Verification
        assertEquals(currencyPairs, actualCurrencyPairs);
        verify(currencyPairRepository, times(1)).findAll();
    }

    @Test
    public void testAddCurrencyPair() {
        // Setup
        CurrencyPair cp = new CurrencyPair();
        cp.setId(1L);
        cp.setSourceCurrency("USD");
        cp.setTargetCurrency("EUR");
        cp.setExchangeRate(0.82);
        cp.setActive(true);

        when(currencyPairRepository.save(cp)).thenReturn(cp);

        // Execution
        CurrencyPair actualCurrencyPair = currencyPairService.addCurrencyPair(cp);

        // Verification
        assertEquals(cp, actualCurrencyPair);
        verify(currencyPairRepository, times(1)).save(cp);
    }
}
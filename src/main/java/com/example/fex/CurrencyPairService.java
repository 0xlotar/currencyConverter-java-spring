package com.example.fex;

import java.util.List;
/**
 * A service interface for managing CurrencyPair objects in the database.
 */
public interface CurrencyPairService {
    /**
     * Adds a new currency pair to the database.
     *
     * @param currencyPair the CurrencyPair object to be added
     * @return the CurrencyPair object that was added
     */
    CurrencyPair addCurrencyPair(CurrencyPair currencyPair);

    /**
     * Updates an existing currency pair in the database.
     *
     * @param id the ID of the currency pair to be updated
     * @param currencyPair the updated CurrencyPair object
     * @return the CurrencyPair object that was updated
     * @throws CurrencyPairNotFoundException if the currency pair with the specified ID was not found
     */
    CurrencyPair updateCurrencyPair(Long id, CurrencyPair currencyPair) throws CurrencyPairNotFoundException;

    /**
     * Deactivates an existing currency pair in the database.
     *
     * @param id the ID of the currency pair to be deactivated
     * @return the CurrencyPair object that was deactivated
     * @throws CurrencyPairNotFoundException if the currency pair with the specified ID was not found
     */
    CurrencyPair deactivateCurrencyPair(Long id) throws CurrencyPairNotFoundException;

    /**
     * Activates an existing currency pair in the database.
     *
     * @param id the ID of the currency pair to be deactivated
     * @return the CurrencyPair object that was activated
     * @throws CurrencyPairNotFoundException if the currency pair with the specified ID was not found
     */
    CurrencyPair activateCurrencyPair(Long id) throws CurrencyPairNotFoundException;

    /**
     * Retrieves a list of all currency pairs stored in the database.
     *
     * @return a List of CurrencyPair objects representing all currency pairs in the database
     */
    List<CurrencyPair> getAllCurrencyPairs();

    CurrencyPair getCurrencyPairById(long l);
}

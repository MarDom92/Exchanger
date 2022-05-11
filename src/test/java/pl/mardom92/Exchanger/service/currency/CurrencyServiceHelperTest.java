package pl.mardom92.Exchanger.service.currency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mardom92.Exchanger.model.Currency;
import pl.mardom92.Exchanger.model.NbpArrayResponse;
import pl.mardom92.Exchanger.model.exception.currency.CurrencyException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyServiceHelperTest {

    private CurrencyServiceHelper currencyServiceHelper;

    @BeforeEach
    void initializeServiceHelper() {
        currencyServiceHelper = new CurrencyServiceHelper();
    }

    @Test
    void shouldThrowExceptionWhenCheckLengthOfNbpArrayResponseAndArrayIsEmpty() {

        //given
        List<Currency> rates = new ArrayList<>();

        NbpArrayResponse[] array = new NbpArrayResponse[1];
        array[0] = new NbpArrayResponse(
                "C",
                "090/C/NBP/2022",
                "2022-05-10",
                "2022-05-11",
                rates
        );

        //when
        try {
            currencyServiceHelper.checkLengthOfNbpArrayResponse(array);
        } catch (CurrencyException exception) {

            //then
            assertEquals("List of currencies is empty.", exception.getCurrencyError().getMessage());
        }
    }

    @Test
    void shouldReturnSizeWhenCheckLengthOfNbpArrayResponseAndArrayIsNotEmpty() {

        //given
        List<Currency> rates = new ArrayList<>();

        NbpArrayResponse[] array = new NbpArrayResponse[1];
        array[0] = new NbpArrayResponse(
                "C",
                "090/C/NBP/2022",
                "2022-05-10",
                "2022-05-11",
                rates
        );

        //when
        int size = currencyServiceHelper.checkLengthOfNbpArrayResponse(array);

        //then
        assertEquals(1, size);
    }

    @Test
    void shouldThrowExceptionWhenCheckSizeOfListAndCurrencyIsEmpty() {

        //given
        List<Currency> currencies = new ArrayList<>();

        //when
        try {
            currencyServiceHelper.checkSizeOfListCurrency(currencies);
        } catch (CurrencyException exception) {

            //then
            assertEquals("List of currencies is empty.", exception.getCurrencyError().getMessage());
        }
    }

    @Test
    void shouldReturnSizeWhenCheckSizeOfListAndCurrencyIsNotEmpty() {

        //given
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency());

        //when
        int size = currencyServiceHelper.checkSizeOfListCurrency(currencies);

        //then
        assertEquals(1, size);
    }
}
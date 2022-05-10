package pl.mardom92.Exchanger.service.exchange;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mardom92.Exchanger.model.dto.ExchangeDto;
import pl.mardom92.Exchanger.model.entity.ExchangeEntity;
import pl.mardom92.Exchanger.model.exception.exchange.ExchangeException;
import pl.mardom92.Exchanger.repository.ExchangeRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExchangeServiceHelperTest {

    private ExchangeServiceHelper exchangeServiceHelper;
    private ExchangeRepository exchangeRepository;

    @BeforeEach
    void initializeServiceHelper() {
        exchangeServiceHelper = new ExchangeServiceHelper(exchangeRepository);
    }

    @Test
    void shouldThrowExceptionWhenCheckSizeOfListAndExchangeIsEmpty() {

        //given
        List<ExchangeEntity> entities = new ArrayList<>();

        //when
        try {
            exchangeServiceHelper.checkSizeOfList(entities);
        } catch (ExchangeException exception) {

            //then
            assertEquals("List of exchanges is empty.", exception.getExchangeError().getMessage());
        }
    }

    @Test
    void shouldReturnSizeWhenCheckSizeOfListAndExchangeIsNotEmpty() {

        //given
        List<ExchangeEntity> entities = new ArrayList<>();
        entities.add(new ExchangeEntity());

        //when
        int size = exchangeServiceHelper.checkSizeOfList(entities);

        //then
        assertEquals(1, size);
    }

    @Test
    void shouldThrowExceptionWhenCheckPageNumberIsLessThanOne() {

        //given
        int pageNumber = -1;

        //when
        try {
            exchangeServiceHelper.checkPageNumber(pageNumber);
        } catch (ExchangeException exception) {

            //then
            assertEquals("Wrong parameter value.", exception.getExchangeError().getMessage());
        }
    }

    @Test
    void shouldReturnPageWhenCheckPageNumber() {

        //given
        int pageNumber = 2;

        //when
        int page = exchangeServiceHelper.checkPageNumber(pageNumber);

        //then
        assertEquals(2, page);
    }

    @Test
    void shouldThrowExceptionWhenCheckSizeOnPageAndSizeOnPageIsGreaterThanMaxSize() {

        //given
        int pageNumber = 5;
        int maxSize = 3;

        //when
        try {
            exchangeServiceHelper.checkSizeOnPage(pageNumber, maxSize);
        } catch (ExchangeException exception) {

            //then
            assertEquals("Wrong parameter value.", exception.getExchangeError().getMessage());
        }
    }

    @Test
    void shouldThrowExceptionWhenCheckSizeOnPageAndSizeOnPageIsLessThanOrEqualToZero() {

        //given
        int pageNumber = -5;
        int maxSize = 3;

        //when
        try {
            exchangeServiceHelper.checkSizeOnPage(pageNumber, maxSize);
        } catch (ExchangeException exception) {

            //then
            assertEquals("Wrong parameter value.", exception.getExchangeError().getMessage());
        }
    }

    @Test
    void shouldReturnSizeWhenCheckSizeOnPage() {

        //given
        int size = 2;

        //when
        int page = exchangeServiceHelper.checkPageNumber(size);

        //then
        assertEquals(2, size);
    }

    @Test
    void shouldThrowExceptionWhenCheckSumAndSumIsLessThanOrEuqalToZero() {

        //given
        double sum = 200.0;

        //when
        try {
            exchangeServiceHelper.checkSum(sum);
        } catch (ExchangeException exception) {

            //then
            assertEquals("Wrong exchange field value.", exception.getExchangeError().getMessage());
        }
    }

    @Test
    void shouldReturnSumWhenCheckSum() {

        //given
        double sum = 200.0;

        //when
        double result = exchangeServiceHelper.checkSum(sum);

        //then
        assertEquals(200.0, result);
    }

    @Test
    void shouldThrowExceptionWhenCheckCurrencyCodeAndCodeIsNull() {

        //given
        String code = "eur";

        //when
        try {
            exchangeServiceHelper.checkCurrencyCode(code);
        } catch (ExchangeException exception) {

            //then
            assertEquals("Wrong exchange field value.", exception.getExchangeError().getMessage());
        }
    }

    @Test
    void shouldReturnCodeToUpperCaseWhenCheckCurrencyCodeAndCodeIsNotNull() {

        //given
        String code = "eur";

        //when
        String result = exchangeServiceHelper.checkCurrencyCode(code);

        //then
        assertEquals("EUR", result);
    }

    @Test
    void shouldThrowExceptionWhenCheckCurrencyCodeIsOnListAndCodeIsNotOnList() {

        //given
        String code = "EUR";
        List<String> currencies = new ArrayList<>();
        currencies.add("USD");
        currencies.add("HUF");

        //when
        try {
            exchangeServiceHelper.checkCurrencyCodeIsOnList(code, currencies);
        } catch (ExchangeException exception) {

            //then
            assertEquals("Wrong parameter value.", exception.getExchangeError().getMessage());
        }
    }

    @Test
    void shouldReturnCodeWhenCheckCurrencyCodeIsOnListAndCodeIsOnList() {

        //given
        String code = "EUR";
        List<String> currencies = new ArrayList<>();
        currencies.add("USD");
        currencies.add("EUR");

        //when
        String result = exchangeServiceHelper.checkCurrencyCodeIsOnList(code, currencies);

        //then
        assertEquals("EUR", result);
    }

    @Test
    void shouldThrowExceptionWhenPartOfFieldsOfExchangeDtoAreEmpty() {

        //given
        ExchangeDto exchangeDto = new ExchangeDto();
        exchangeDto.setAskPrice(100.00);
        exchangeDto.setInputCurrencyCode("EUR");

        //when
        try {
            exchangeServiceHelper.checkExchangeDtoValues(exchangeDto);
        } catch (ExchangeException exception) {

            //then
            assertEquals("Wrong exchange field value.", exception.getExchangeError().getMessage());
        }
    }
}
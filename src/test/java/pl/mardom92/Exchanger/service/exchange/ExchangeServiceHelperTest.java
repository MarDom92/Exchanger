package pl.mardom92.Exchanger.service.exchange;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mardom92.Exchanger.model.dto.ExchangeDto;
import pl.mardom92.Exchanger.model.entity.ExchangeEntity;
import pl.mardom92.Exchanger.model.exception.exchange.ExchangeException;
import pl.mardom92.Exchanger.repository.ExchangeRepository;

import java.util.Collections;
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
    void shouldThrowExceptionWhenListOfExchangeEntityWillBeEmpty() {

        //given
        List<ExchangeEntity> exchangeEntityList = Collections.emptyList();

        //when
        try {
            exchangeServiceHelper.checkEmptyList(exchangeEntityList);
        } catch (ExchangeException exception) {

            //then
            assertEquals("List of exchanges is empty.", exception.getExchangeError().getMessage());
        }
    }

    @Test
    void shouldThrowExceptionWhenNameOfExchangeDtoWillBeBlank() {

        //given
        ExchangeDto exchangeDto = new ExchangeDto();
        exchangeDto.setAskPrice(100.00);
        exchangeDto.setInputCurrencyCode("eur");

        //when
        try {
            exchangeServiceHelper.checkExchangeDtoValues(exchangeDto);
        } catch (ExchangeException exception) {

            //then
            assertEquals("Wrong exchange field value.", exception.getExchangeError().getMessage());
        }
    }
}
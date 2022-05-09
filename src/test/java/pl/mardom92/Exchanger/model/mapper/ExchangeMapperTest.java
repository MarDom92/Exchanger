package pl.mardom92.Exchanger.model.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mardom92.Exchanger.model.builder.ExchangeBuilder;
import pl.mardom92.Exchanger.model.builder.dto.ExchangeDtoBuilder;
import pl.mardom92.Exchanger.model.dto.ExchangeDto;
import pl.mardom92.Exchanger.model.entity.ExchangeEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeMapperTest {

    private ExchangeMapper exchangeMapper;

    @BeforeEach
    void initializeMapperBeforeEachTest() {

        exchangeMapper = new ExchangeMapper();
    }

    @Test
    void shouldReturnNullWhenExchangeDtoWillBeNull() {

        //given
        ExchangeDto exchangeDto = null;

        //when
        ExchangeEntity exchangeEntity = exchangeMapper.fromDtoToEntity(exchangeDto);

        //then
        assertNull(exchangeEntity);
    }

    @Test
    void shouldReturnExchangeEntityWhenExchangeDtoWillBeNotNull() {

        //given
        ExchangeDto exchangeDto = new ExchangeDtoBuilder()
                .withInputSum(100.00)
                .withOutputSum(400.00)
                .withInputCurrnecyCode("eur")
                .withOutputCurrencyCode("usd")
                .withAskPrice(2.00)
                .withBidPrice(2.00)
                .withCreationDate(LocalDateTime.of(2022, 04, 10, 18, 00, 00))
                .build();

        //when
        ExchangeEntity exchangeEntity = exchangeMapper.fromDtoToEntity(exchangeDto);

        //then
        assertAll(
                () -> assertNotNull(exchangeEntity),
                () -> assertEquals(100.00, exchangeEntity.getInputSum()),
                () -> assertEquals(400.00, exchangeEntity.getOutputSum()),
                () -> assertEquals("eur", exchangeEntity.getInputCurrencyCode()),
                () -> assertEquals("usd", exchangeEntity.getOutputCurrencyCode()),
                () -> assertEquals(2.00, exchangeEntity.getAskPrice()),
                () -> assertEquals(2.00, exchangeEntity.getBidPrice()),
                () -> assertEquals(LocalDateTime.of(2022, 04, 10, 18, 00, 00), exchangeEntity.getCreationDate())
        );
    }

    @Test
    void shouldReturnNullWhenExchangeEntityWillBeNull() {

        //given
        ExchangeEntity exchangeEntity = null;

        //when
        ExchangeDto exchangeDto = exchangeMapper.fromEntityToDto(exchangeEntity);

        //then
        assertNull(exchangeDto);
    }

    @Test
    void shouldReturnExchangeDtoWhenExchangeEntityWillBeNotNull() {

        //given
        ExchangeEntity exchangeEntity = new ExchangeBuilder()
                .withId(1L)
                .withInputSum(100.00)
                .withOutputSum(400.00)
                .withInputCurrnecyCode("eur")
                .withOutputCurrencyCode("usd")
                .withAskPrice(2.00)
                .withBidPrice(2.00)
                .withCreationDate(LocalDateTime.of(2022, 04, 10, 18, 00, 00))
                .build();

        //when
        ExchangeDto exchangeDto = exchangeMapper.fromEntityToDto(exchangeEntity);

        //then
        assertAll(
                () -> assertNotNull(exchangeDto),
                () -> assertEquals(100.00, exchangeDto.getInputSum()),
                () -> assertEquals(400.00, exchangeDto.getOutputSum()),
                () -> assertEquals("eur", exchangeDto.getInputCurrencyCode()),
                () -> assertEquals("usd", exchangeDto.getOutputCurrencyCode()),
                () -> assertEquals(2.00, exchangeDto.getAskPrice()),
                () -> assertEquals(2.00, exchangeDto.getBidPrice()),
                () -> assertEquals(LocalDateTime.of(2022, 04, 10, 18, 00, 00), exchangeDto.getCreationDate())
        );
    }
}
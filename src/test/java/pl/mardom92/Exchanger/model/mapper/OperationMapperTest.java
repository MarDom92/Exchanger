package pl.mardom92.Exchanger.model.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mardom92.Exchanger.model.builder.OperationBuilder;
import pl.mardom92.Exchanger.model.builder.dto.OperationDtoBuilder;
import pl.mardom92.Exchanger.model.dto.OperationDto;
import pl.mardom92.Exchanger.model.entity.OperationEntity;
import pl.mardom92.Exchanger.model.enums.OperationStatus;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class OperationMapperTest {

    private OperationMapper operationMapper;

    @BeforeEach
    void initializeMapperBeforeEachTest() {

        operationMapper = new OperationMapper();
    }

    @Test
    void shouldReturnNullWhenOperationDtoWillBeNull() {

        //given
        OperationDto operationDto = null;

        //when
        OperationEntity operationEntity = operationMapper.fromDtoToEntity(operationDto);

        //then
        assertNull(operationEntity);
    }

    @Test
    void shouldReturnOperationEntityWhenOperationDtoWillBeNotNull() {

        //given
        OperationDto operationDto = new OperationDtoBuilder()
                .withOperationStatus(OperationStatus.EXCHANGE_CURRENCY)
                .withCreationDate(new Date(1652108400))
                .build();

        //when
        OperationEntity operationEntity = operationMapper.fromDtoToEntity(operationDto);

        //then
        assertAll(
                () -> assertNotNull(operationEntity),
                () -> assertEquals(OperationStatus.EXCHANGE_CURRENCY, operationEntity.getOperationStatus()),
                () -> assertEquals(new Date(1652108400), operationEntity.getCreationDate())
        );
    }

    @Test
    void shouldReturnNullWhenOperationEntityEntityWillBeNull() {

        //given
        OperationEntity operationEntity = null;

        //when
        OperationDto operationDto = operationMapper.fromEntityToDto(operationEntity);

        //then
        assertNull(operationDto);
    }

    @Test
    void shouldReturnOperationDtoWhenOperationEntityWillBeNotNull() {

        //given
        OperationEntity operationEntity = new OperationBuilder()
                .withOperationStatus(OperationStatus.GET_RATES)
                .withCreationDate(new Date(1652108400))
                .build();

        //when
        OperationDto operationDto = operationMapper.fromEntityToDto(operationEntity);

        //then
        assertAll(
                () -> assertNotNull(operationDto),
                () -> assertEquals(OperationStatus.GET_RATES, operationDto.getOperationStatus()),
                () -> assertEquals(new Date(1652108400), operationDto.getCreationDate())
        );
    }
}
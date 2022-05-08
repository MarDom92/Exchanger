package pl.mardom92.Exchanger.model.mapper;

import pl.mardom92.Exchanger.model.ExchangeEntity;
import pl.mardom92.Exchanger.model.builder.ExchangeBuilder;
import pl.mardom92.Exchanger.model.builder.dto.ExchangeDtoBuilder;
import pl.mardom92.Exchanger.model.dto.ExchangeDto;

import java.util.Objects;

public class ExchangeMapper {

    public ExchangeEntity fromDtoToEntity(ExchangeDto exchangeDto) {

        if (exchangeDto == null) {
            return null;
        }

        ExchangeBuilder exchangeBuilder = new ExchangeBuilder();

        if (exchangeDto.getInputSum() > 0) {
            exchangeBuilder.withInputSum(exchangeDto.getInputSum());
        }

        if (exchangeDto.getOutputSum() > 0) {
            exchangeBuilder.withOutputSum(exchangeDto.getOutputSum());
        }

        if (Objects.nonNull(exchangeDto.getInputCurrencyCode())) {
            exchangeBuilder.withInputCurrnecyCode(exchangeDto.getInputCurrencyCode());
        }

        if (Objects.nonNull(exchangeDto.getOutputCurrencyCode())) {
            exchangeBuilder.withOutputCurrencyCode(exchangeDto.getOutputCurrencyCode());
        }

        if (exchangeDto.getAskPrice() > 0) {
            exchangeBuilder.withAskPrice(exchangeDto.getAskPrice());
        }

        if (exchangeDto.getBidPrice() > 0) {
            exchangeBuilder.withBidPrice(exchangeDto.getBidPrice());
        }

//        if (Objects.nonNull(exchangeDto.getCreationDate())) {
//            exchangeBuilder.withCreationDate(exchangeDto.getCreationDate());
//        }

        return exchangeBuilder.build();
    }

    public ExchangeDto fromEntityToDto(ExchangeEntity exchangeEntity) {

        if (exchangeEntity == null) {
            return null;
        }

        ExchangeDtoBuilder exchangeDtoBuilder = new ExchangeDtoBuilder();

        if (exchangeEntity.getInputSum() > 0) {
            exchangeDtoBuilder.withInputSum(exchangeEntity.getInputSum());
        }

        if (exchangeEntity.getOutputSum() > 0) {
            exchangeDtoBuilder.withOutputSum(exchangeEntity.getOutputSum());
        }

        if (Objects.nonNull(exchangeEntity.getInputCurrencyCode())) {
            exchangeDtoBuilder.withInputCurrnecyCode(exchangeEntity.getInputCurrencyCode());
        }

        if (Objects.nonNull(exchangeEntity.getOutputCurrencyCode())) {
            exchangeDtoBuilder.withOutputCurrencyCode(exchangeEntity.getOutputCurrencyCode());
        }

        if (exchangeEntity.getAskPrice() > 0) {
            exchangeDtoBuilder.withAskPrice(exchangeEntity.getAskPrice());
        }

        if (exchangeEntity.getBidPrice() > 0) {
            exchangeDtoBuilder.withBidPrice(exchangeEntity.getBidPrice());
        }

//        if (Objects.nonNull(exchangeEntity.getCreationDate())) {
//            exchangeDtoBuilder.withCreationDate(exchangeEntity.getCreationDate());
//        }

        return exchangeDtoBuilder.build();
    }
}

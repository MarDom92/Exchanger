package pl.mardom92.Exchanger.model.mapper;

import org.springframework.stereotype.Component;
import pl.mardom92.Exchanger.model.CurrencyRateEntity;
import pl.mardom92.Exchanger.model.builder.CurrencyRateBuilder;
import pl.mardom92.Exchanger.model.builder.dto.CurrencyRateDtoBuilder;
import pl.mardom92.Exchanger.model.dto.CurrencyRateDto;

import java.util.Objects;

@Component
public class CurrencyRateMapper {

    public CurrencyRateEntity fromDtoToEntity(CurrencyRateDto currencyRateDto) {

        if (currencyRateDto == null) {
            return null;
        }

        CurrencyRateBuilder currencyRateBuilder = new CurrencyRateBuilder();

        if (Objects.nonNull(currencyRateDto.getCurrency())) {
            currencyRateBuilder.withCurrency(currencyRateDto.getCurrency());
        }

        if (Objects.nonNull(currencyRateDto.getCode())) {
            currencyRateBuilder.withCode(currencyRateDto.getCode());
        }

        if (currencyRateDto.getBid() > 0) {
            currencyRateBuilder.withBid(currencyRateDto.getBid());
        }

        if (currencyRateDto.getAsk() > 0) {
            currencyRateBuilder.withAsk(currencyRateDto.getAsk());
        }

        return currencyRateBuilder.build();
    }

    public CurrencyRateDto fromEntityToDto(CurrencyRateEntity currencyRateEntity) {

        if (currencyRateEntity == null) {
            return null;
        }

        CurrencyRateDtoBuilder currencyRateDtoBuilder = new CurrencyRateDtoBuilder();

        if (Objects.nonNull(currencyRateEntity.getCurrency())) {
            currencyRateDtoBuilder.withCurrency(currencyRateEntity.getCurrency());
        }

        if (Objects.nonNull(currencyRateEntity.getCode())) {
            currencyRateDtoBuilder.withCode(currencyRateEntity.getCode());
        }

        if (currencyRateEntity.getBid() > 0) {
            currencyRateDtoBuilder.withBid(currencyRateEntity.getBid());
        }

        if (currencyRateEntity.getAsk() > 0) {
            currencyRateDtoBuilder.withAsk(currencyRateEntity.getAsk());
        }

        return currencyRateDtoBuilder.build();
    }
}

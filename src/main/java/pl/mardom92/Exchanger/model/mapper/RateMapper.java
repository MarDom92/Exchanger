package pl.mardom92.Exchanger.model.mapper;

import org.springframework.stereotype.Component;
import pl.mardom92.Exchanger.model.RateEntity;
import pl.mardom92.Exchanger.model.builder.RateBuilder;
import pl.mardom92.Exchanger.model.builder.dto.RateDtoBuilder;
import pl.mardom92.Exchanger.model.dto.RateDto;

import java.util.Objects;

@Component
public class RateMapper {

    public RateEntity fromDtoToEntity(RateDto rateDto) {

        if (rateDto == null) {
            return null;
        }

        RateBuilder rateBuilder = new RateBuilder();

        if (Objects.nonNull(rateDto.getTableNumber())) {
            rateBuilder.withTableNumber(rateDto.getTableNumber());
        }

        if (Objects.nonNull(rateDto.getEffectiveDate())) {
            rateBuilder.withEffectiveDate(rateDto.getEffectiveDate());
        }

        if (Objects.nonNull(rateDto.getBid())) {
            rateBuilder.withBid(rateDto.getBid());
        }

        if (Objects.nonNull(rateDto.getAsk())) {
            rateBuilder.withAsk(rateDto.getAsk());
        }

        return rateBuilder.build();
    }

    public RateDto fromEntityToDto(RateEntity rateEntity) {

        if (rateEntity == null) {
            return null;
        }

        RateDtoBuilder rateDtoBuilder = new RateDtoBuilder();

        if (Objects.nonNull(rateEntity.getTableNumber())) {
            rateDtoBuilder.withTableNumber(rateEntity.getTableNumber());
        }

        if (Objects.nonNull(rateEntity.getEffectiveDate())) {
            rateDtoBuilder.withEffectiveDate(rateEntity.getEffectiveDate());
        }

        if (Objects.nonNull(rateEntity.getBid())) {
            rateDtoBuilder.withBide(rateEntity.getBid());
        }

        if (Objects.nonNull(rateEntity.getAsk())) {
            rateDtoBuilder.withAsk(rateEntity.getAsk());
        }

        return rateDtoBuilder.build();
    }
}

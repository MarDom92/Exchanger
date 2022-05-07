package pl.mardom92.Exchanger.model.mapper;

import org.springframework.stereotype.Component;
import pl.mardom92.Exchanger.model.RateSingleEntity;
import pl.mardom92.Exchanger.model.builder.RateSingleBuilder;
import pl.mardom92.Exchanger.model.builder.dto.RateSingleDtoBuilder;
import pl.mardom92.Exchanger.model.dto.RateSingleDto;

import java.util.Objects;

@Component
public class RateSingleMapper {

    public RateSingleEntity fromDtoToEntity(RateSingleDto rateSingleDto) {

        if (rateSingleDto == null) {
            return null;
        }

        RateSingleBuilder rateSingleBuilder = new RateSingleBuilder();

        if (Objects.nonNull(rateSingleDto.getTableNumber())) {
            rateSingleBuilder.withTableNumber(rateSingleDto.getTableNumber());
        }

        if (Objects.nonNull(rateSingleDto.getEffectiveDate())) {
            rateSingleBuilder.withEffectiveDate(rateSingleDto.getEffectiveDate());
        }

        if (Objects.nonNull(rateSingleDto.getBid())) {
            rateSingleBuilder.withBid(rateSingleDto.getBid());
        }

        if (Objects.nonNull(rateSingleDto.getAsk())) {
            rateSingleBuilder.withAsk(rateSingleDto.getAsk());
        }

        return rateSingleBuilder.build();
    }

    public RateSingleDto fromEntityToDto(RateSingleEntity rateSingleEntity) {

        if (rateSingleEntity == null) {
            return null;
        }

        RateSingleDtoBuilder rateSingleDtoBuilder = new RateSingleDtoBuilder();

        if (Objects.nonNull(rateSingleEntity.getTableNumber())) {
            rateSingleDtoBuilder.withTableNumber(rateSingleEntity.getTableNumber());
        }

        if (Objects.nonNull(rateSingleEntity.getEffectiveDate())) {
            rateSingleDtoBuilder.withEffectiveDate(rateSingleEntity.getEffectiveDate());
        }

        if (Objects.nonNull(rateSingleEntity.getBid())) {
            rateSingleDtoBuilder.withBide(rateSingleEntity.getBid());
        }

        if (Objects.nonNull(rateSingleEntity.getAsk())) {
            rateSingleDtoBuilder.withAsk(rateSingleEntity.getAsk());
        }

        return rateSingleDtoBuilder.build();
    }
}

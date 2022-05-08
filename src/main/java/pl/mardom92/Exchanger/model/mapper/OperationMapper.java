package pl.mardom92.Exchanger.model.mapper;

import org.springframework.stereotype.Component;
import pl.mardom92.Exchanger.model.entity.OperationEntity;
import pl.mardom92.Exchanger.model.builder.OperationBuilder;
import pl.mardom92.Exchanger.model.builder.dto.OperationDtoBuilder;
import pl.mardom92.Exchanger.model.dto.OperationDto;

import java.util.Objects;

@Component
public class OperationMapper {

    public OperationEntity fromDtoToEntity(OperationDto operationDto) {

        if (operationDto == null) {
            return null;
        }

        OperationBuilder operationBuilder = new OperationBuilder();

        if (Objects.nonNull(operationDto.getOperationStatus())) {
            operationBuilder.withOperationStatus(operationDto.getOperationStatus());
        }

        if (Objects.nonNull(operationDto.getCreationDate())) {
            operationBuilder.withCreationDate(operationDto.getCreationDate());
        }

        return operationBuilder.build();
    }

    public OperationDto fromEntityToDto(OperationEntity operationEntity) {

        if (operationEntity == null) {
            return null;
        }

        OperationDtoBuilder operationDtoBuilder = new OperationDtoBuilder();

        if (Objects.nonNull(operationEntity.getOperationStatus())) {
            operationDtoBuilder.withOperationStatus(operationEntity.getOperationStatus());
        }

        if (Objects.nonNull(operationEntity.getCreationDate())) {
            operationDtoBuilder.withCreationDate(operationEntity.getCreationDate());
        }

        return operationDtoBuilder.build();
    }
}

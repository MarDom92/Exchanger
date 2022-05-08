package pl.mardom92.Exchanger.model.builder.dto;

import pl.mardom92.Exchanger.model.dto.OperationDto;
import pl.mardom92.Exchanger.model.enums.OperationStatus;

import java.util.Date;

public class OperationDtoBuilder {

    OperationStatus operationStatus;
    Date creationDate;

    public OperationDtoBuilder withOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
        return this;
    }

    public OperationDtoBuilder withCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public OperationDto build() {

        OperationDto operationDto = new OperationDto();

        operationDto.setOperationStatus(operationStatus);
        operationDto.setCreationDate(creationDate);

        return operationDto;
    }
}

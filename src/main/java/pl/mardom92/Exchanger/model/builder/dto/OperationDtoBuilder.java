package pl.mardom92.Exchanger.model.builder.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import pl.mardom92.Exchanger.model.dto.OperationDto;
import pl.mardom92.Exchanger.model.enums.OperationStatus;

import java.time.LocalDateTime;

public class OperationDtoBuilder {

    OperationStatus operationStatus;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime creationDate;

    public OperationDtoBuilder withOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
        return this;
    }

    public OperationDtoBuilder withCreationDate(LocalDateTime creationDate) {
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

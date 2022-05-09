package pl.mardom92.Exchanger.model.builder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import pl.mardom92.Exchanger.model.entity.OperationEntity;
import pl.mardom92.Exchanger.model.enums.OperationStatus;

import java.time.LocalDateTime;

public class OperationBuilder {

    private long id;

    OperationStatus operationStatus;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime creationDate;

    public OperationBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public OperationBuilder withOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
        return this;
    }

    public OperationBuilder withCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public OperationEntity build() {

        OperationEntity operationEntity = new OperationEntity();

        operationEntity.setId(id);
        operationEntity.setOperationStatus(operationStatus);
        operationEntity.setCreationDate(creationDate);

        return operationEntity;
    }
}

package pl.mardom92.Exchanger.model.builder;

import pl.mardom92.Exchanger.model.entity.OperationEntity;
import pl.mardom92.Exchanger.model.enums.OperationStatus;

import java.util.Date;

public class OperationBuilder {

    private long id;

    OperationStatus operationStatus;
    Date creationDate;

    public OperationBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public OperationBuilder withOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
        return this;
    }

    public OperationBuilder withCreationDate(Date creationDate) {
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

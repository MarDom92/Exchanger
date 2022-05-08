package pl.mardom92.Exchanger.model.dto;

import lombok.Getter;
import lombok.Setter;
import pl.mardom92.Exchanger.model.enums.OperationStatus;

import java.util.Date;

@Getter
@Setter
public class OperationDto {

    OperationStatus operationStatus;
    Date creationDate;
}

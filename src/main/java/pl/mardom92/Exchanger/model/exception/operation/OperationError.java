package pl.mardom92.Exchanger.model.exception.operation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OperationError {

    OPERATION_NOT_FOUND("Operation does not exist."),
    OPERATION_EMPTY_LIST("List of operations is empty."),
    OPERATION_WRONG_PARAMETER_VALUE("Wrong parameter value."),
    OPERATION_WRONG_PAGE_NUMBER_VALUE("Wrong page number value."),
    OPERATION_SIZE_ON_PAGE_TOO_GREAT("Parameter size on page is to great."),
    OPERATION_SIZE_ON_PAGE_TOO_SMALL("Parameter size on page is to small."),
    OPERATION_WRONG_FIELD_VALUE("Wrong operation field value."),
    OPERATION_WRONG_DATE_FORMAT("Wrong date format.");

    private final String message;
}

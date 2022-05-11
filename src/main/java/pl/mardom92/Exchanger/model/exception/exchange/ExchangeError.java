package pl.mardom92.Exchanger.model.exception.exchange;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExchangeError {

    EXCHANGE_NOT_FOUND("Exchange does not exist."),
    EXCHANGE_EMPTY_LIST("List of exchanges is empty."),
    EXCHANGE_WRONG_PARAMETER_VALUE("Wrong parameter value."),
    EXCHANGE_WRONG_PAGE_NUMBER_VALUE("Wrong page number value."),
    EXCHANGE_SIZE_ON_PAGE_TOO_GREAT("Parameter size on page is to great."),
    EXCHANGE_SIZE_ON_PAGE_TOO_SMALL("Parameter size on page is to small."),
    EXCHANGE_WRONG_FIELD_VALUE("Wrong exchange field value."),
    EXCHANGE_WRONG_DATE_FORMAT("Wrong date format.");

    private final String message;
}

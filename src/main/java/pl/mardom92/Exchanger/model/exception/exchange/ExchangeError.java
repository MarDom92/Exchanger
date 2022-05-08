package pl.mardom92.Exchanger.model.exception.exchange;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExchangeError {

    EXCHANGE_NOT_FOUND("Exchange does not exist."),
    EXCHANGE_EMPTY_LIST("List of exchanges is empty."),
    EXCHANGE_WRONG_FIELD_VALUE("Wrong event field value."),
    EXCHANGE_WRONG_DATE_FORMAT("Wrong date format.");

    private final String message;
}

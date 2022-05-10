package pl.mardom92.Exchanger.model.exception.currency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CurrencyError {

    CURRENCY_EMPTY_LIST("List of currencies is empty.");

    private final String message;
}

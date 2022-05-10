package pl.mardom92.Exchanger.model.exception.currency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CurrencyErrorInfo {

    private final String message;
}

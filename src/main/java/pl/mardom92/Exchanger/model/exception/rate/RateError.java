package pl.mardom92.Exchanger.model.exception.rate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RateError {

    RATE_EMPTY_LIST("List of rates is empty.");

    private final String message;
}

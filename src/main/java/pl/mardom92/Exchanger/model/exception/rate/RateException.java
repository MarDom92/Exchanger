package pl.mardom92.Exchanger.model.exception.rate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RateException extends RuntimeException {

    private final RateError rateError;
}

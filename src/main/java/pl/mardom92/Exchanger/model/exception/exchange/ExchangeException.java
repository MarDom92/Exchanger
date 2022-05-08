package pl.mardom92.Exchanger.model.exception.exchange;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.mardom92.Exchanger.model.exception.response.ResponseError;

@Getter
@RequiredArgsConstructor
public class ExchangeException extends RuntimeException {

    private final ExchangeError exchangeError;
}

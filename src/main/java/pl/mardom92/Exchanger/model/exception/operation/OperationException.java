package pl.mardom92.Exchanger.model.exception.operation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OperationException extends RuntimeException {

    private final OperationError exchangeError;
}

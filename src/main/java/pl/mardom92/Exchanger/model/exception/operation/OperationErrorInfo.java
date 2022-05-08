package pl.mardom92.Exchanger.model.exception.operation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OperationErrorInfo {

    private final String message;
}

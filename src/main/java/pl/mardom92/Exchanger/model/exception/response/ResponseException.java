package pl.mardom92.Exchanger.model.exception.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResponseException extends RuntimeException {

    private final ResponseError responseError;
}

package pl.mardom92.Exchanger.model.exception.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseError {

    RESPONSE_NOT_FOUND("Response does not exist.");

    private final String message;
}

package pl.mardom92.Exchanger.model.exception.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResponseErrorInfo {

    private final String message;
}

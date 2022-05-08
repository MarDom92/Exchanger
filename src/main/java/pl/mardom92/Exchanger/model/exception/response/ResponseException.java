package pl.mardom92.Exchanger.model.exception.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@RequiredArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResponseException extends RuntimeException {

    private final ResponseError responseError;
}

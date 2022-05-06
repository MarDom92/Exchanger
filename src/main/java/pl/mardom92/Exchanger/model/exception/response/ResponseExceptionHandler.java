package pl.mardom92.Exchanger.model.exception.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(value = ResponseException.class)
    public ResponseEntity<ResponseErrorInfo> handlerActivityException(ResponseException activityException) {

        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;

        return ResponseEntity.status(httpStatus).body(new ResponseErrorInfo(activityException.getResponseError().getMessage()));
    }
}

package pl.mardom92.Exchanger.model.exception.rate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RateExceptionHandler {

    @ExceptionHandler(value = RateException.class)
    public ResponseEntity<RateErrorInfo> handlerRateException(RateException exception) {

        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;

        return ResponseEntity.status(httpStatus).body(new RateErrorInfo(exception.getRateError().getMessage()));
    }
}

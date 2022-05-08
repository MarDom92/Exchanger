package pl.mardom92.Exchanger.model.exception.exchange;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExchangeExceptionHandler {

    @ExceptionHandler(value = ExchangeException.class)
    public ResponseEntity<ExchangeErrorInfo> handlerExchangeException(ExchangeException exception) {

        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;

        return ResponseEntity.status(httpStatus).body(new ExchangeErrorInfo(exception.getExchangeError().getMessage()));
    }
}

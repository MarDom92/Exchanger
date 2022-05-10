package pl.mardom92.Exchanger.model.exception.currency;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CurrencyExceptionHandler {

    @ExceptionHandler(value = CurrencyException.class)
    public ResponseEntity<CurrencyErrorInfo> handlerCurrencyException(CurrencyException exception) {

        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;

        return ResponseEntity.status(httpStatus).body(new CurrencyErrorInfo(exception.getCurrencyError().getMessage()));
    }
}

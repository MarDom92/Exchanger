package pl.mardom92.Exchanger.model.exception.operation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OperationExceptionHandler {

    @ExceptionHandler(value = OperationException.class)
    public ResponseEntity<OperationErrorInfo> handlerExchangeException(OperationException exception) {

        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;

        return ResponseEntity.status(httpStatus).body(new OperationErrorInfo(exception.getExchangeError().getMessage()));
    }
}

package pl.mardom92.Exchanger.model.exception.exchange;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ExchangeErrorInfo {

    private final String message;
}

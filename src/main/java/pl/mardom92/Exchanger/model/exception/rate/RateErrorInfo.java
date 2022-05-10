package pl.mardom92.Exchanger.model.exception.rate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RateErrorInfo {

    private final String message;
}

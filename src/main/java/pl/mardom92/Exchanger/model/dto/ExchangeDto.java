package pl.mardom92.Exchanger.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExchangeDto {

    double inputSum;
    double outputSum;
    String inputCurrencyCode;
    String outputCurrencyCode;
    double askPrice;
    double bidPrice;
    LocalDateTime creationDate;
}

package pl.mardom92.Exchanger.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExchangeDto {

    double inputSum;
    double outputSum;
    String inputCurrencyCode;
    String outputCurrencyCode;
    double askPrice;
    double bidPrice;
    Date creationDate;
}

package pl.mardom92.Exchanger.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyRateDto {

    private String currency;
    private String code;
    private double bid;
    private double ask;
}

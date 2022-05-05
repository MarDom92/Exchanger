package pl.mardom92.Exchanger.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateDto {

    public String currency;
    public String code;
    public Double bid;
    public Double ask;
}

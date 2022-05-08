package pl.mardom92.Exchanger.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Currency {

    private String currency;
    private String code;
    private double bid;
    private double ask;
}

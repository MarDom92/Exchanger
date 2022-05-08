package pl.mardom92.Exchanger.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Currency {

    @NonNull
    private String currency;
    @NonNull
    private String code;
    @NonNull
    private double bid;
    @NonNull
    private double ask;
}

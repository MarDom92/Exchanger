package pl.mardom92.Exchanger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateSingle {

    @JsonProperty("no")
    private String tableNumber;
    private String effectiveDate;
    private double bid;
    private double ask;
}

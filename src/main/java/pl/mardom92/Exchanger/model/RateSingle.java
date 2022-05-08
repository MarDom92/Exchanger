package pl.mardom92.Exchanger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class RateSingle {

    @JsonProperty("no")
    @NonNull
    private String tableNumber;
    @NonNull
    private String effectiveDate;
    @NonNull
    private double bid;
    @NonNull
    private double ask;
}

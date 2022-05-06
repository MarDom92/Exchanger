package pl.mardom92.Exchanger.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateDto {

    @JsonProperty("no")
    public String tableNumber;
    public String effectiveDate;
    public Double bid;
    public Double ask;
}

package pl.mardom92.Exchanger.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateSingleDto {

    @JsonProperty("no")
    private String tableNumber;
    private String effectiveDate;
    private Double bid;
    private Double ask;
}

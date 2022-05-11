package pl.mardom92.Exchanger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class NbpArrayResponse {

    private String table;
    private String no;
    private String tradingDate;
    private String effectiveDate;
    @JsonProperty("rates")
    private List<Currency> currencies;
}

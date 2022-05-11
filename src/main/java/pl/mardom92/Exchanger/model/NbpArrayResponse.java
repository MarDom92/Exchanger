package pl.mardom92.Exchanger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class NbpArrayResponse {

    @NonNull
    private String table;
    @NonNull
    private String no;
    @NonNull
    private String tradingDate;
    @NonNull
    private String effectiveDate;
    @JsonProperty("rates")
    @NonNull
    private List<Currency> currencies;
}

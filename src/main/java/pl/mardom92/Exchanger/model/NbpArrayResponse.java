package pl.mardom92.Exchanger.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NbpArrayResponse {

    @NonNull
    private String table;
    @NonNull
    private String no;
    @NonNull
    private String tradingDate;
    @NonNull
    private String effectiveDate;
    @NonNull
    private List<Currency> rates;
}

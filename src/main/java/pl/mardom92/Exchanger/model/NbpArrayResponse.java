package pl.mardom92.Exchanger.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NbpArrayResponse {

    private String table;
    private String no;
    private String tradingDate;
    private String effectiveDate;
    private List<Currency> rates;
}

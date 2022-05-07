package pl.mardom92.Exchanger.model;

import lombok.Getter;
import lombok.Setter;
import pl.mardom92.Exchanger.model.dto.CurrencyRateDto;

import java.util.List;

@Getter
@Setter
public class ResponseArray {

    private String table;
    private String no;
    private String tradingDate;
    private String effectiveDate;
    private List<CurrencyRateDto> rates;
}

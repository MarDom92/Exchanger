package pl.mardom92.Exchanger.model;

import lombok.Getter;
import lombok.Setter;
import pl.mardom92.Exchanger.model.dto.RateArrayDto;

import java.util.List;

@Getter
@Setter
public class ResponseArray {

    public String table;
    public String no;
    public String tradingDate;
    public String effectiveDate;
    public List<RateArrayDto> rates;
}

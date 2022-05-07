package pl.mardom92.Exchanger.model;

import lombok.Getter;
import lombok.Setter;
import pl.mardom92.Exchanger.model.dto.RateSingleDto;

import java.util.List;

@Getter
@Setter
public class ResponseSingle {

    private String table;
    private String currency;
    private String code;
    private List<RateSingleDto> rates;
}

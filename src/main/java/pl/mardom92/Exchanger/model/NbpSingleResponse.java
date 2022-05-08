package pl.mardom92.Exchanger.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NbpSingleResponse {

    private String table;
    private String currency;
    private String code;
    private List<RateSingle> rates;
}

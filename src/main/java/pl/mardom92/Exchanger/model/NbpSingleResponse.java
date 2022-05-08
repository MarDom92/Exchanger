package pl.mardom92.Exchanger.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NbpSingleResponse {

    @NonNull
    private String table;
    @NonNull
    private String currency;
    @NonNull
    private String code;
    @NonNull
    private List<RateSingle> rates;
}

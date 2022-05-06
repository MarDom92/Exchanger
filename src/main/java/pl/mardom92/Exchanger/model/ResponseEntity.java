package pl.mardom92.Exchanger.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

public class ResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String table;
    public String currency;
    public String code;
    public List<RateEntity> rates;
}

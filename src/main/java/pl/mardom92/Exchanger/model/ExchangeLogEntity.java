package pl.mardom92.Exchanger.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class ExchangeLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    double inputSum;
    double outputSum;
    String inputCurrencyCode;
    String outputCurrencyCode;
    double askPrice;
    double bidPrice;
    LocalDateTime creationDate;
}

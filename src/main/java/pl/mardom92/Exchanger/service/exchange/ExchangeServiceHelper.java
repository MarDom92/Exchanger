package pl.mardom92.Exchanger.service.exchange;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mardom92.Exchanger.model.ExchangeEntity;
import pl.mardom92.Exchanger.model.dto.ExchangeDto;
import pl.mardom92.Exchanger.model.exception.exchange.ExchangeError;
import pl.mardom92.Exchanger.model.exception.exchange.ExchangeException;
import pl.mardom92.Exchanger.repository.ExchangeRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExchangeServiceHelper {

    private final ExchangeRepository exchangeRepository;

    protected void checkEmptyList(List<ExchangeEntity> logs) {

        if (logs.isEmpty()) {
            throw new RuntimeException("List of logs is empty.");
        }
    }

    protected ExchangeEntity checkExchangeExist(long id) {

        return exchangeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log with this id does not exist."));
    }

    public void checkExchangeDtoValues(ExchangeDto exchangeDto) {


        if (exchangeDto.getInputSum() <= 0) {
            throw new ExchangeException(ExchangeError.EXCHANGE_WRONG_FIELD_VALUE);
        }

        if (exchangeDto.getOutputSum() <= 0) {
            throw new ExchangeException(ExchangeError.EXCHANGE_WRONG_FIELD_VALUE);
        }

        if (exchangeDto.getInputCurrencyCode().trim().equals("")) {
            throw new ExchangeException(ExchangeError.EXCHANGE_WRONG_FIELD_VALUE);
        }

        if (exchangeDto.getOutputCurrencyCode().trim().equals("")) {
            throw new ExchangeException(ExchangeError.EXCHANGE_WRONG_FIELD_VALUE);
        }

        if (exchangeDto.getAskPrice() <= 0) {
            throw new ExchangeException(ExchangeError.EXCHANGE_WRONG_FIELD_VALUE);
        }

        if (exchangeDto.getBidPrice() <= 0) {
            throw new ExchangeException(ExchangeError.EXCHANGE_WRONG_FIELD_VALUE);
        }

        SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        try {
            format.parse(exchangeDto.getCreationDate().toString());
        } catch (ParseException e) {
            new ExchangeException(ExchangeError.EXCHANGE_WRONG_DATE_FORMAT);
        }
    }
}

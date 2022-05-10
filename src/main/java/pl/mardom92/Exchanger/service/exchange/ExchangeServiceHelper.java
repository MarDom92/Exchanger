package pl.mardom92.Exchanger.service.exchange;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mardom92.Exchanger.model.dto.ExchangeDto;
import pl.mardom92.Exchanger.model.entity.ExchangeEntity;
import pl.mardom92.Exchanger.model.exception.exchange.ExchangeError;
import pl.mardom92.Exchanger.model.exception.exchange.ExchangeException;
import pl.mardom92.Exchanger.repository.ExchangeRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExchangeServiceHelper {

    private final ExchangeRepository exchangeRepository;

    protected int checkSizeOfList(List<ExchangeEntity> exchanges) {

        if (exchanges.isEmpty()) {
            throw new ExchangeException(ExchangeError.EXCHANGE_EMPTY_LIST);
        } else {
            return exchanges.size();
        }
    }

    protected int checkPageNumber(int pageNumber) {

        if (pageNumber < 1) {
            throw new ExchangeException(ExchangeError.EXCHANGE_WRONG_PARAMETER_VALUE);
        }

        return pageNumber;
    }

    protected int checkSizeOnPage(int sizeOnPage, int maxSize) {

        if (sizeOnPage > maxSize) {
            throw new ExchangeException(ExchangeError.EXCHANGE_WRONG_PARAMETER_VALUE);
        } else if (sizeOnPage <= 0) {
            throw new ExchangeException(ExchangeError.EXCHANGE_WRONG_PARAMETER_VALUE);
        } else {
            return sizeOnPage;
        }
    }

    protected ExchangeEntity checkExchangeExist(long id) {

        return exchangeRepository.findById(id)
                .orElseThrow(() -> new ExchangeException(ExchangeError.EXCHANGE_NOT_FOUND));
    }

    protected double checkSum(double sum) {

        if (sum <= 0) {
            throw new ExchangeException(ExchangeError.EXCHANGE_WRONG_FIELD_VALUE);
        }

        return sum;
    }

    protected String checkCurrencyCode(String code) {

        if (code == null) {
            throw new ExchangeException(ExchangeError.EXCHANGE_WRONG_FIELD_VALUE);
        }

        return code.toUpperCase();
    }

    protected String checkCurrencyCodeIsOnList(String code, List<String> currencies) {

        Optional<String> result = currencies.stream()
                .filter(c -> c.equals(code)).findFirst();

        if (result.isEmpty()) {
            throw new ExchangeException(ExchangeError.EXCHANGE_WRONG_PARAMETER_VALUE);
        }

        return result.get();
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

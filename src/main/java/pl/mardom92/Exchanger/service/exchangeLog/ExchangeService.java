package pl.mardom92.Exchanger.service.exchangeLog;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.mardom92.Exchanger.model.ExchangeEntity;
import pl.mardom92.Exchanger.model.builder.ExchangeBuilder;
import pl.mardom92.Exchanger.model.dto.RateSingleDto;
import pl.mardom92.Exchanger.repository.ExchangeRepository;
import pl.mardom92.Exchanger.service.ResponseService;

import java.util.Date;
import java.util.List;

import static pl.mardom92.Exchanger.Constants.ResponseSingleURL;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final ExchangeServiceHelper exchangeServiceHelper;
    private final ResponseService responseService;

    public List<ExchangeEntity> getAllExchanges(int page, int size) {

        if (size <= 0) {
            size = exchangeRepository.findAll().size();
        }

        if (page < 1) {
            page = 1;
        }

        List<ExchangeEntity> exchanges = exchangeRepository.findAll(PageRequest.of(page - 1, size)).toList();

        exchangeServiceHelper.checkEmptyList(exchanges);

        return exchanges;
    }

    public ExchangeEntity getSingleExchange(long id) {

        ExchangeEntity exchange = exchangeServiceHelper.checkExchange(id);

        return exchange;
    }

    public ExchangeEntity addExchange(ExchangeEntity exchangeEntity) {

        //exchangeServiceHelper.checkLogsValues(exchangeDto);

        exchangeRepository.save(exchangeEntity);

        return exchangeEntity;
    }

    public ExchangeEntity exchangeCurrency(double sum, String in, String out) {

        String url = ResponseSingleURL;

        RateSingleDto inputCurrency = responseService.getResponseSingle(url + in).getRates().get(0);
        RateSingleDto outputCurrency = responseService.getResponseSingle(url + out).getRates().get(0);

        double result = exchange(sum, inputCurrency, outputCurrency);

        //2 decimal places
        result = Math.round(result * 100.0) / 100.0;

        ExchangeEntity exchange = new ExchangeBuilder()
                .withInputSum(100.0D)
                .withOutputSum(result)
                .withInputCurrnecyCode(in)
                .withOutputCurrencyCode(out)
                .withAskPrice(inputCurrency.getAsk())
                .withBidPrice(outputCurrency.getBid())
                //FIXME: LocalDateTime and Jackson serialization problem (jackson-datatype-jsr310 and ObjectMapper with register module)
                .withCreationDate(new Date())
                .build();

        addExchange(exchange);

        return exchange;
    }

    private double exchange(double sum, RateSingleDto in, RateSingleDto out) {

        double sumInPLN, result;

        sumInPLN = sum / in.getAsk();
        result = sumInPLN * out.getBid();

        return result;
    }
}

package pl.mardom92.Exchanger.service.exchange;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.mardom92.Exchanger.model.RateSingle;
import pl.mardom92.Exchanger.model.builder.dto.ExchangeDtoBuilder;
import pl.mardom92.Exchanger.model.dto.ExchangeDto;
import pl.mardom92.Exchanger.model.entity.ExchangeEntity;
import pl.mardom92.Exchanger.model.enums.OperationStatus;
import pl.mardom92.Exchanger.model.mapper.ExchangeMapper;
import pl.mardom92.Exchanger.repository.ExchangeRepository;
import pl.mardom92.Exchanger.service.currency.CurrencyService;
import pl.mardom92.Exchanger.service.nbpResponseService.NbpResponseService;
import pl.mardom92.Exchanger.service.operation.OperationService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static pl.mardom92.Exchanger.Constants.NBP_URL_SINGLE_RESPONSE;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final ExchangeServiceHelper exchangeServiceHelper;
    private final ExchangeMapper exchangeMapper;
    private final NbpResponseService nbpResponseService;
    private final OperationService operationService;
    private final CurrencyService currencyService;

    public List<ExchangeDto> getAllExchanges(int pageNumber, int sizeOnPage) {

        List<ExchangeEntity> exchanges = exchangeRepository.findAll();

        int sizeOfList = exchangeServiceHelper.checkSizeOfList(exchanges);

        pageNumber = exchangeServiceHelper.checkPageNumber(pageNumber);

        sizeOnPage = exchangeServiceHelper.checkSizeOnPage(sizeOnPage, sizeOfList);

        exchanges = exchangeRepository.findAll(PageRequest.of(pageNumber - 1, sizeOnPage)).toList();

        return exchanges.stream().map(exchangeMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public ExchangeDto getSingleExchange(long id) {

        ExchangeEntity exchange = exchangeServiceHelper.checkExchangeExist(id);

        return exchangeMapper.fromEntityToDto(exchange);
    }

    public void addExchange(ExchangeDto exchangeDto) {

        exchangeServiceHelper.checkExchangeDtoValues(exchangeDto);

        ExchangeEntity exchangeEntity = exchangeMapper.fromDtoToEntity(exchangeDto);

        exchangeRepository.save(exchangeEntity);
    }

    public ExchangeDto exchangeCurrency(double sum, String in, String out) {

        sum = exchangeServiceHelper.checkSum(sum);
        in = exchangeServiceHelper.checkCurrencyCode(in);
        out = exchangeServiceHelper.checkCurrencyCode(out);

        String url = NBP_URL_SINGLE_RESPONSE;

        List<String> currencies = currencyService.getAllCurrenciesCodes();

        in = exchangeServiceHelper.checkCurrencyCodeIsOnList(in, currencies);
        out = exchangeServiceHelper.checkCurrencyCodeIsOnList(out, currencies);

        RateSingle inputCurrency = nbpResponseService.getResponseSingle(url + in).getRates().get(0);
        RateSingle outputCurrency = nbpResponseService.getResponseSingle(url + out).getRates().get(0);

        double result = exchange(sum, inputCurrency, outputCurrency);

        //2 decimal places
        result = Math.round(result * 100.0) / 100.0;

        ExchangeDto exchangeDto = new ExchangeDtoBuilder()
                .withInputSum(sum)
                .withOutputSum(result)
                .withInputCurrnecyCode(in)
                .withOutputCurrencyCode(out)
                .withAskPrice(inputCurrency.getAsk())
                .withBidPrice(outputCurrency.getBid())
                .withCreationDate(LocalDateTime.now())
                .build();

        addExchange(exchangeDto);

        operationService.addOperation(OperationStatus.EXCHANGE_CURRENCY);

        return exchangeDto;
    }

    private double exchange(double sum, RateSingle in, RateSingle out) {

        double sumInPLN, result;

        sumInPLN = sum / in.getAsk();
        result = sumInPLN * out.getBid();

        return result;
    }
}

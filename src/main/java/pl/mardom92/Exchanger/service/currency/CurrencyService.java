package pl.mardom92.Exchanger.service.currency;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mardom92.Exchanger.model.Currency;
import pl.mardom92.Exchanger.model.NbpArrayResponse;
import pl.mardom92.Exchanger.model.enums.OperationStatus;
import pl.mardom92.Exchanger.service.nbpResponseService.NbpResponseService;
import pl.mardom92.Exchanger.service.operation.OperationService;

import java.util.ArrayList;
import java.util.List;

import static pl.mardom92.Exchanger.model.constant.NbpUrlConstants.NBP_URL_ARRAY_RESPONSE;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final NbpResponseService nbpResponseService;
    private final OperationService operationService;
    private final CurrencyServiceHelper currencyServiceHelper;

    public List<String> getAllCurrenciesCodesAndAddOperation() {

        List<String> codes = getAllCurrenciesCodes();

        operationService.addOperation(OperationStatus.GET_CURRENCIES);

        return codes;
    }

    public List<Currency> getAllCurrenciesAndAddOperation() {

        List<Currency> currencies = getAllCurrencies();

        operationService.addOperation(OperationStatus.GET_RATES);

        return currencies;
    }

    public List<String> getAllCurrenciesCodes() {

        List<String> codes = new ArrayList<>();
        List<Currency> currencies = getAllCurrencies();

        int size = currencyServiceHelper.checkSizeOfListCurrency(currencies);

        for (int i = 0; i < size; i++) {
            codes.add(currencies.get(i).getCode());
        }

        operationService.addOperation(OperationStatus.GET_CURRENCIES);

        return codes;
    }

    public List<Currency> getAllCurrencies() {

        String url = NBP_URL_ARRAY_RESPONSE;
        List<Currency> currencies = new ArrayList<>();

        NbpArrayResponse[] responses = nbpResponseService.getResponseArray(url);

        int length = currencyServiceHelper.checkLengthOfNbpArrayResponse(responses);

        for (int i = 0; i < length; i++) {
            currencies.addAll(responses[i].getCurrencies());
        }

        return currencies;
    }
}

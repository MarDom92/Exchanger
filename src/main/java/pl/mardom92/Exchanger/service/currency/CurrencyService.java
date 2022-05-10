package pl.mardom92.Exchanger.service.currency;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mardom92.Exchanger.model.Currency;
import pl.mardom92.Exchanger.model.NbpArrayResponse;
import pl.mardom92.Exchanger.model.enums.OperationStatus;
import pl.mardom92.Exchanger.service.NbpResponseService;
import pl.mardom92.Exchanger.service.operation.OperationService;

import java.util.ArrayList;
import java.util.List;

import static pl.mardom92.Exchanger.Constants.NBP_URL_ARRAY_RESPONSE;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final NbpResponseService nbpResponseService;
    private final OperationService operationService;
    private final CurrencyServiceHelper currencyServiceHelper;

    public List<String> getAllCurrenciesCodes() {

        String url = NBP_URL_ARRAY_RESPONSE;
        List<String> codes = new ArrayList<>();
        List<Currency> rates = new ArrayList<>();

        NbpArrayResponse[] nbpArrayResponse = nbpResponseService.getResponseArray(url);

        int length = currencyServiceHelper.checkLengthOfArray(nbpArrayResponse);

        for (int i = 0; i < length; i++) {

            rates = nbpArrayResponse[i].getRates();

            for (int j = 0; j < rates.size(); j++) {

                codes.add(rates.get(j).getCode());
            }
        }

        operationService.addOperation(OperationStatus.GET_CURRENCIES);

        return codes;
    }
}

package pl.mardom92.Exchanger.service.rate;

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
public class RateService {

    private final NbpResponseService nbpResponseService;
    private final OperationService operationService;
    private final RateServiceHelper rateServiceHelper;

    public List<Currency> getAllRates() {

        String url = NBP_URL_ARRAY_RESPONSE;
        List<Currency> rates = new ArrayList<>();

        NbpArrayResponse[] responses = nbpResponseService.getResponseArray(url);

        int length = rateServiceHelper.checkLengthOfArray(responses);

        for (int i = 0; i < length; i++) {
            rates.addAll(responses[i].getRates());
        }

        operationService.addOperation(OperationStatus.GET_RATES);

        return rates;
    }
}

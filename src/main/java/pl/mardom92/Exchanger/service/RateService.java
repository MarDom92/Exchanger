package pl.mardom92.Exchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mardom92.Exchanger.model.Currency;
import pl.mardom92.Exchanger.model.NbpArrayResponse;
import pl.mardom92.Exchanger.model.enums.OperationStatus;
import pl.mardom92.Exchanger.service.operation.OperationService;

import java.util.ArrayList;
import java.util.List;

import static pl.mardom92.Exchanger.Constants.NBP_URL_ARRAY_RESPONSE;

@Service
@RequiredArgsConstructor
public class RateService {

    private final NbpResponseService nbpResponseService;
    private final OperationService operationService;

    public List<Currency> getAllRates() {

        NbpArrayResponse[] responses;
        List<Currency> rates = new ArrayList<>();
        String url = NBP_URL_ARRAY_RESPONSE;

        responses = nbpResponseService.getResponseArray(url);

        int size = responses.length;

        for (int i = 0; i < size; i++) {
            rates.addAll(responses[i].getRates());
        }

        operationService.addOperation(OperationStatus.GET_RATES);

        return rates;
    }
}

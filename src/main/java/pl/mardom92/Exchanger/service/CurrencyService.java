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
public class CurrencyService {

    private final NbpResponseService nbpResponseService;
    private final OperationService operationService;

    public List<String> getAllCurrenciesCodes() {

        String url = NBP_URL_ARRAY_RESPONSE;
        List<String> codes = new ArrayList<>();
        List<Currency> rates = new ArrayList<>();

        NbpArrayResponse[] nbpArrayResponse = nbpResponseService.getResponseArray(url);

        int size = nbpArrayResponse.length;

        for (int i = 0; i < size; i++) {

            rates = nbpArrayResponse[i].getRates();

            for (int j = 0; j < rates.size(); j++) {

                codes.add(rates.get(j).getCode());
            }
        }

        operationService.addOperation(OperationStatus.GET_CURRENCIES);

        return codes;
    }
}
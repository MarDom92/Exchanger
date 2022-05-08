package pl.mardom92.Exchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mardom92.Exchanger.model.ResponseArray;
import pl.mardom92.Exchanger.model.dto.CurrencyRateDto;

import java.util.ArrayList;
import java.util.List;

import static pl.mardom92.Exchanger.Constants.ResponseTableURL;

@Service
@RequiredArgsConstructor
public class RateService {

    private final ResponseService responseService;

    public List<CurrencyRateDto> getAllRates() {

        ResponseArray[] responseArray;
        List<CurrencyRateDto> rates = new ArrayList<>();
        String url = ResponseTableURL;

        responseArray = responseService.getResponseArray(url);

        int size = responseArray.length;

        for (int i = 0; i < size; i++) {
            rates.addAll(responseArray[i].getRates());
        }

        return rates;
    }

    public List<String> getAllCurrenciesCodes() {

        String url = ResponseTableURL;
        List<String> codes = new ArrayList<>();
        List<CurrencyRateDto> rates = new ArrayList<>();

        ResponseArray[] responseArray = responseService.getResponseArray(url);

        int size = responseArray.length;

        for (int i = 0; i < size; i++) {

            rates = responseArray[i].getRates();

            for (int j = 0; j < rates.size(); j++) {

                codes.add(rates.get(j).getCode());
            }
        }

        return codes;
    }
}

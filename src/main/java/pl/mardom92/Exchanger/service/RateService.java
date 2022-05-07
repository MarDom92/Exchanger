package pl.mardom92.Exchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mardom92.Exchanger.model.ResponseArray;
import pl.mardom92.Exchanger.model.dto.RateArrayDto;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RateService {

    private final ResponseService responseService;

    public List<RateArrayDto> getAllRates() {

        ResponseArray[] responseArray;
        List<RateArrayDto> rates = new ArrayList<>();
        String url = "http://api.nbp.pl/api/exchangerates/tables/c/";

        responseArray = responseService.getResponseArray(url);

        int size = responseArray.length;

        for (int i = 0; i < size; i++) {
            rates.addAll(responseArray[i].getRates());
        }

        return rates;
    }
}

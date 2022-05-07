package pl.mardom92.Exchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mardom92.Exchanger.model.ResponseArray;
import pl.mardom92.Exchanger.model.dto.RateArrayDto;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final ResponseService responseService;

    public List<String> getAllCodes() {

        String url = "http://api.nbp.pl/api/exchangerates/tables/c/";
        List<String> codes = new ArrayList<>();
        List<RateArrayDto> rates = new ArrayList<>();

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

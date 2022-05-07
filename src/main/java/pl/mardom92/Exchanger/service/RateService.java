package pl.mardom92.Exchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mardom92.Exchanger.model.ResponseArray;
import pl.mardom92.Exchanger.model.dto.RateArrayDto;
import pl.mardom92.Exchanger.model.dto.RateSingleDto;

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

    public List<String> getAllCurrenciesCodes() {

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

    public double exchangeCurrency(double sum, String in, String out) {

        String url = "http://api.nbp.pl/api/exchangerates/rates/c/";

        RateSingleDto inputCurrency = responseService.getResponseSingle(url + in).getRates().get(0);
        RateSingleDto outputCurrency = responseService.getResponseSingle(url + out).getRates().get(0);

        double result = exchange(sum, inputCurrency, outputCurrency);

        //2 decimal places
        result = Math.round(result * 100.0) / 100.0;

        return result;
    }

    private double exchange(double sum, RateSingleDto in, RateSingleDto out) {

        double sumInPLN, result;

        sumInPLN = sum / in.getAsk();
        result = sumInPLN * out.getBid();

        return result;
    }
}

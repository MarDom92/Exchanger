package pl.mardom92.Exchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mardom92.Exchanger.model.RateEntity;
import pl.mardom92.Exchanger.model.ResponseEntity;
import pl.mardom92.Exchanger.model.dto.RateDto;
import pl.mardom92.Exchanger.model.mapper.RateMapper;
import pl.mardom92.Exchanger.repository.RateRepository;

@Service
@RequiredArgsConstructor
public class RateService {

    private final RestTemplate restTemplate;
    private final RateMapper rateMapper;
    private final RateRepository rateRepository;

    public RateEntity getRate(String current) {

//        String url = "http://api.nbp.pl/api/exchangerates/rates/c/" + current + "/today/?format=json";
        String url = "http://api.nbp.pl/api/exchangerates/rates/c/usd/today/?format=json";

        RateEntity response = restTemplate.getForObject(url, RateEntity.class);

        return response;
    }
}

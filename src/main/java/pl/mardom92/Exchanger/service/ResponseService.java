package pl.mardom92.Exchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mardom92.Exchanger.model.ResponseEntity;

@Service
@RequiredArgsConstructor
public class ResponseService {

    private final RestTemplate restTemplate;

    public ResponseEntity getResponse(String current) {

        String url = "http://api.nbp.pl/api/exchangerates/rates/c/" + current + "/today/?format=json";

        ResponseEntity response = restTemplate.getForObject(url, ResponseEntity.class);

        return response;
    }
}

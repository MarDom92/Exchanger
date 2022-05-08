package pl.mardom92.Exchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mardom92.Exchanger.model.NbpArrayResponse;
import pl.mardom92.Exchanger.model.NbpSingleResponse;

@Service
@RequiredArgsConstructor
public class NbpResponseService {

    private final RestTemplate restTemplate;

    public NbpSingleResponse getResponseSingle(String url) {

        //TODO: błędny kod waluty daje 404, poinien być najprawdopodobniej wyjątek
        NbpSingleResponse nbpSingleResponse = restTemplate.getForObject(url, NbpSingleResponse.class);

        return nbpSingleResponse;
    }

    public NbpArrayResponse[] getResponseArray(String url) {

        //TODO: błędny kod waluty daje 404, poinien być najprawdopodobniej wyjątek
        NbpArrayResponse[] nbpArrayResponse = restTemplate.getForObject(url, NbpArrayResponse[].class);

        return nbpArrayResponse;
    }
}

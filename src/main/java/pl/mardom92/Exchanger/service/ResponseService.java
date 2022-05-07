package pl.mardom92.Exchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mardom92.Exchanger.model.ResponseArray;
import pl.mardom92.Exchanger.model.ResponseSingle;

@Service
@RequiredArgsConstructor
public class ResponseService {

    private final RestTemplate restTemplate;

    public ResponseSingle getResponseSingle(String url) {

        //TODO: błędny kod waluty daje 404, poinien być najprawdopodobniej wyjątek
        ResponseSingle responseSingle = restTemplate.getForObject(url, ResponseSingle.class);

        return responseSingle;
    }

    public ResponseArray[] getResponseArray(String url) {

        //TODO: błędny kod waluty daje 404, poinien być najprawdopodobniej wyjątek
        ResponseArray[] responseArray = restTemplate.getForObject(url, ResponseArray[].class);

        return responseArray;
    }
}

package pl.mardom92.Exchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.mardom92.Exchanger.model.NbpArrayResponse;
import pl.mardom92.Exchanger.model.NbpSingleResponse;
import pl.mardom92.Exchanger.model.exception.operation.OperationException;
import pl.mardom92.Exchanger.model.exception.response.ResponseError;
import pl.mardom92.Exchanger.model.exception.response.ResponseException;

@Service
@RequiredArgsConstructor
public class NbpResponseService {

    private final RestTemplate restTemplate;

    public NbpSingleResponse getResponseSingle(String url) {

        NbpSingleResponse nbpSingleResponse = restTemplate.getForObject(url, NbpSingleResponse.class);

        return nbpSingleResponse;
    }

    public NbpArrayResponse[] getResponseArray(String url) {

        NbpArrayResponse[] nbpArrayResponse = restTemplate.getForObject(url, NbpArrayResponse[].class);

        return nbpArrayResponse;
    }
}

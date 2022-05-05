package pl.mardom92.Exchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mardom92.Exchanger.repository.RateRepository;

@Service
@RequiredArgsConstructor
public class RateService {

    private final RestTemplate restTemplate;
    private final RateRepository rateRepository;

}

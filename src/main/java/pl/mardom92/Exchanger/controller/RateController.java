package pl.mardom92.Exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.mardom92.Exchanger.service.RateService;

@RestController
@RequiredArgsConstructor
public class RateController {

    private final RateService rateService;
}

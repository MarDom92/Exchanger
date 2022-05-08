package pl.mardom92.Exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mardom92.Exchanger.model.Currency;
import pl.mardom92.Exchanger.service.RateService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "")
public class RateController {

    private final RateService rateService;

    @GetMapping("/rates")
    public List<Currency> getAllRates() {

        return rateService.getAllRates();
    }
}

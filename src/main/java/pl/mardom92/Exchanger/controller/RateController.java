package pl.mardom92.Exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mardom92.Exchanger.model.dto.RateArrayDto;
import pl.mardom92.Exchanger.service.RateService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "")
public class RateController {

    private final RateService rateService;

    @GetMapping("/rates")
    public List<RateArrayDto> getAllRates() {
        return rateService.getAllRates();
    }

    @GetMapping("/currencies")
    public List<String> getAllCurrencies() {
        return rateService.getAllCurrenciesCodes();
    }

    @GetMapping("/exchange")
    public double exchangeCurrency(
            @RequestParam(name = "sum", required = true) double sum,
            @RequestParam(name = "in", required = true) String in,
            @RequestParam(name = "out", required = true) String out) {

        return rateService.exchangeCurrency(sum, in, out);
    }
}

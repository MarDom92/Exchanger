package pl.mardom92.Exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mardom92.Exchanger.model.Currency;
import pl.mardom92.Exchanger.service.currency.CurrencyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/codes")
    public List<String> getAllCurrenciesCodesAndAddOperation() {

        return currencyService.getAllCurrenciesCodesAndAddOperation();
    }

    @GetMapping("")
    public List<Currency> getCurrenciesAndAddOperation() {

        return currencyService.getAllCurrenciesAndAddOperation();
    }
}

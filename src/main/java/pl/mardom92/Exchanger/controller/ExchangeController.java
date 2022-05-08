package pl.mardom92.Exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mardom92.Exchanger.model.ExchangeEntity;
import pl.mardom92.Exchanger.service.exchangeLog.ExchangeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/exchanges")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("")
    public List<ExchangeEntity> getAllExchange(@RequestParam(required = false, defaultValue = "0") int page,
                                               @RequestParam(required = false, defaultValue = "0") int size) {
        return exchangeService.getAllExchanges(page, size);
    }

    @GetMapping("/{id}")
    public ExchangeEntity getSingleExchange(@PathVariable long id) {
        return exchangeService.getSingleExchange(id);
    }

    @GetMapping("/exchange")
    public ExchangeEntity exchangeCurrency(
            @RequestParam(name = "sum", required = true) double sum,
            @RequestParam(name = "in", required = true) String in,
            @RequestParam(name = "out", required = true) String out) {

        return exchangeService.exchangeCurrency(sum, in, out);
    }
}

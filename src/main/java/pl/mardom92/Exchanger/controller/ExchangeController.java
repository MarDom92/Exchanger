package pl.mardom92.Exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mardom92.Exchanger.model.dto.ExchangeDto;
import pl.mardom92.Exchanger.service.exchange.ExchangeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/exchanges")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("")
    public List<ExchangeDto> getAllExchanges(@RequestParam(required = false, defaultValue = "1", name = "page") int pageNumber,
                                             @RequestParam(required = false, defaultValue = "0", name = "size") int sizeOnPage) {

        return exchangeService.getAllExchanges(pageNumber, sizeOnPage);
    }

    @GetMapping("/{id}")
    public ExchangeDto getSingleExchange(@PathVariable long id) {

        return exchangeService.getSingleExchange(id);
    }

    @GetMapping("/exchange")
    public ExchangeDto exchangeCurrency(
            @RequestParam(name = "sum", required = false, defaultValue = "0.0") double sum,
            @RequestParam(name = "in", required = false, defaultValue = "") String in,
            @RequestParam(name = "out", required = false, defaultValue = "") String out) {

        return exchangeService.exchangeCurrency(sum, in, out);
    }
}

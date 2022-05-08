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
    public List<ExchangeEntity> getAllEvents(@RequestParam(required = false, defaultValue = "0") int page,
                                             @RequestParam(required = false, defaultValue = "1") int size) throws Exception {
        return exchangeService.getAllLogs(page, size);
    }

    @GetMapping("/{id}")
    public ExchangeEntity getSingleEvents(@PathVariable long id) {
        return exchangeService.getSingleLog(id);
    }
}

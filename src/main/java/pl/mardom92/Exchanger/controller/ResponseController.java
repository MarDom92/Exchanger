package pl.mardom92.Exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mardom92.Exchanger.model.RateEntity;
import pl.mardom92.Exchanger.model.ResponseEntity;
import pl.mardom92.Exchanger.model.dto.RateDto;
import pl.mardom92.Exchanger.service.RateService;

@RestController
@RequiredArgsConstructor
public class RateController {

    private final RateService rateService;

    @GetMapping("/exchange")
    public RateEntity getActivityFromApi(@RequestParam(name = "in") String current) {
        return rateService.getRate(current);
    }
}

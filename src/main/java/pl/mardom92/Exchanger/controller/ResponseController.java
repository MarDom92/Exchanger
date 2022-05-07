package pl.mardom92.Exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mardom92.Exchanger.model.ResponseSingle;
import pl.mardom92.Exchanger.model.ResponseArray;
import pl.mardom92.Exchanger.service.ResponseService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "")
public class ResponseController {

    private final ResponseService responseService;

    @GetMapping("/response")
    public ResponseSingle getResponseSingle(@RequestParam(name = "code", required = true) String current) {

        String url = "http://api.nbp.pl/api/exchangerates/rates/c/" + current;

        return responseService.getResponseSingle(url);
    }

    @GetMapping("/response-array")
    public ResponseArray[] getResponseTable() {

        String url = "http://api.nbp.pl/api/exchangerates/tables/c/";

        return responseService.getResponseArray(url);
    }
}

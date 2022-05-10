package pl.mardom92.Exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mardom92.Exchanger.model.NbpSingleResponse;
import pl.mardom92.Exchanger.model.NbpArrayResponse;
import pl.mardom92.Exchanger.service.NbpResponseService;

import static pl.mardom92.Exchanger.Constants.NBP_URL_SINGLE_RESPONSE;
import static pl.mardom92.Exchanger.Constants.NBP_URL_ARRAY_RESPONSE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "")
public class NbpResponseController {

    private final NbpResponseService nbpResponseService;

    @GetMapping("/api/response")
    public NbpSingleResponse getResponseSingle(@RequestParam(name = "code", required = true) String current) {

        return nbpResponseService.getResponseSingle(NBP_URL_SINGLE_RESPONSE + current);
    }

    @GetMapping("/response-array")
    public NbpArrayResponse[] getResponseTable() {

        return nbpResponseService.getResponseArray(NBP_URL_ARRAY_RESPONSE);
    }
}

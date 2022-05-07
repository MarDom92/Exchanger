package pl.mardom92.Exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mardom92.Exchanger.model.ResponseSingle;
import pl.mardom92.Exchanger.model.ResponseArray;
import pl.mardom92.Exchanger.service.ResponseService;

import static pl.mardom92.Exchanger.Constants.ResponseSingleURL;
import static pl.mardom92.Exchanger.Constants.ResponseTableURL;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "")
public class ResponseController {

    private final ResponseService responseService;

    @GetMapping("/response")
    public ResponseSingle getResponseSingle(@RequestParam(name = "code", required = true) String current) {

        String url = ResponseSingleURL + current;

        return responseService.getResponseSingle(url);
    }

    @GetMapping("/response-array")
    public ResponseArray[] getResponseTable() {

        String url = ResponseTableURL;

        return responseService.getResponseArray(url);
    }
}

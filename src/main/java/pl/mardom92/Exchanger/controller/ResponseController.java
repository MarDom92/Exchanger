package pl.mardom92.Exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.mardom92.Exchanger.model.ResponseEntity;
import pl.mardom92.Exchanger.service.ResponseService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "")
public class ResponseController {

    private final ResponseService responseService;

    @GetMapping("")
    public ResponseEntity getResponse(@RequestParam(name = "in", required = true) String current) {
        return responseService.getResponse(current);
    }
}

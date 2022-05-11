package pl.mardom92.Exchanger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mardom92.Exchanger.model.dto.OperationDto;
import pl.mardom92.Exchanger.model.enums.OperationStatus;
import pl.mardom92.Exchanger.service.operation.OperationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/operations")
public class OperationController {

    private final OperationService operationService;

    @GetMapping("")
    public List<OperationDto> getAllOperationsByStatus(@RequestParam(required = false, name = "status") List<OperationStatus> statusList,
                                                       @RequestParam(required = false, defaultValue = "1", name = "page") int pageNumber,
                                                       @RequestParam(required = false, defaultValue = "0", name = "size") int sizeOnPage) {
        return operationService.getAllOperationsByStatus(statusList, pageNumber, sizeOnPage);
    }

    @GetMapping("/{id}")
    public OperationDto getSingleOperation(@PathVariable long id) {
        return operationService.getSingleOperation(id);
    }
}

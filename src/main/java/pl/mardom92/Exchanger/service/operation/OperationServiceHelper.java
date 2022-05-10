package pl.mardom92.Exchanger.service.operation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mardom92.Exchanger.model.entity.OperationEntity;
import pl.mardom92.Exchanger.model.enums.OperationStatus;
import pl.mardom92.Exchanger.model.exception.exchange.ExchangeError;
import pl.mardom92.Exchanger.model.exception.exchange.ExchangeException;
import pl.mardom92.Exchanger.model.exception.operation.OperationError;
import pl.mardom92.Exchanger.model.exception.operation.OperationException;
import pl.mardom92.Exchanger.repository.OperationRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OperationServiceHelper {

    private final OperationRepository operationRepository;

    protected int checkSizeOfList(List<OperationEntity> operations) {

        if (operations.isEmpty()) {
            throw new OperationException(OperationError.OPERATION_EMPTY_LIST);
        } else {
            return operations.size();
        }
    }

    protected int checkPageNumber(int pageNumber) {

        if (pageNumber < 1) {
            throw new OperationException(OperationError.OPERATION_WRONG_PARAMETER_VALUE);
        }

        return pageNumber;
    }

    protected int checkSizeOnPage(int sizeOnPage, int maxSize) {

        if (sizeOnPage > maxSize) {
            throw new OperationException(OperationError.OPERATION_WRONG_PARAMETER_VALUE);
        } else if (sizeOnPage <= 0) {
            throw new OperationException(OperationError.OPERATION_WRONG_PARAMETER_VALUE);
        } else {
            return sizeOnPage;
        }
    }

    protected OperationEntity checkOperationExist(long id) {

        return operationRepository.findById(id)
                .orElseThrow(() -> new OperationException(OperationError.OPERATION_NOT_FOUND));
    }
}

package pl.mardom92.Exchanger.service.operation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mardom92.Exchanger.model.entity.OperationEntity;
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
            throw new OperationException(OperationError.OPERATION_WRONG_PAGE_NUMBER_VALUE);
        }

        return pageNumber;
    }

    protected int checkSizeOnPage(int sizeOnPage, int maxSize) {

        if (sizeOnPage > maxSize) {
            throw new OperationException(OperationError.OPERATION_SIZE_ON_PAGE_TOO_GREAT);
        } else if (sizeOnPage < 0) {
            throw new OperationException(OperationError.OPERATION_SIZE_ON_PAGE_TOO_SMALL);
        } else if (sizeOnPage == 0) {
            sizeOnPage = maxSize;
        }

        return sizeOnPage;
    }

    protected OperationEntity checkOperationExist(long id) {

        return operationRepository.findById(id)
                .orElseThrow(() -> new OperationException(OperationError.OPERATION_NOT_FOUND));
    }
}

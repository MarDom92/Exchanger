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

    protected void checkEmptyList(List<OperationEntity> operations) {

        if (operations.isEmpty()) {
            throw new OperationException(OperationError.OPERATION_EMPTY_LIST);
        }
    }

    protected OperationEntity checkOperationExist(long id) {

        return operationRepository.findById(id)
                .orElseThrow(() -> new OperationException(OperationError.OPERATION_NOT_FOUND));
    }
}

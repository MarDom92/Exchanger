package pl.mardom92.Exchanger.service.operation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.mardom92.Exchanger.model.entity.OperationEntity;
import pl.mardom92.Exchanger.model.builder.dto.OperationDtoBuilder;
import pl.mardom92.Exchanger.model.dto.OperationDto;
import pl.mardom92.Exchanger.model.enums.OperationStatus;
import pl.mardom92.Exchanger.model.mapper.OperationMapper;
import pl.mardom92.Exchanger.repository.OperationRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OperationService {

    private final OperationRepository operationRepository;
    private final OperationServiceHelper operationServiceHelper;
    private final OperationMapper operationMapper;

    public List<OperationDto> getAllOperations(int page, int size) {

        if (size <= 0) {
            size = operationRepository.findAll().size();
        }

        if (page < 1) {
            page = 1;
        }

        List<OperationEntity> operations = operationRepository.findAll(PageRequest.of(page - 1, size)).toList();

        operationServiceHelper.checkEmptyList(operations);

        return operations.stream().map(operationMapper::fromEntityToDto).collect(Collectors.toList());
    }

    public OperationDto getSingleOperation(long id) {

        OperationEntity operation = operationServiceHelper.checkOperationExist(id);

        return operationMapper.fromEntityToDto(operation);
    }

    public void addOperation(OperationStatus status) {

        OperationDto operationDto = new OperationDtoBuilder()
                .withOperationStatus(status)
                .withCreationDate(new Date())
                .build();

        operationRepository.save(operationMapper.fromDtoToEntity(operationDto));
    }
}
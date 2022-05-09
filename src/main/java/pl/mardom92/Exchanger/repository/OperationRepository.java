package pl.mardom92.Exchanger.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mardom92.Exchanger.model.entity.OperationEntity;
import pl.mardom92.Exchanger.model.enums.OperationStatus;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<OperationEntity, Long> {

    List<OperationEntity> findOperationByOperationStatusIn(List<OperationStatus> statusList, Pageable pageable);
}

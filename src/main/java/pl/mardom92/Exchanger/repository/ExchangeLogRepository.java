package pl.mardom92.Exchanger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mardom92.Exchanger.model.ExchangeLogEntity;

public interface ExchangeLogRepository extends JpaRepository<ExchangeLogEntity, Long> {
}

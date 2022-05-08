package pl.mardom92.Exchanger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mardom92.Exchanger.model.ExchangeEntity;

public interface ExchangeRepository extends JpaRepository<ExchangeEntity, Long> {
}

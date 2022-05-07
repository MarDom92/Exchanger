package pl.mardom92.Exchanger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mardom92.Exchanger.model.CurrencyRateEntity;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRateEntity, Long> {
}

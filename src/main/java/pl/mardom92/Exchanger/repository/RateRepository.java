package pl.mardom92.Exchanger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mardom92.Exchanger.model.RateEntity;

public interface RateRepository extends JpaRepository<RateEntity, Long> {
}

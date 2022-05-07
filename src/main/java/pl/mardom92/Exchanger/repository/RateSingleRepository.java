package pl.mardom92.Exchanger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mardom92.Exchanger.model.RateSingleEntity;

public interface RateSingleRepository extends JpaRepository<RateSingleEntity, Long> {
}

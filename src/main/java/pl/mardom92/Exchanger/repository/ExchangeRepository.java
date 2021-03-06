package pl.mardom92.Exchanger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mardom92.Exchanger.model.entity.ExchangeEntity;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeEntity, Long> {
}

package pl.mardom92.Exchanger.service.exchangeLog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mardom92.Exchanger.model.ExchangeEntity;
import pl.mardom92.Exchanger.repository.ExchangeRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExchangeServiceHelper {

    private final ExchangeRepository exchangeRepository;

    protected void checkEmptyList(List<ExchangeEntity> logs) {

        if (logs.isEmpty()) {
            throw new RuntimeException("List of logs is empty.");
        }
    }

    protected ExchangeEntity checkExchange(long id) {

        return exchangeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log with this id does not exist."));
    }
}

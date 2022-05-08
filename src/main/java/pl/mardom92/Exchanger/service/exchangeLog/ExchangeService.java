package pl.mardom92.Exchanger.service.exchangeLog;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.mardom92.Exchanger.model.ExchangeEntity;
import pl.mardom92.Exchanger.repository.ExchangeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final ExchangeServiceHelper exchangeServiceHelper;

    public List<ExchangeEntity> getAllLogs(int page, int size) {

        if (size <= 0) {
            size = exchangeRepository.findAll().size();
        }

        if (page < 1) {
            page = 1;
        }

        List<ExchangeEntity> logs = exchangeRepository.findAll(PageRequest.of(page - 1, size)).toList();

        exchangeServiceHelper.checkEmptyList(logs);

        return logs;
    }

    public ExchangeEntity getSingleLog(long id) {

        ExchangeEntity exchange = exchangeServiceHelper.checkExchange(id);

        return exchange;
    }
}

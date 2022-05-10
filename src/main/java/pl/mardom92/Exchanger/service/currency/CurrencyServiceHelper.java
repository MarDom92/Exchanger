package pl.mardom92.Exchanger.service.currency;

import org.springframework.stereotype.Component;
import pl.mardom92.Exchanger.model.NbpArrayResponse;
import pl.mardom92.Exchanger.model.exception.currency.CurrencyError;
import pl.mardom92.Exchanger.model.exception.currency.CurrencyException;

@Component
public class CurrencyServiceHelper {

    protected int checkLengthOfArray(NbpArrayResponse[] array) {

        if (array.length <= 0) {
            throw new CurrencyException(CurrencyError.CURRENCY_EMPTY_LIST);
        } else {
            return array.length;
        }
    }
}

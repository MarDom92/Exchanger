package pl.mardom92.Exchanger.service.rate;

import org.springframework.stereotype.Component;
import pl.mardom92.Exchanger.model.NbpArrayResponse;
import pl.mardom92.Exchanger.model.exception.rate.RateError;
import pl.mardom92.Exchanger.model.exception.rate.RateException;

@Component
public class RateServiceHelper {

    protected int checkLengthOfArray(NbpArrayResponse[] array) {

        if (array.length <= 0) {
            throw new RateException(RateError.RATE_EMPTY_LIST);
        } else {
            return array.length;
        }
    }
}

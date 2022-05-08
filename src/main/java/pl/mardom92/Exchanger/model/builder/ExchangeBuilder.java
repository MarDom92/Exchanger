package pl.mardom92.Exchanger.model.builder;

import pl.mardom92.Exchanger.model.ExchangeEntity;

import java.util.Date;

public class ExchangeBuilder {

    private long id;

    double inputSum;
    double outputSum;
    String inputCurrencyCode;
    String outputCurrencyCode;
    double askPrice;
    double bidPrice;
    Date creationDate;

    public ExchangeBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public ExchangeBuilder withInputSum(double inputSum) {
        this.inputSum = inputSum;
        return this;
    }

    public ExchangeBuilder withOutputSum(double outputSum) {
        this.outputSum = outputSum;
        return this;
    }

    public ExchangeBuilder withInputCurrnecyCode(String inputCurrencyCode) {
        this.inputCurrencyCode = inputCurrencyCode;
        return this;
    }

    public ExchangeBuilder withOutputCurrencyCode(String outputCurrencyCode) {
        this.outputCurrencyCode = outputCurrencyCode;
        return this;
    }

    public ExchangeBuilder withAskPrice(double askPrice) {
        this.askPrice = askPrice;
        return this;
    }

    public ExchangeBuilder withBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
        return this;
    }

    public ExchangeBuilder withCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public ExchangeEntity build() {

        ExchangeEntity exchangeEntity = new ExchangeEntity();

        exchangeEntity.setId(id);
        exchangeEntity.setInputSum(inputSum);
        exchangeEntity.setOutputSum(outputSum);
        exchangeEntity.setInputCurrencyCode(inputCurrencyCode);
        exchangeEntity.setOutputCurrencyCode(outputCurrencyCode);
        exchangeEntity.setAskPrice(askPrice);
        exchangeEntity.setBidPrice(bidPrice);
        exchangeEntity.setCreationDate(creationDate);

        return exchangeEntity;
    }
}

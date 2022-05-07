package pl.mardom92.Exchanger.model.builder;

import pl.mardom92.Exchanger.model.CurrencyRateEntity;

public class CurrencyRateBuilder {

    private long id;

    private String currency;
    private String code;
    private double bid;
    private double ask;

    public CurrencyRateBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public CurrencyRateBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public CurrencyRateBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public CurrencyRateBuilder withBid(Double bid) {
        this.bid = bid;
        return this;
    }

    public CurrencyRateBuilder withAsk(Double ask) {
        this.ask = ask;
        return this;
    }

    public CurrencyRateEntity build() {

        CurrencyRateEntity currencyRate = new CurrencyRateEntity();

        currencyRate.setCurrency(currency);
        currencyRate.setCode(code);
        currencyRate.setBid(bid);
        currencyRate.setAsk(ask);

        return currencyRate;
    }
}

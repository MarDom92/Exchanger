package pl.mardom92.Exchanger.model.builder;

import pl.mardom92.Exchanger.model.Currency;

public class CurrencyBuilder {

    private long id;

    private String currency;
    private String code;
    private double bid;
    private double ask;

    public CurrencyBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public CurrencyBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public CurrencyBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public CurrencyBuilder withBid(Double bid) {
        this.bid = bid;
        return this;
    }

    public CurrencyBuilder withAsk(Double ask) {
        this.ask = ask;
        return this;
    }

    public Currency build() {

        Currency currencyRate = new Currency();

        currencyRate.setCurrency(currency);
        currencyRate.setCode(code);
        currencyRate.setBid(bid);
        currencyRate.setAsk(ask);

        return currencyRate;
    }
}

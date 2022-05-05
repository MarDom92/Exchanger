package pl.mardom92.Exchanger.model.builder;

import pl.mardom92.Exchanger.model.RateEntity;

public class RateBuilder {

    public long id;

    public String currency;
    public String code;
    public Double bid;
    public Double ask;

    public RateBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public RateBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public RateBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public RateBuilder withBid(Double bid) {
        this.bid = bid;
        return this;
    }

    public RateBuilder withAsk(Double ask) {
        this.ask = ask;
        return this;
    }

    public RateEntity build() {

        RateEntity rate = new RateEntity();

        rate.setId(id);
        rate.setCurrency(currency);
        rate.setCode(code);
        rate.setBid(bid);
        rate.setAsk(ask);

        return rate;
    }
}

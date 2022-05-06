package pl.mardom92.Exchanger.model.builder;

import pl.mardom92.Exchanger.model.RateEntity;

public class RateBuilder {

    public long id;

    public String tableNumber;
    public String effectiveDate;
    public Double bid;
    public Double ask;

    public RateBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public RateBuilder withTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
        return this;
    }

    public RateBuilder withEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
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
        rate.setTableNumber(tableNumber);
        rate.setEffectiveDate(effectiveDate);
        rate.setBid(bid);
        rate.setAsk(ask);

        return rate;
    }
}

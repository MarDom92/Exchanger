package pl.mardom92.Exchanger.model.builder;

import pl.mardom92.Exchanger.model.RateSingleEntity;

public class RateSingleBuilder {

    public long id;

    public String tableNumber;
    public String effectiveDate;
    public Double bid;
    public Double ask;

    public RateSingleBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public RateSingleBuilder withTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
        return this;
    }

    public RateSingleBuilder withEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    public RateSingleBuilder withBid(Double bid) {
        this.bid = bid;
        return this;
    }

    public RateSingleBuilder withAsk(Double ask) {
        this.ask = ask;
        return this;
    }

    public RateSingleEntity build() {

        RateSingleEntity rate = new RateSingleEntity();

        rate.setId(id);
        rate.setTableNumber(tableNumber);
        rate.setEffectiveDate(effectiveDate);
        rate.setBid(bid);
        rate.setAsk(ask);

        return rate;
    }
}

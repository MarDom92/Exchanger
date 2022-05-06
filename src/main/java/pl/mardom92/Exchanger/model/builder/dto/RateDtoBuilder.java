package pl.mardom92.Exchanger.model.builder.dto;

import pl.mardom92.Exchanger.model.dto.RateDto;

public class RateDtoBuilder {

    public String tableNumber;
    public String effectiveDate;
    public Double bid;
    public Double ask;

    public RateDtoBuilder withTableNumber(String tableNumber) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    public RateDtoBuilder withEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    public RateDtoBuilder withBide(Double bid) {
        this.bid = bid;
        return this;
    }

    public RateDtoBuilder withAsk(Double ask) {
        this.ask = ask;
        return this;
    }

    public RateDto build() {

        RateDto rateDto = new RateDto();

        rateDto.setTableNumber(tableNumber);
        rateDto.setEffectiveDate(effectiveDate);
        rateDto.setBid(bid);
        rateDto.setAsk(ask);

        return rateDto;
    }
}

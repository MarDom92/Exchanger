package pl.mardom92.Exchanger.model.builder.dto;

import pl.mardom92.Exchanger.model.dto.RateDto;

public class RateDtoBuilder {

    public String currency;
    public String code;
    public Double bid;
    public Double ask;

    public RateDtoBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public RateDtoBuilder withCode(String code) {
        this.code = code;
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

        rateDto.setCurrency(currency);
        rateDto.setCode(code);
        rateDto.setBid(bid);
        rateDto.setAsk(ask);

        return rateDto;
    }
}

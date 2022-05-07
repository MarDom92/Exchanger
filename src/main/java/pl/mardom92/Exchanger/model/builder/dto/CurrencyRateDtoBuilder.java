package pl.mardom92.Exchanger.model.builder.dto;

import pl.mardom92.Exchanger.model.dto.CurrencyRateDto;

public class CurrencyRateDtoBuilder {

    private String currency;
    private String code;
    private double bid;
    private double ask;

    public CurrencyRateDtoBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public CurrencyRateDtoBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public CurrencyRateDtoBuilder withBid(Double bid) {
        this.bid = bid;
        return this;
    }

    public CurrencyRateDtoBuilder withAsk(Double ask) {
        this.ask = ask;
        return this;
    }

    public CurrencyRateDto build() {

        CurrencyRateDto currencyRateDto = new CurrencyRateDto();

        currencyRateDto.setCurrency(currency);
        currencyRateDto.setCode(code);
        currencyRateDto.setBid(bid);
        currencyRateDto.setAsk(ask);

        return currencyRateDto;
    }
}

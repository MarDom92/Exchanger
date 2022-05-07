package pl.mardom92.Exchanger.model.builder.dto;

import pl.mardom92.Exchanger.model.dto.RateSingleDto;

public class RateSingleDtoBuilder {

    private String tableNumber;
    private String effectiveDate;
    private double bid;
    private double ask;

    public RateSingleDtoBuilder withTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
        return this;
    }

    public RateSingleDtoBuilder withEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
        return this;
    }

    public RateSingleDtoBuilder withBide(Double bid) {
        this.bid = bid;
        return this;
    }

    public RateSingleDtoBuilder withAsk(Double ask) {
        this.ask = ask;
        return this;
    }

    public RateSingleDto build() {

        RateSingleDto rateSingleDto = new RateSingleDto();

        rateSingleDto.setTableNumber(tableNumber);
        rateSingleDto.setEffectiveDate(effectiveDate);
        rateSingleDto.setBid(bid);
        rateSingleDto.setAsk(ask);

        return rateSingleDto;
    }
}

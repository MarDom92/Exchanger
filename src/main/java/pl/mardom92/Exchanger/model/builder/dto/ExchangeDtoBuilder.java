package pl.mardom92.Exchanger.model.builder.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import pl.mardom92.Exchanger.model.dto.ExchangeDto;

import java.time.LocalDateTime;

public class ExchangeDtoBuilder {

    double inputSum;
    double outputSum;
    String inputCurrencyCode;
    String outputCurrencyCode;
    double askPrice;
    double bidPrice;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime creationDate;

    public ExchangeDtoBuilder withInputSum(double inputSum) {
        this.inputSum = inputSum;
        return this;
    }

    public ExchangeDtoBuilder withOutputSum(double outputSum) {
        this.outputSum = outputSum;
        return this;
    }

    public ExchangeDtoBuilder withInputCurrnecyCode(String inputCurrencyCode) {
        this.inputCurrencyCode = inputCurrencyCode;
        return this;
    }

    public ExchangeDtoBuilder withOutputCurrencyCode(String outputCurrencyCode) {
        this.outputCurrencyCode = outputCurrencyCode;
        return this;
    }

    public ExchangeDtoBuilder withAskPrice(double askPrice) {
        this.askPrice = askPrice;
        return this;
    }

    public ExchangeDtoBuilder withBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
        return this;
    }

    public ExchangeDtoBuilder withCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public ExchangeDto build() {

        ExchangeDto exchangeDto = new ExchangeDto();

        exchangeDto.setInputSum(inputSum);
        exchangeDto.setOutputSum(outputSum);
        exchangeDto.setInputCurrencyCode(inputCurrencyCode);
        exchangeDto.setOutputCurrencyCode(outputCurrencyCode);
        exchangeDto.setAskPrice(askPrice);
        exchangeDto.setBidPrice(bidPrice);
        exchangeDto.setCreationDate(creationDate);

        return exchangeDto;
    }
}

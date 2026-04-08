package com.stocktracker.stock_market_tracker.requestdto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class StockRequestDto {
	@NotBlank(message = "Stock symbol is required")
    @Size(max = 10, message = "Symbol must be 10 characters or less")
    private String symbol;
    
    @NotBlank(message = "Company name is required")
    private String companyName;
    
    @NotNull(message = "Current price is required")
    @DecimalMin(value = "0.0", message = "Price must be positive")
    private BigDecimal currentPrice;
    
    @DecimalMin(value = "0.0", message = "Price must be positive")
    private BigDecimal openPrice;
    
    @DecimalMin(value = "0.0", message = "Price must be positive")
    private BigDecimal highPrice;
    
    @DecimalMin(value = "0.0", message = "Price must be positive")
    private BigDecimal lowPrice;

    public StockRequestDto() {
    }

    public StockRequestDto(String symbol, String companyName, BigDecimal currentPrice, BigDecimal openPrice, BigDecimal highPrice, BigDecimal lowPrice) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.currentPrice = currentPrice;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public BigDecimal getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public static StockRequestDtoBuilder builder() {
        return new StockRequestDtoBuilder();
    }

    public static class StockRequestDtoBuilder {
        private String symbol;
        private String companyName;
        private BigDecimal currentPrice;
        private BigDecimal openPrice;
        private BigDecimal highPrice;
        private BigDecimal lowPrice;

        StockRequestDtoBuilder() {
        }

        public StockRequestDtoBuilder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public StockRequestDtoBuilder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public StockRequestDtoBuilder currentPrice(BigDecimal currentPrice) {
            this.currentPrice = currentPrice;
            return this;
        }

        public StockRequestDtoBuilder openPrice(BigDecimal openPrice) {
            this.openPrice = openPrice;
            return this;
        }

        public StockRequestDtoBuilder highPrice(BigDecimal highPrice) {
            this.highPrice = highPrice;
            return this;
        }

        public StockRequestDtoBuilder lowPrice(BigDecimal lowPrice) {
            this.lowPrice = lowPrice;
            return this;
        }

        public StockRequestDto build() {
            return new StockRequestDto(this.symbol, this.companyName, this.currentPrice, this.openPrice, this.highPrice, this.lowPrice);
        }
    }
}

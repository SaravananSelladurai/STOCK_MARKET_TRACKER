package com.stocktracker.stock_market_tracker.responsedto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Data Transfer Object representing the response for stock market data.
 * This class uses the Builder design pattern for object creation.
 */
public class StockResponseDto {

    /**
     * The unique identifier of the stock.
     */
    private Integer id;

    /**
     * The ticker symbol of the stock (e.g., AAPL, GOOG).
     */
    private String symbol;

    /**
     * The full name of the company.
     */
    private String companyName;

    /**
     * The current trading price of the stock.
     */
    private BigDecimal currentPrice;

    /**
     * The opening price of the stock for the current trading session.
     */
    private BigDecimal openPrice;

    /**
     * The highest price of the stock during the current trading session.
     */
    private BigDecimal highPrice;

    /**
     * The lowest price of the stock during the current trading session.
     */
    private BigDecimal lowPrice;

    /**
     * The timestamp of when the stock data was last updated.
     */
    private LocalDateTime lastUpdated;

    /**
     * Default no-argument constructor.
     */
    public StockResponseDto() {
    }

    /**
     * All-argument constructor for creating a StockResponseDto instance.
     *
     * @param id           The unique identifier of the stock
     * @param symbol       The ticker symbol of the stock
     * @param companyName  The full name of the company
     * @param currentPrice The current trading price
     * @param openPrice    The opening price
     * @param highPrice    The highest price
     * @param lowPrice     The lowest price
     * @param lastUpdated  The timestamp of the last update
     */
    public StockResponseDto(Integer id, String symbol, String companyName, BigDecimal currentPrice, BigDecimal openPrice, BigDecimal highPrice, BigDecimal lowPrice, LocalDateTime lastUpdated) {
        this.id = id;
        this.symbol = symbol;
        this.companyName = companyName;
        this.currentPrice = currentPrice;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.lastUpdated = lastUpdated;
    }

    /**
     * Private constructor used by the Builder to create an instance.
     *
     * @param builder The Builder containing the configuration
     */
    private StockResponseDto(Builder builder) {
        this.id = builder.id;
        this.symbol = builder.symbol;
        this.companyName = builder.companyName;
        this.currentPrice = builder.currentPrice;
        this.openPrice = builder.openPrice;
        this.highPrice = builder.highPrice;
        this.lowPrice = builder.lowPrice;
        this.lastUpdated = builder.lastUpdated;
    }

    /**
     * Gets the unique identifier of the stock.
     * @return the stock ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the stock.
     * @param id the stock ID to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the ticker symbol of the stock.
     * @return the stock symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets the ticker symbol of the stock.
     * @param symbol the stock symbol to set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets the full name of the company.
     * @return the company name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the full name of the company.
     * @param companyName the company name to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Gets the current trading price of the stock.
     * @return the current price
     */
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    /**
     * Sets the current trading price of the stock.
     * @param currentPrice the current price to set
     */
    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * Gets the opening price of the stock for the current session.
     * @return the opening price
     */
    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    /**
     * Sets the opening price of the stock for the current session.
     * @param openPrice the opening price to set
     */
    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    /**
     * Gets the highest price of the stock during the current session.
     * @return the high price
     */
    public BigDecimal getHighPrice() {
        return highPrice;
    }

    /**
     * Sets the highest price of the stock during the current session.
     * @param highPrice the high price to set
     */
    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    /**
     * Gets the lowest price of the stock during the current session.
     * @return the low price
     */
    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    /**
     * Sets the lowest price of the stock during the current session.
     * @param lowPrice the low price to set
     */
    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    /**
     * Gets the timestamp of when the stock data was last updated.
     * @return the last update timestamp
     */
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Sets the timestamp of when the stock data was last updated.
     * @param lastUpdated the last update timestamp to set
     */
    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Creates a new Builder instance for StockResponseDto.
     *
     * @return a new Builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for incrementally building a StockResponseDto instance.
     */
    public static class Builder {
        private Integer id;
        private String symbol;
        private String companyName;
        private BigDecimal currentPrice;
        private BigDecimal openPrice;
        private BigDecimal highPrice;
        private BigDecimal lowPrice;
        private LocalDateTime lastUpdated;

        /**
         * Sets the stock ID.
         * @param id the stock ID
         * @return the current Builder instance
         */
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the stock symbol.
         * @param symbol the stock symbol
         * @return the current Builder instance
         */
        public Builder symbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        /**
         * Sets the company name.
         * @param companyName the company name
         * @return the current Builder instance
         */
        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        /**
         * Sets the current price.
         * @param currentPrice the current price
         * @return the current Builder instance
         */
        public Builder currentPrice(BigDecimal currentPrice) {
            this.currentPrice = currentPrice;
            return this;
        }

        /**
         * Sets the opening price.
         * @param openPrice the opening price
         * @return the current Builder instance
         */
        public Builder openPrice(BigDecimal openPrice) {
            this.openPrice = openPrice;
            return this;
        }

        /**
         * Sets the highest price.
         * @param highPrice the highest price
         * @return the current Builder instance
         */
        public Builder highPrice(BigDecimal highPrice) {
            this.highPrice = highPrice;
            return this;
        }

        /**
         * Sets the lowest price.
         * @param lowPrice the lowest price
         * @return the current Builder instance
         */
        public Builder lowPrice(BigDecimal lowPrice) {
            this.lowPrice = lowPrice;
            return this;
        }

        /**
         * Sets the last updated timestamp.
         * @param lastUpdated the last updated timestamp
         * @return the current Builder instance
         */
        public Builder lastUpdated(LocalDateTime lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        /**
         * Builds and returns a new StockResponseDto instance based on the builder's state.
         * @return a completed StockResponseDto
         */
        public StockResponseDto build() {
            return new StockResponseDto(this);
        }
    }
}

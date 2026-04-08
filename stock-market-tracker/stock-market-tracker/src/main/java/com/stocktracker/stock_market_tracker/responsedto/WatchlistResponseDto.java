package com.stocktracker.stock_market_tracker.responsedto;

import java.time.LocalDateTime;

/**
 * Data Transfer Object representing the response for a user's watchlist item.
 * This class uses the Builder design pattern for object creation.
 */
public class WatchlistResponseDto {

    /**
     * The unique identifier of the watchlist entry.
     */
    private Integer id;

    /**
     * The unique identifier of the user who owns the watchlist.
     */
    private Integer userId;

    /**
     * The username of the user who owns the watchlist.
     */
    private String username;

    /**
     * The unique identifier of the stock in the watchlist.
     */
    private Integer stockId;

    /**
     * The ticker symbol of the stock.
     */
    private String symbol;

    /**
     * The full name of the company.
     */
    private String companyName;

    /**
     * The timestamp of when the stock was added to the watchlist.
     */
    private LocalDateTime addedAt;

    /**
     * Default no-argument constructor.
     */
    public WatchlistResponseDto() {
    }

    /**
     * All-argument constructor for creating a WatchlistResponseDto instance.
     *
     * @param id          The unique identifier of the watchlist entry
     * @param userId      The unique identifier of the user
     * @param username    The username of the user
     * @param stockId     The unique identifier of the stock
     * @param symbol      The ticker symbol of the stock
     * @param companyName The full name of the company
     * @param addedAt     The timestamp of when the stock was added
     */
    public WatchlistResponseDto(Integer id, Integer userId, String username, Integer stockId, String symbol, String companyName, LocalDateTime addedAt) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.stockId = stockId;
        this.symbol = symbol;
        this.companyName = companyName;
        this.addedAt = addedAt;
    }

    /**
     * Private constructor used by the Builder to create an instance.
     *
     * @param builder The Builder containing the configuration
     */
    private WatchlistResponseDto(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.username = builder.username;
        this.stockId = builder.stockId;
        this.symbol = builder.symbol;
        this.companyName = builder.companyName;
        this.addedAt = builder.addedAt;
    }

    /**
     * Gets the unique identifier of the watchlist entry.
     * @return the watchlist entry ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the watchlist entry.
     * @param id the watchlist entry ID to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the unique identifier of the user.
     * @return the user ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the unique identifier of the user.
     * @param userId the user ID to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets the username of the user.
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the unique identifier of the stock.
     * @return the stock ID
     */
    public Integer getStockId() {
        return stockId;
    }

    /**
     * Sets the unique identifier of the stock.
     * @param stockId the stock ID to set
     */
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
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
     * Gets the timestamp of when the stock was added to the watchlist.
     * @return the timestamp of when added
     */
    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    /**
     * Sets the timestamp of when the stock was added to the watchlist.
     * @param addedAt the timestamp to set
     */
    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    /**
     * Creates a new Builder instance for WatchlistResponseDto.
     *
     * @return a new Builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for incrementally building a WatchlistResponseDto instance.
     */
    public static class Builder {
        private Integer id;
        private Integer userId;
        private String username;
        private Integer stockId;
        private String symbol;
        private String companyName;
        private LocalDateTime addedAt;

        /**
         * Sets the watchlist entry ID.
         * @param id the watchlist entry ID
         * @return the current Builder instance
         */
        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the user ID.
         * @param userId the user ID
         * @return the current Builder instance
         */
        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        /**
         * Sets the username.
         * @param username the username
         * @return the current Builder instance
         */
        public Builder username(String username) {
            this.username = username;
            return this;
        }

        /**
         * Sets the stock ID.
         * @param stockId the stock ID
         * @return the current Builder instance
         */
        public Builder stockId(Integer stockId) {
            this.stockId = stockId;
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
         * Sets the timestamp of when the stock was added.
         * @param addedAt the timestamp
         * @return the current Builder instance
         */
        public Builder addedAt(LocalDateTime addedAt) {
            this.addedAt = addedAt;
            return this;
        }

        /**
         * Builds and returns a new WatchlistResponseDto instance based on the builder's state.
         * @return a completed WatchlistResponseDto
         */
        public WatchlistResponseDto build() {
            return new WatchlistResponseDto(this);
        }
    }
}

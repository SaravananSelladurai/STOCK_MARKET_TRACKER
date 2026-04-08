package com.stocktracker.stock_market_tracker.requestdto;

import jakarta.validation.constraints.NotNull;

public class WatchlistRequestDto {
    @NotNull(message = "User ID is required")
    private Integer userId;

    @NotNull(message = "Stock ID is required")
    private Integer stockId;

    public WatchlistRequestDto() {
    }

    public WatchlistRequestDto(Integer userId, Integer stockId) {
        this.userId = userId;
        this.stockId = stockId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public static class Builder {
        private Integer userId;
        private Integer stockId;

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder stockId(Integer stockId) {
            this.stockId = stockId;
            return this;
        }

        public WatchlistRequestDto build() {
            return new WatchlistRequestDto(userId, stockId);
        }
    }
}

package com.stocktracker.stock_market_tracker.responsedto;

import java.time.LocalDateTime;

public class UserResponseDto {

    private Integer id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long watchlistCount;

    // ✅ Private constructor
    private UserResponseDto(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.watchlistCount = builder.watchlistCount;
    }

    // ✅ Getters
    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public long getWatchlistCount() {
        return watchlistCount;
    }

    // ✅ Static Builder Class
    public static class Builder {

        private Integer id;
        private String username;
        private String email;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private long watchlistCount;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder watchlistCount(long watchlistCount) {
            this.watchlistCount = watchlistCount;
            return this;
        }

        public UserResponseDto build() {
            return new UserResponseDto(this);
        }
    }
}
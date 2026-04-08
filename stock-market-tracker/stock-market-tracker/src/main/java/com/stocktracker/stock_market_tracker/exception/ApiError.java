package com.stocktracker.stock_market_tracker.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private int status;
    private String message;
    private String error;
    private LocalDateTime timestamp;
    private String path;
    private Map<String, String> fieldErrors;

    // ✅ Private constructor – forces builder usage
    private ApiError(Builder builder) {
        this.status = builder.status;
        this.message = builder.message;
        this.error = builder.error;
        this.timestamp = builder.timestamp;
        this.path = builder.path;
        this.fieldErrors = builder.fieldErrors;
    }

    // ✅ Getters (or generate using IDE)
    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }

    // ✅ Static Builder Class
    public static class Builder {

        private int status;
        private String message;
        private String error;
        private LocalDateTime timestamp;
        private String path;
        private Map<String, String> fieldErrors;

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder error(String error) {
            this.error = error;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public Builder fieldErrors(Map<String, String> fieldErrors) {
            this.fieldErrors = fieldErrors;
            return this;
        }

        public ApiError build() {
            return new ApiError(this);
        }
    }
}
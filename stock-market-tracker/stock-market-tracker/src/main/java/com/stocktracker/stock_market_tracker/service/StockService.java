package com.stocktracker.stock_market_tracker.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.stocktracker.stock_market_tracker.entity.StocksData;

public interface StockService {
    StocksData addStock(String symbol, String companyName, BigDecimal currentPrice, BigDecimal openPrice,
            BigDecimal highPrice, BigDecimal lowPrice);

    Optional<StocksData> getStockById(Integer id);

    Optional<StocksData> getStockBySymbol(String symbol);

    void deleteStock(Integer id);

    Optional<StocksData> updateStockPrice(Integer id, BigDecimal newPrice);

    List<StocksData> searchStocks(String query);

    List<StocksData> getAllStocks();
}

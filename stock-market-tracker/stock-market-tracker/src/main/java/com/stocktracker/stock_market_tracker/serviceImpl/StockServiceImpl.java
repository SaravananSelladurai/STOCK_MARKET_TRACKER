package com.stocktracker.stock_market_tracker.serviceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.stocktracker.stock_market_tracker.entity.StocksData;
import com.stocktracker.stock_market_tracker.repo.StockRepository;
import com.stocktracker.stock_market_tracker.service.StockService;

import jakarta.validation.constraints.NotBlank;

@Service
@Validated
public class StockServiceImpl implements StockService {
	private final StockRepository stockRepository;

	public StockServiceImpl(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}
	
	// Add a stock to database
	public StocksData addStock(String symbol, String companyName, BigDecimal currentPrice, BigDecimal openPrice,
			BigDecimal highPrice, BigDecimal lowPrice) {
		if (stockRepository.existsBySymbol(symbol)) {
			throw new IllegalArgumentException("Stock symbol already exists");
		}

		StocksData stock = new StocksData();
		stock.setSymbol(symbol);
		stock.setCompanyName(companyName);
		// Note: the set prices are currently BigDecimal but StocksData takes Integer, need to convert or update entity
		stock.setCurrentPrice(currentPrice.intValue());
		stock.setOpenPrice(openPrice.intValue());
		stock.setHighPrice(highPrice.intValue());
		stock.setLowPrice(lowPrice.intValue());

		return stockRepository.save(stock);
	}

	@SuppressWarnings("null")
	@Override
	public Optional<StocksData> getStockById(@NotBlank Integer id) {
		return stockRepository.findById(id);
	}

	@Override
	public Optional<StocksData> getStockBySymbol(@NotBlank String symbol) {
		return stockRepository.findBySymbol(symbol);
	}

	@SuppressWarnings("null")
	@Override
	public void deleteStock(@NotBlank Integer id) {
		stockRepository.deleteById(id);
	}

	@Override
	public Optional<StocksData> updateStockPrice(@NotBlank Integer id, BigDecimal newPrice) {
		return null;

	}

	@Override
	public List<StocksData> searchStocks(String query) {
		return stockRepository.findByCompanyNameContainingIgnoreCase(query);
	}

	@Override
	public List<StocksData> getAllStocks() {
		return stockRepository.findAll();
	}
}

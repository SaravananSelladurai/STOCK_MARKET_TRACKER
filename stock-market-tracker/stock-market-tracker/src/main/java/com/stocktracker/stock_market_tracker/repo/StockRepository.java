package com.stocktracker.stock_market_tracker.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktracker.stock_market_tracker.entity.StocksData;

@Repository
public interface StockRepository extends JpaRepository<StocksData, Integer>{
	 // Find stock by symbol (e.g., "AAPL")
    Optional<StocksData> findBySymbol(String symbol);
    
    // Check if stock exists
    boolean existsBySymbol(String symbol);
    
    // Search stocks by company name (partial match)
    List<StocksData> findByCompanyNameContainingIgnoreCase(String companyName);
}

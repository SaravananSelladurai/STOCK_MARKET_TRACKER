package com.stocktracker.stock_market_tracker.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stocktracker.stock_market_tracker.entity.StocksData;
import com.stocktracker.stock_market_tracker.exception.DuplicateResourceException;
import com.stocktracker.stock_market_tracker.exception.ResourceNotFoundException;
import com.stocktracker.stock_market_tracker.requestdto.StockRequestDto;
import com.stocktracker.stock_market_tracker.responsedto.StockResponseDto;
import com.stocktracker.stock_market_tracker.service.StockService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    // Create a new stock
    @PostMapping
    public ResponseEntity<StockResponseDto> createStock(@Valid @RequestBody StockRequestDto request) {
        try {
            StocksData stock = stockService.addStock(
                    request.getSymbol(),
                    request.getCompanyName(),
                    request.getCurrentPrice(),
                    request.getOpenPrice(),
                    request.getHighPrice(),
                    request.getLowPrice());
            return new ResponseEntity<>(
                    convertToResponse(stock),
                    HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            throw new DuplicateResourceException(e.getMessage());
        }
    }

    // Get stock by ID
    @GetMapping("/{id}")
    public ResponseEntity<StockResponseDto> getStockById(@PathVariable Integer id) {
        StocksData stock = stockService.getStockById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found with id: " + id));
        return ResponseEntity.ok(convertToResponse(stock));
    }

    // Get stock by symbol
    @GetMapping("/symbol/{symbol}")
    public ResponseEntity<StockResponseDto> getStockBySymbol(@PathVariable String symbol) {
        StocksData stock = stockService.getStockBySymbol(symbol)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found with symbol: " + symbol));
        return ResponseEntity.ok(convertToResponse(stock));
    }

    // Search stocks by company name
    @GetMapping("/search")
    public ResponseEntity<List<StockResponseDto>> searchStocks(@RequestParam String query) {
        List<StocksData> stocks = stockService.searchStocks(query);
        List<StockResponseDto> responses = stocks.stream()
                .map(this::convertToResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    // Get all stocks
    @GetMapping
    public ResponseEntity<List<StockResponseDto>> getAllStocks() {
        List<StocksData> stocks = stockService.getAllStocks();
        List<StockResponseDto> responses = stocks.stream()
                .map(this::convertToResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    // Update stock price
    @PutMapping("/{id}/price")
    public ResponseEntity<StockResponseDto> updateStockPrice(
            @PathVariable Integer id,
            @RequestParam("price") java.math.BigDecimal newPrice) {
        StocksData stock = stockService.updateStockPrice(id, newPrice)
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found with id: " + id));
        return ResponseEntity.ok(convertToResponse(stock));
    }

    // Helper method to convert Entity to DTO
    private StockResponseDto convertToResponse(StocksData stock) {
        return new StockResponseDto.Builder()
                .id(stock.getStockPk())
                .symbol(stock.getSymbol())
                .companyName(stock.getCompanyName())
                .currentPrice(java.math.BigDecimal.valueOf(stock.getCurrentPrice()))
                .openPrice(java.math.BigDecimal.valueOf(stock.getOpenPrice()))
                .highPrice(java.math.BigDecimal.valueOf(stock.getHighPrice()))
                .lowPrice(java.math.BigDecimal.valueOf(stock.getLowPrice()))
                .build();
    }
}

package com.stocktracker.stock_market_tracker.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktracker.stock_market_tracker.entity.Watchlist;
import com.stocktracker.stock_market_tracker.exception.ResourceNotFoundException;
import com.stocktracker.stock_market_tracker.requestdto.WatchlistRequestDto;
import com.stocktracker.stock_market_tracker.responsedto.WatchlistResponseDto;
import com.stocktracker.stock_market_tracker.service.StockService;
import com.stocktracker.stock_market_tracker.service.UserService;
import com.stocktracker.stock_market_tracker.service.WatchlistService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/watchlists")
public class WatchlistController {
    private final WatchlistService watchlistService;
    private final UserService userService;
    private final StockService stockService;

    public WatchlistController(WatchlistService watchlistService, UserService userService, StockService stockService) {
        this.watchlistService = watchlistService;
        this.userService = userService;
        this.stockService = stockService;
    }

    // Create a new watchlist
    @PostMapping
    public ResponseEntity<WatchlistResponseDto> createWatchlist(@Valid @RequestBody WatchlistRequestDto request) {
        // Validate user exists
        userService.getUserById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + request.getUserId()));

        // Validate stock exists
        stockService.getStockById(request.getStockId())
                .orElseThrow(() -> new ResourceNotFoundException("Stock not found with id: " + request.getStockId()));

        Watchlist watchlist = watchlistService.createWatchlist(request.getUserId(), request.getStockId());
        return new ResponseEntity<>(convertToResponse(watchlist), HttpStatus.CREATED);
    }

    // Get watchlist by ID
    @GetMapping("/{id}")
    public ResponseEntity<WatchlistResponseDto> getWatchlistById(@PathVariable Integer id) {
        Watchlist watchlist = watchlistService.getWatchlistById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Watchlist not found with id: " + id));
        return ResponseEntity.ok(convertToResponse(watchlist));
    }

    // Get all watchlists for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WatchlistResponseDto>> getWatchlistsByUser(@PathVariable Integer userId) {
        List<Watchlist> watchlists = watchlistService.getUserWatchlist(userId);
        List<WatchlistResponseDto> responses = watchlists.stream()
                .map(this::convertToResponse)
                .toList();
        return ResponseEntity.ok(responses);
    }

    // Delete watchlist
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWatchlist(@PathVariable Integer id) {
        watchlistService.deleteWatchlist(id);
        return ResponseEntity.noContent().build();
    }

    // Helper method to convert Entity to DTO
    private WatchlistResponseDto convertToResponse(Watchlist watchlist) {
        return new WatchlistResponseDto.Builder()
                .id(watchlist.getUsersData().getUserPk())
                .username(watchlist.getUsersData().getUsername())
                .stockId(watchlist.getStocksData().getStockPk())
                .symbol(watchlist.getStocksData().getSymbol())
                .companyName(watchlist.getStocksData().getCompanyName())
                .addedAt(watchlist.getLastUpdated() != null ? watchlist.getLastUpdated().toLocalDateTime() : null)
                .build();
    }
}

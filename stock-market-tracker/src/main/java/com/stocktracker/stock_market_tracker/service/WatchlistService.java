package com.stocktracker.stock_market_tracker.service;

import java.util.List;
import java.util.Optional;

import com.stocktracker.stock_market_tracker.entity.Watchlist;

public interface WatchlistService {
    Watchlist addToWatchlist(Integer userId, Integer stockId);

    void removeFromWatchlist(Integer watchlistId);

    List<Watchlist> getUserWatchlist(Integer userId);

    int getWatchlistCount(Integer userId);

    List<Watchlist> getAllWatchlists();

	Watchlist createWatchlist(Integer userId, Integer stockId);

	Optional<Watchlist> getWatchlistById(Integer id);

	void deleteWatchlist(Integer id);
}

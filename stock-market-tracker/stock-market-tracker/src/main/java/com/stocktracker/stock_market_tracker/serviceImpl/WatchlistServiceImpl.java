package com.stocktracker.stock_market_tracker.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stocktracker.stock_market_tracker.entity.StocksData;
import com.stocktracker.stock_market_tracker.entity.UsersData;
import com.stocktracker.stock_market_tracker.entity.Watchlist;
import com.stocktracker.stock_market_tracker.repo.StockRepository;
import com.stocktracker.stock_market_tracker.repo.UserRepository;
import com.stocktracker.stock_market_tracker.repo.WatchlistRepository;
import com.stocktracker.stock_market_tracker.service.WatchlistService;

@Service
public class WatchlistServiceImpl implements WatchlistService {
    private final WatchlistRepository watchlistRepository;
    private final UserRepository userRepository;
    private final StockRepository stockRepository;

    public WatchlistServiceImpl(WatchlistRepository watchlistRepository,
            UserRepository userRepository,
            StockRepository stockRepository) {
        this.watchlistRepository = watchlistRepository;
        this.userRepository = userRepository;
        this.stockRepository = stockRepository;
    }

    // Add stock to user's watchlist
    public Watchlist addToWatchlist(Integer userId, Integer stockId) {
        UsersData user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        StocksData stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new IllegalArgumentException("Stock not found"));

        if (watchlistRepository.existsByUsersDataAndStocksData(user, stock)) {
            throw new IllegalArgumentException("Stock already in watchlist");
        }

        Watchlist watchlist = new Watchlist();
        watchlist.setUsersData(user);
        watchlist.setStocksData(stock);

        return watchlistRepository.save(watchlist);
    }

    // Remove stock from watchlist
    public void removeFromWatchlist(Integer userId, Integer stockId) {
        UsersData user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        StocksData stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new IllegalArgumentException("Stock not found"));

        watchlistRepository.deleteByUsersDataAndStocksData(user, stock);
    }

    @Override
    public List<Watchlist> getUserWatchlist(Integer userId) {
        UsersData user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return watchlistRepository.findByUsersData(user);
    }

    @Override
    public int getWatchlistCount(Integer userId) {
        UsersData user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return (int) watchlistRepository.countByUsersData(user);
    }

    @Override
    public List<Watchlist> getAllWatchlists() {
        return watchlistRepository.findAll();
    }

    @Override
    public void removeFromWatchlist(Integer watchlistId) {
        watchlistRepository.deleteById(watchlistId);
    }

	@Override
	public Watchlist createWatchlist(Integer userId, Integer stockId) {
		return addToWatchlist(userId, stockId);
	}

	@Override
	public Optional<Watchlist> getWatchlistById(Integer id) {
		return watchlistRepository.findById(id);
	}

	@Override
	public void deleteWatchlist(Integer id) {
		watchlistRepository.deleteById(id);
	}
}

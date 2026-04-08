package com.stocktracker.stock_market_tracker.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktracker.stock_market_tracker.entity.StocksData;
import com.stocktracker.stock_market_tracker.entity.UsersData;
import com.stocktracker.stock_market_tracker.entity.Watchlist;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {
    // Find all stocks in a user's watchlist
    List<Watchlist> findByUsersData(UsersData usersData);

    // Find all users watching a stock
    List<Watchlist> findByStocksData(StocksData stocksData);

    // Check if user is watching a stock
    boolean existsByUsersDataAndStocksData(UsersData usersData, StocksData stocksData);

    // Remove stock from user's watchlist
    void deleteByUsersDataAndStocksData(UsersData usersData, StocksData stocksData);

    // Get count of stocks user is watching
    long countByUsersData(UsersData usersData);
}

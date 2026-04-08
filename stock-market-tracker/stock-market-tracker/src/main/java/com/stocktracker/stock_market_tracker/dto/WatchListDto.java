package com.stocktracker.stock_market_tracker.dto;

import java.time.LocalDateTime;

import com.stocktracker.stock_market_tracker.entity.StocksData;
import com.stocktracker.stock_market_tracker.entity.UsersData;

public class WatchListDto {
	
	private Integer watchlistPk;
	private LocalDateTime lastUpdated;
	private StocksData stocksData;
	private UsersData usersData;
	
	/**
	 * @return the watchlistPk
	 */
	public Integer getWatchlistPk() {
		return watchlistPk;
	}
	/**
	 * @param watchlistPk the watchlistPk to set
	 */
	public void setWatchlistPk(Integer watchlistPk) {
		this.watchlistPk = watchlistPk;
	}
	/**
	 * @return the lastUpdated
	 */
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	/**
	 * @return the stocksData
	 */
	public StocksData getStocksData() {
		return stocksData;
	}
	/**
	 * @param stocksData the stocksData to set
	 */
	public void setStocksData(StocksData stocksData) {
		this.stocksData = stocksData;
	}
	/**
	 * @return the usersData
	 */
	public UsersData getUsersData() {
		return usersData;
	}
	/**
	 * @param usersData the usersData to set
	 */
	public void setUsersData(UsersData usersData) {
		this.usersData = usersData;
	}
	
}

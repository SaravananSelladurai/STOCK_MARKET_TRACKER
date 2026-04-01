package com.stocktracker.stock_market_tracker.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;


/**
 * The persistent class for the watchlist database table.
 * 
 */
@Entity
@NamedQuery(name="Watchlist.findAll", query="SELECT w FROM Watchlist w")
public class Watchlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="watchlist_pk")
	private Integer watchlistPk;

	@Column(name="last_updated")
	private Timestamp lastUpdated;

	private String status;

	//bi-directional many-to-one association to StocksData
	@ManyToOne
	@JoinColumn(name="stock_fk")
	private StocksData stocksData;

	//bi-directional many-to-one association to UsersData
	@ManyToOne
	@JoinColumn(name="user_fk")
	private UsersData usersData;

	public Watchlist() {
	}

	public Integer getWatchlistPk() {
		return this.watchlistPk;
	}

	public void setWatchlistPk(Integer watchlistPk) {
		this.watchlistPk = watchlistPk;
	}

	public Timestamp getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StocksData getStocksData() {
		return this.stocksData;
	}

	public void setStocksData(StocksData stocksData) {
		this.stocksData = stocksData;
	}

	public UsersData getUsersData() {
		return this.usersData;
	}

	public void setUsersData(UsersData usersData) {
		this.usersData = usersData;
	}

}
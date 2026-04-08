package com.stocktracker.stock_market_tracker.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the stocks_data database table.
 * 
 */
@Entity
@Table(name="stocks_data")
@NamedQuery(name="StocksData.findAll", query="SELECT s FROM StocksData s")
public class StocksData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="stock_pk")
	private Integer stockPk;

	@Column(name="company_name")
	private String companyName;

	@Column(name="current_price")
	private Integer currentPrice;

	@Column(name="high_price")
	private Integer highPrice;

	@Column(name="last_updated")
	private Timestamp lastUpdated;

	@Column(name="low_price")
	private Integer lowPrice;

	@Column(name="open_price")
	private Integer openPrice;

	private String status;

	private String symbol;

	//bi-directional many-to-one association to Watchlist
	@OneToMany(mappedBy="stocksData")
	private List<Watchlist> watchlists;

	public StocksData() {
	}

	public Integer getStockPk() {
		return this.stockPk;
	}

	public void setStockPk(Integer stockPk) {
		this.stockPk = stockPk;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCurrentPrice() {
		return this.currentPrice;
	}

	public void setCurrentPrice(Integer currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Integer getHighPrice() {
		return this.highPrice;
	}

	public void setHighPrice(Integer highPrice) {
		this.highPrice = highPrice;
	}

	public Timestamp getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Integer getLowPrice() {
		return this.lowPrice;
	}

	public void setLowPrice(Integer lowPrice) {
		this.lowPrice = lowPrice;
	}

	public Integer getOpenPrice() {
		return this.openPrice;
	}

	public void setOpenPrice(Integer openPrice) {
		this.openPrice = openPrice;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public List<Watchlist> getWatchlists() {
		return this.watchlists;
	}

	public void setWatchlists(List<Watchlist> watchlists) {
		this.watchlists = watchlists;
	}

	public Watchlist addWatchlist(Watchlist watchlist) {
		getWatchlists().add(watchlist);
		watchlist.setStocksData(this);

		return watchlist;
	}

	public Watchlist removeWatchlist(Watchlist watchlist) {
		getWatchlists().remove(watchlist);
		watchlist.setStocksData(null);

		return watchlist;
	}

}
package com.stocktracker.stock_market_tracker.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class StockDataDto {
	
	private Integer stockPk;
	private Timestamp lastUpdated;
	private String companyName;
	private BigDecimal lowPrice;
	private BigDecimal highPrice;
	private BigDecimal currentPrice;
	private BigDecimal openPrice;
	private String status;
	private String symbol;
	
	/**
	 * @return the stockPk
	 */
	public Integer getStockPk() {
		return stockPk;
	}
	/**
	 * @param stockPk the stockPk to set
	 */
	public void setStockPk(Integer stockPk) {
		this.stockPk = stockPk;
	}
	/**
	 * @return the lastUpdated
	 */
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	/**
	 * @param lastUpdated the lastUpdated to set
	 */
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the lowPrice
	 */
	public BigDecimal getLowPrice() {
		return lowPrice;
	}
	/**
	 * @param lowPrice the lowPrice to set
	 */
	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}
	/**
	 * @return the highPrice
	 */
	public BigDecimal getHighPrice() {
		return highPrice;
	}
	/**
	 * @param highPrice the highPrice to set
	 */
	public void setHighPrice(BigDecimal highPrice) {
		this.highPrice = highPrice;
	}
	/**
	 * @return the currentPrice
	 */
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}
	/**
	 * @param currentPrice the currentPrice to set
	 */
	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	/**
	 * @return the openPrice
	 */
	public BigDecimal getOpenPrice() {
		return openPrice;
	}
	/**
	 * @param openPrice the openPrice to set
	 */
	public void setOpenPrice(BigDecimal openPrice) {
		this.openPrice = openPrice;
	}
	
}

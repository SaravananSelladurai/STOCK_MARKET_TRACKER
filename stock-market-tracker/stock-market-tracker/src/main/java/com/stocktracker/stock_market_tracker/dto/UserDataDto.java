package com.stocktracker.stock_market_tracker.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.stocktracker.stock_market_tracker.entity.Watchlist;

public class UserDataDto {
	private Integer userPk;
	private LocalDateTime createdAt;
	private String email;
	private String status;
	private String username;
	private String passwordHash;
	private LocalDateTime updatedAt;
	private List<Watchlist> watchlists;
	
	/**
	 * @return the userPk
	 */
	public Integer getUserPk() {
		return userPk;
	}
	/**
	 * @param userPk the userPk to set
	 */
	public void setUserPk(Integer userPk) {
		this.userPk = userPk;
	}
	/**
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @return the passwordHash
	 */
	public String getPasswordHash() {
		return passwordHash;
	}
	/**
	 * @param passwordHash the passwordHash to set
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	/**
	 * @return the updatedAt
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	/**
	 * @return the watchlists
	 */
	public List<Watchlist> getWatchlists() {
		return watchlists;
	}
	/**
	 * @param watchlists the watchlists to set
	 */
	public void setWatchlists(List<Watchlist> watchlists) {
		this.watchlists = watchlists;
	}
}

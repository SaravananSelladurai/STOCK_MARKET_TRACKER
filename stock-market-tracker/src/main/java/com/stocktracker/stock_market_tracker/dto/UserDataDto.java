package com.stocktracker.stock_market_tracker.dto;

import java.sql.Timestamp;

public class UserDataDto {
	private Integer userPk;
	private Timestamp createdAt;
	private String email;
	private String status;
	private String username;
	
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
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Timestamp createdAt) {
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
	
}

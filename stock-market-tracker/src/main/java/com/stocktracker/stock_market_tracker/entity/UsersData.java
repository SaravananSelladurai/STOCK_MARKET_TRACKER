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
 * The persistent class for the users_data database table.
 * 
 */
@Entity
@Table(name="users_data")
@NamedQuery(name="UsersData.findAll", query="SELECT u FROM UsersData u")
public class UsersData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_pk")
	private Integer userPk;
	
	@Column(name="user_id")
	private Integer userId;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String email;

	@Column(name="password_hash")
	private String passwordHash;

	private String status;

	private String username;

	//bi-directional many-to-one association to Watchlist
	@OneToMany(mappedBy="usersData")
	private List<Watchlist> watchlists;

	public UsersData() {
	}

	public Integer getUserPk() {
		return this.userPk;
	}

	public void setUserPk(Integer userPk) {
		this.userPk = userPk;
	}
	
	public Integer getUserId() {
		return this.userPk;
	}

	public void setUserId(Integer userPk) {
		this.userPk = userPk;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Watchlist> getWatchlists() {
		return this.watchlists;
	}

	public void setWatchlists(List<Watchlist> watchlists) {
		this.watchlists = watchlists;
	}

	public Watchlist addWatchlist(Watchlist watchlist) {
		getWatchlists().add(watchlist);
		watchlist.setUsersData(this);

		return watchlist;
	}

	public Watchlist removeWatchlist(Watchlist watchlist) {
		getWatchlists().remove(watchlist);
		watchlist.setUsersData(null);

		return watchlist;
	}

}
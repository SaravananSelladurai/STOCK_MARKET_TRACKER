package com.stocktracker.stock_market_tracker.service;

import java.util.List;
import java.util.Optional;

import com.stocktracker.stock_market_tracker.entity.UsersData;

public interface UserService {
	public UsersData createUser(String username, String email, String passwordHash);

	public Optional<UsersData> getUserByUsername(String username);

	public Optional<UsersData> getUserByEmail(String email);

	public List<UsersData> getAllUsers();

	public Optional<UsersData> getUserById(Integer id);

	public void deleteUser(Integer id);

	public UsersData updateUserEmail(Integer id, String newEmail);
}

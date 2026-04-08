package com.stocktracker.stock_market_tracker.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stocktracker.stock_market_tracker.entity.UsersData;
import com.stocktracker.stock_market_tracker.repo.UserRepository;
import com.stocktracker.stock_market_tracker.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	// Create a new user
	public UsersData createUser(String username, String email, String passwordHash) {
		if (userRepository.existsByUsername(username)) {
			throw new IllegalArgumentException("Username already exists");
		}
		if (userRepository.existsByEmail(email)) {
			throw new IllegalArgumentException("Email already exists");
		}

		UsersData user = new UsersData();
		user.setUsername(username);
		user.setEmail(email);
		user.setPasswordHash(passwordHash);
		return userRepository.save(user);
	}
	
	// Get user by username
    public Optional<UsersData> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    // Get user by email
    public Optional<UsersData> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // Get all users
    public List<UsersData> getAllUsers() {
        return userRepository.findAll();
    }
    
    // Get user by ID
    public Optional<UsersData> getUserById(Integer id) {
        return userRepository.findById(id);
    }
    
    // Delete user
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
    
    // Update user email
    public UsersData updateUserEmail(Integer id, String newEmail) {
    	UsersData user = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
        
        if (userRepository.existsByEmail(newEmail) && !user.getEmail().equals(newEmail)) {
            throw new IllegalArgumentException("Email already in use");
        }
        
        user.setEmail(newEmail);
        return userRepository.save(user);
    }
}

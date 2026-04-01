package com.stocktracker.stock_market_tracker.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktracker.stock_market_tracker.dto.UserDataDto;

@Repository
public interface UserRepository extends JpaRepository<UserDataDto, Integer>{
	 // Find user by username
    Optional<UserDataDto> findByUsername(String username);
    
    // Find user by email
    Optional<UserDataDto> findByEmail(String email);
    
    // Check if username exists
    boolean existsByUsername(String username);
    
    // Check if email exists
    boolean existsByEmail(String email);
}

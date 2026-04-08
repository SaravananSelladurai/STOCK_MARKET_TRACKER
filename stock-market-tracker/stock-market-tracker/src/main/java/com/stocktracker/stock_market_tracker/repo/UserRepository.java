package com.stocktracker.stock_market_tracker.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stocktracker.stock_market_tracker.entity.UsersData;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UsersData, Integer>{
	 // Find user by username
    Optional<UsersData> findByUsername(String username);
    
 // Find user by userpk
    // findById is inherited from JpaRepository
    
    // Find user by email
    Optional<UsersData> findByEmail(String email);
    
    // Check if username exists
    boolean existsByUsername(String username);
    
    // Check if email exists
    boolean existsByEmail(String email);
}

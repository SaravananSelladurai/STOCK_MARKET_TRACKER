package com.stocktracker.stock_market_tracker.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stocktracker.stock_market_tracker.entity.UsersData;
import com.stocktracker.stock_market_tracker.exception.DuplicateResourceException;
import com.stocktracker.stock_market_tracker.exception.ResourceNotFoundException;
import com.stocktracker.stock_market_tracker.requestdto.UserRequestDto;
import com.stocktracker.stock_market_tracker.responsedto.UserResponseDto;
import com.stocktracker.stock_market_tracker.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto request) {
        try {
            UsersData user = userService.createUser(
                request.getUsername(),
                request.getEmail(),
                request.getPassword()
            );
            return new ResponseEntity<>(
                convertToResponse(user),
                HttpStatus.CREATED
            );
        } catch (IllegalArgumentException e) {
            throw new DuplicateResourceException(e.getMessage());
        }
    }
    
 // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Integer id) {
        UsersData user = userService.getUserById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return ResponseEntity.ok(convertToResponse(user));
    }
    
    // Get user by username
    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponseDto> getUserByUsername(@PathVariable String username) {
    	UsersData user = userService.getUserByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
        return ResponseEntity.ok(convertToResponse(user));
    }
    
    // Get all users
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UsersData> users = userService.getAllUsers();
        List<UserResponseDto> responses = users.stream()
            .map(this::convertToResponse)
            .toList();
        return ResponseEntity.ok(responses);
    }
    
    // Update user email
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Integer id,
            @Valid @RequestBody UserRequestDto request) {
        try {
        	UsersData user = userService.updateUserEmail(id, request.getEmail());
            return ResponseEntity.ok(convertToResponse(user));
        } catch (IllegalArgumentException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
    
    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        if (!userService.getUserById(id).isPresent()) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
    // Helper method to convert Entity to DTO
    private UserResponseDto convertToResponse(UsersData user) {
    	return new UserResponseDto.Builder()
    			.id(user.getUserPk())
    			.username(user.getUsername())
    			.email(user.getEmail())
    			.createdAt(user.getCreatedAt() != null ? user.getCreatedAt().toLocalDateTime() : null)
    			.updatedAt(user.getCreatedAt() != null ? user.getCreatedAt().toLocalDateTime() : null)
    			.watchlistCount(user.getWatchlists() != null ? user.getWatchlists().size() : 0)
    			.build();
    }
    
}

package com.fitness.userservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String email;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private UserRole role = UserRole.USER;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	
	

}

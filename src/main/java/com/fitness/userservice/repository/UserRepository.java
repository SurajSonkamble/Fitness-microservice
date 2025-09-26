package com.fitness.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.userservice.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	Boolean existsByEmail(String email);

}

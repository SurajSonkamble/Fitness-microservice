package com.fitness.userservice.service;

import org.springframework.stereotype.Service;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	/**
	 * @param request
	 * @return
	 */
	public UserResponse register(RegisterRequest request) {

		if (userRepository.existsByEmail(request.getEmail())) {

			throw new RuntimeException("Email Aready Exist");

		}

		User user = new User();

		user.setEmail(request.getEmail());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setPassword(request.getPassword());

		User savedUser = userRepository.save(user);

		UserResponse userResponse = new UserResponse();

		userResponse.setId(savedUser.getId());
		userResponse.setEmail(savedUser.getEmail());
		userResponse.setPassword(savedUser.getPassword());
		userResponse.setFirstName(savedUser.getFirstName());
		userResponse.setLastName(savedUser.getLastName());
		userResponse.setCreatedAt(savedUser.getCreatedAt());
		userResponse.setUpdatedAt(savedUser.getUpdatedAt());

		return userResponse;

	}

	public UserResponse getUserProfile(String userId) {

		User user = userRepository.findById(userId).orElseThrow((() -> new RuntimeException("Id does not existed")));

		UserResponse userResponse = new UserResponse();

		userResponse.setId(user.getId());
		userResponse.setEmail(user.getEmail());
		userResponse.setFirstName(user.getFirstName());
		userResponse.setLastName(user.getLastName());
		userResponse.setCreatedAt(user.getCreatedAt());
		userResponse.setUpdatedAt(user.getUpdatedAt());

		return userResponse;
	}

}

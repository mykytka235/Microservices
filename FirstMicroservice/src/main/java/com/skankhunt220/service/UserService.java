package com.skankhunt220.service;

import org.springframework.stereotype.Service;

import com.skankhunt220.client.SecondServiceClient;
import com.skankhunt220.entity.User;
import com.skankhunt220.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final SecondServiceClient client;

	public User create(User user) {
		User userFromSecondService = client.create(user);
		return userRepository.updateUserFirstName(userFromSecondService.getId(), user.getFirstName());
	}

	public User read(String userId) {
		return userRepository.findById(userId).get();
	}

	public User update(String id, User user) {
		userRepository.updateUserFirstName(id, user.getFirstName());
		client.update(id, user);
		return  userRepository.findById(id).get();
	}

	public void delete(String userId) {
		userRepository.deleteById(userId);
	}
}
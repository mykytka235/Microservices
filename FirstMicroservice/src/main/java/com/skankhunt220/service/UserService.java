package com.skankhunt220.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skankhunt220.entity.User;
import com.skankhunt220.repository.user.UserRepository;
import com.skankhunt220.services.second.client.SecondServiceClient;
import com.skankhunt220.services.second.dto.SecondServiceDto;
import com.skankhunt220.services.second.transformer.SecondServiceTransformer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final SecondServiceClient client;

	public User create(User user) {
		SecondServiceDto userFromSecondService = client.create(SecondServiceTransformer.transformIntoSecondServiceDto(user));
		return userRepository.updateUserFirstName(userFromSecondService.getId(), user.getFirstName());
	}

	public User read(String userId) {
		return userRepository.findById(userId).get();
	}
	
	public List<User> getAllUsers() {
	    return userRepository.findAll();
	}

	public User update(String id, User user) {
		userRepository.updateUserFirstName(id, user.getFirstName());
		client.update(id, SecondServiceTransformer.transformIntoSecondServiceDto(user));
		return  userRepository.findById(id).get();
	}

	public void delete(String userId) {
		userRepository.deleteById(userId);
	}
}
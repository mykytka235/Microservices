
package com.skankhunt220.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.skankhunt220.entity.User;
import com.skankhunt220.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final WebClient webClient;

	public User create(User user) {
		User fromThirdService = webClient.post()
										 .uri("/api/users")
										 .body(Mono.just(user), User.class)
										 .retrieve()
										 .bodyToMono(User.class).block();
		
		
		return userRepository.updateUserMiddleName(fromThirdService.getId(), user.getMiddleName());
	}

	public User update(String id, User user) {
		webClient.put()
				.uri("/api/users/" + id)
				.body(Mono.just(user), User.class)
				.retrieve()
				.bodyToMono(User.class).block();

		return userRepository.updateUserMiddleName(id, user.getMiddleName());
	}
}
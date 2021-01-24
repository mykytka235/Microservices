package com.skankhunt220.api.controller;

import static com.skankhunt220.api.transformer.Transformer.transform;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.skankhunt220.api.Dto.UserDto;
import com.skankhunt220.service.UserService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService; 	
	private final WebClient webClient = WebClient.create("http://third-service:8083");
	
	@PostMapping
	public UserDto create(@RequestBody UserDto userDto) {		
		UserDto fromThirdService = webClient.post()
								.uri("/api/users")
								.body(Mono.just(userDto), UserDto.class)
								.retrieve()
								.bodyToMono(UserDto.class).block();
											
		fromThirdService.setMiddleName(userDto.getMiddleName());		
		return transform(userService.update(transform(fromThirdService, fromThirdService.getId())), fromThirdService.getId());
	}
	
	@GetMapping("/{id}")
	public UserDto read(@PathVariable("id") String id) {
		return transform(userService.read(id), id);
	}

	@PutMapping("/{id}")
	public UserDto update(@PathVariable("id") String id, @RequestBody UserDto userDto) {		
		UserDto fromThirdService = webClient.put()
				.uri("/api/users/" + id)
				.body(Mono.just(userDto), UserDto.class)
				.retrieve()
				.bodyToMono(UserDto.class).block();
		
		fromThirdService.setMiddleName(userDto.getMiddleName());
		return transform(userService.update(transform(fromThirdService, id)), id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		userService.delete(id);
	}
}
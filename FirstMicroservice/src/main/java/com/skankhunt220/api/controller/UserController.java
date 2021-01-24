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

import com.skankhunt220.api.Dto.UserDto;
import com.skankhunt220.client.FirstFeignClient;
import com.skankhunt220.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	private final FirstFeignClient client;
	

	@PostMapping
	public UserDto create(@RequestBody UserDto userDto) {
		UserDto fromSecondService = client.createUser(userDto);
		fromSecondService.setFirstName(userDto.getFirstName());
		return transform(userService.update(transform(fromSecondService, fromSecondService.getId())),
				fromSecondService.getId());
	}

	@GetMapping("/{id}")
	public UserDto read(@PathVariable("id") String id) {
		return transform(userService.read(id), id);
	}

	@PutMapping("/{id}")
	public UserDto update(@PathVariable("id") String id, @RequestBody UserDto userDto) {
		UserDto fromSecondService = client.update(id, userDto);
		fromSecondService.setFirstName(userDto.getFirstName());
		return transform(userService.update(transform(fromSecondService, id)), id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		userService.delete(id);
	}
}

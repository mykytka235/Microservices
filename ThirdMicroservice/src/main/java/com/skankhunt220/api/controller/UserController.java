package com.skankhunt220.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skankhunt220.entity.User;
import com.skankhunt220.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@PostMapping
	public User create(@RequestBody User user) {						
	    return userService.create(user);
	}
	@PutMapping("/{id}")
	public User update(@PathVariable("id") String id, @RequestBody User user) {						
	    return userService.update(id, user);
	}
}
package com.skankhunt220.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.skankhunt220.api.Dto.UserDto;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface FirstFeignClient {
	@PostMapping("/api/users")
	public UserDto createUser(@RequestBody UserDto userDto);
	@PutMapping("/api/users/{id}")
	public UserDto update(@PathVariable("id") String id, @RequestBody UserDto userDto);
}
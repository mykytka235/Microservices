package com.skankhunt220.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.skankhunt220.entity.User;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface SecondServiceClient {
	@PostMapping("/api/users")
	public User create(@RequestBody User user);
	@PutMapping("/api/users/{id}")
	public User update(@PathVariable("id") String id, @RequestBody User user);
}
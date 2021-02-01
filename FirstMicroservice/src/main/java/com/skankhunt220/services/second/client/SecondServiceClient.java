package com.skankhunt220.services.second.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.skankhunt220.services.second.dto.SecondServiceDto;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface SecondServiceClient {
    @PostMapping("/api/users")
    public SecondServiceDto create(@RequestBody SecondServiceDto user);

    @PutMapping("/api/users/{id}")
    public SecondServiceDto update(@PathVariable("id") String id, @RequestBody SecondServiceDto user);
}
package com.skankhunt220.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skankhunt220.api.Dto.CurrentServiceUserDto;
import com.skankhunt220.api.transformer.UserTransformer;
import com.skankhunt220.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    
    @PostMapping
    public CurrentServiceUserDto create(@RequestBody CurrentServiceUserDto dto) {
        return UserTransformer.transformIntoCurrenServiceDto(userService.create(UserTransformer.transformIntoUser(dto)));
    }

    @PutMapping("/{id}")
    public CurrentServiceUserDto update(@PathVariable("id") String id, @RequestBody CurrentServiceUserDto dto) {
        return UserTransformer.transformIntoCurrenServiceDto(userService.update(id, UserTransformer.transformIntoUser(dto)));
    }
}
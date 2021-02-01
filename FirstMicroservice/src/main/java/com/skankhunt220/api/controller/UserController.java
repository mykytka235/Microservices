package com.skankhunt220.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skankhunt220.api.Dto.CurrentServiceUserDto;
import com.skankhunt220.api.transformer.FirstServiceTransformer;
import com.skankhunt220.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public CurrentServiceUserDto create(@RequestBody CurrentServiceUserDto userDto) {
        return FirstServiceTransformer
                .transformIntoCurrentServiceDto((userService.create(FirstServiceTransformer.transformIntoUser(userDto))));
    }

    @GetMapping("/{id}")
    public CurrentServiceUserDto read(@PathVariable("id") String id) {
        return FirstServiceTransformer.transformIntoCurrentServiceDto(userService.read(id));
    }

    @PutMapping("/{id}")
    public CurrentServiceUserDto update(@PathVariable("id") String id, @RequestBody CurrentServiceUserDto userDto) {
        return FirstServiceTransformer.transformIntoCurrentServiceDto(userService.update(id, FirstServiceTransformer.transformIntoUser((userDto))));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        userService.delete(id);
    }
    
    @GetMapping("/allUsers")
    public List<CurrentServiceUserDto> getAllUsers(){
        List<CurrentServiceUserDto> listDto = new ArrayList<CurrentServiceUserDto>();
        userService.getAllUsers().forEach((user) -> {
            listDto.add(FirstServiceTransformer.transformIntoCurrentServiceDto(user));
        });       
        
        return listDto;
    }
}
package com.example.creditscoring.controller;

import com.example.creditscoring.dto.user.RegisterDto;
import com.example.creditscoring.exception.UserAlreadyExistsException;
import com.example.creditscoring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    private ResponseEntity<String> registerUser(@RequestBody RegisterDto dto){
        try{
            userService.register(dto);
            return new ResponseEntity<>("You are registered successfully!", HttpStatus.OK);
        }catch(UserAlreadyExistsException e){
            return new ResponseEntity<>("User already exists with such data", HttpStatus.BAD_REQUEST);
        }
    }
}

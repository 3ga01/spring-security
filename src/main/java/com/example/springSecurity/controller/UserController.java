package com.example.springSecurity.controller;

import com.example.springSecurity.dto.UserDto;
import com.example.springSecurity.model.User;
import com.example.springSecurity.repository.UserRepository;
import com.example.springSecurity.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequiredArgsConstructor

public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;


    @GetMapping("/login")
    public ModelAndView getLogin() {
        return new ModelAndView("login");
    }

    @GetMapping("/welcome")
    public String homepage() {
        return "welcome";
    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/fail")
    public String fail() {
        return "login failed";
    }

    @GetMapping("/user/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (!users.isEmpty()) return new ResponseEntity<>(users, HttpStatus.OK);
        return new ResponseEntity<>("No users available", HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {

        return userService.createUser(userDto);
    }
}

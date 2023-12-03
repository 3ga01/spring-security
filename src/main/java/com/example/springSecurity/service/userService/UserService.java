package com.example.springSecurity.service.userService;

import com.example.springSecurity.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
     ResponseEntity<?> createUser(UserDto userDto);
}

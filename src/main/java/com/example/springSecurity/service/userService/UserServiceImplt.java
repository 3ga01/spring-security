package com.example.springSecurity.service.userService;

import com.example.springSecurity.dto.UserDto;
import com.example.springSecurity.model.User;
import com.example.springSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplt implements UserService{

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> createUser(UserDto userDto) {
        ResponseEntity<?> result;
        try {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setEmail(userDto.getEmail());
            user.setRoles(userDto.getRoles());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userRepository.save(user);
            result = new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            result = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return result;
    }
}

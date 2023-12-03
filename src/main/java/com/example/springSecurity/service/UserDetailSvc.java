package com.example.springSecurity.service;

import com.example.springSecurity.model.User;
import com.example.springSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailSvc implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userDetail = userRepository.findByEmail(email);

       return userDetail.map(UserInfoDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


}

package com.example.springSecurity.service;

import com.example.springSecurity.model.User;
import com.example.springSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.Optional;

public class UserDetailSvc implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userDetail = userRepository.findByEmail(email);

       return userDetail.map(UserInfoDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


}

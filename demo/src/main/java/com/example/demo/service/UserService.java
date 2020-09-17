package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.payload.RegisterRequest;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Register User
     * */
    public Optional<User> register(RegisterRequest request) {

        User user = userRepository.save(
                new User()
                        .builder()
                        .email(request.getEmail())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .build());

        return Optional.of(user);
    }
}

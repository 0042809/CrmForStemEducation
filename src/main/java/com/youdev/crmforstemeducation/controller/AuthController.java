package com.youdev.crmforstemeducation.controller;

import com.youdev.crmforstemeducation.model.User;
import com.youdev.crmforstemeducation.repository.UserRepository;
import com.youdev.crmforstemeducation.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        // Username unique ligini tekshirish
        if (userRepository.findByUsername(registrationDto.getUsername()) != null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Username already exists");
        }

        // Parol validatsiyasi
        if (registrationDto.getPassword().length() < 8) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Password must be at least 8 characters");
        }

        // DTO dan modelga o'tkazish
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRole(registrationDto.getRole() != null ? registrationDto.getRole() : "STUDENT");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userRepository.save(user));
    }
}
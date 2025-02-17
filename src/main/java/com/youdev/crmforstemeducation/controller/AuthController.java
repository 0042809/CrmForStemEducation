package com.youdev.crmforstemeducation.controller;

import com.youdev.crmforstemeducation.dto.AuthResponseDto;
import com.youdev.crmforstemeducation.dto.LoginDto;
import com.youdev.crmforstemeducation.dto.UserRegistrationDTO;
import com.youdev.crmforstemeducation.model.User;
import com.youdev.crmforstemeducation.repository.UserRepository;
import com.youdev.crmforstemeducation.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        // Username unique ligini tekshirish
        if (userRepository.findByUsername(registrationDto.getUsername()) != null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Username already exists");
        }

        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRole(registrationDto.getRole() != null ? registrationDto.getRole() : "STUDENT");

        User savedUser = userRepository.save(user);

        // JWT token yaratish
        String token = jwtService.generateToken(savedUser.getUsername());

        return ResponseEntity.ok(new AuthResponseDto(token));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername(),
                            loginDto.getPassword()
                    )
            );

            String token = jwtService.generateToken(loginDto.getUsername());
            return ResponseEntity.ok(new AuthResponseDto(token));

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
    }
}

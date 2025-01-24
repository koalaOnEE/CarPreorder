package com.bmw;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.bmw.DTO.UserDTO;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        // Check if the email is already registered
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("Email is already registered!");
        }

        // Hash the password and save the user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }

    // Login a user
    @GetMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
        // Find user by email
        Optional<User> user = userRepository.findByEmail(email);

        // Validate email and password
        if (user.isEmpty() || !passwordEncoder.matches(password, user.get().getPassword())) {
            return ResponseEntity.status(401).body("Invalid email or password!");
        }

        // Return user info without sensitive data
        UserDTO userDTO = new UserDTO(user.get().getEmail(), user.get().getName());
        return ResponseEntity.ok(userDTO);
    }
}

package com.bmw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users") // Base path for user-related endpoints
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Register a new user.
     * 
     * @param user The user object from the request body.
     * @return A response indicating success or failure.
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Check if the email already exists
        Optional<User> existingUser = userRepository.findByEmail(user.email());
        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("Email is already registered!");
        }
        userRepository.save(user); // Save the new user to the database
        return ResponseEntity.ok("User registered successfully!");
    }

    /**
     * User login.
     * 
     * @param email    The user's email from the request parameter.
     * @param password The user's password from the request parameter.
     * @return A response with user details if login is successful.
     */
    @GetMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
        // Find the user by email
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty() || !user.get().password().equals(password)) {
            return ResponseEntity.status(401).body("Invalid email or password!");
        }
        return ResponseEntity.ok(user.get()); // Return user details on successful login
    }

    /**
     * Get user details by ID.
     * 
     * @param userID The user ID from the path variable.
     * @return A response with user details or an error message if not found.
     */
    @GetMapping("/{userID}")
    public ResponseEntity<?> getUserById(@PathVariable Integer userID) {
        Optional<User> user = userRepository.findById(userID);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404 if user not found
        }
        return ResponseEntity.ok(user.get());
    }
}


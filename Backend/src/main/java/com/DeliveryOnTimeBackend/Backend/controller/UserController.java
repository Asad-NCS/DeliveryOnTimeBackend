

package com.DeliveryOnTimeBackend.Backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.DeliveryOnTimeBackend.Backend.repository.UserRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.DeliveryOnTimeBackend.Backend.model.User;


@RestController
@RequestMapping("/api/user")
public class UserController {

@Autowired
private UserRepository userRepository;

@GetMapping
public List<User> getAllUsers(){
    return userRepository.findAll();
}

@PostMapping("/addUser")
public User addUser(@RequestBody User user){
    return userRepository.save(user);
}

   @PostMapping("/signUp")
   ResponseEntity<?> signUp(@RequestBody User user){

    if(userRepository.findByEmail(user.getEmail()).isPresent()){
        return ResponseEntity.badRequest().body(("Email is already in Use"));
    }

    userRepository.save(user);
    return ResponseEntity.ok("User Has been regestered");


}

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(401).body("User not found");
        }

        User user = userOpt.get();

        if (!user.getPassword().equals(password)) {
            return ResponseEntity.status(401).body("Incorrect password");
        }

        return ResponseEntity.ok(true);
    }



}

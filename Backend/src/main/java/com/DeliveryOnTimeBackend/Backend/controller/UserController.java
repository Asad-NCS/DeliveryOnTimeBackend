

package com.DeliveryOnTimeBackend.Backend.controller;

import org.springframework.web.bind.annotation.RestController;
import com.DeliveryOnTimeBackend.Backend.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.DeliveryOnTimeBackend.Backend.model.User;


@RestController
@RequestMapping("/api/User")
public class UserController {

@Autowired
private UserRepository userRepository;

@GetMapping
public List<User> getAllUsers(){
    return userRepository.findAll();
}

@PostMapping
public User addUser(@RequestBody User User){
    return userRepository.save(User);

}


}

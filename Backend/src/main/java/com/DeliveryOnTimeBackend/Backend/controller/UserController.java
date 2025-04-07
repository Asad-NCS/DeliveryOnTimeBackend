

package com.DeliveryOnTimeBackend.Backend.controller;

import org.springframework.web.bind.annotation.RestController;
import com.DeliveryOnTimeBackend.Backend.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.DeliveryOnTimeBackend.Backend.model.user;


@RestController
@RequestMapping("/api/user")
public class UserController {

@Autowired
private UserRepository userRepository;

@GetMapping
public List<user> getAllUsers(){
    return userRepository.findAll();
}

@PostMapping
public user addUser(@RequestBody user User){
    return userRepository.save(User);

}


}

package com.showmaster.show_master.controller;

import com.showmaster.show_master.model.User;
import com.showmaster.show_master.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @GetMapping("/users/{username}")
     public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
         Optional<User> userOptional = userService.findByUsername(username);
         if (userOptional.isPresent()) {
             return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
         } else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
        }
}

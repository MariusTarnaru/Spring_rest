package sda.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.spring.rest.model.User;
import sda.spring.rest.service.UserService;
import sda.spring.rest.service.exception.EmailAlreadyUsedException;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<User> getAllUsers() {
        return ResponseEntity.ok().body(new User()
                .setId(1L)
                .setEmail("valeriu.moise@gmail.com")
                .setName("Valeriu"));
    }

    @PostMapping("/users")
    public ResponseEntity saveUser(@RequestBody User user) {
        User savedUser = null;
        try {
            savedUser = userService.save(user);
        } catch (EmailAlreadyUsedException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("error details", e.getMessage()));
        }
        return ResponseEntity.ok().body(savedUser);
//        return userService.save(user);
    }


}

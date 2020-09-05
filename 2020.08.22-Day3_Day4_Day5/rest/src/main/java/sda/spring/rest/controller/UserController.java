package sda.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import sda.spring.rest.controller.dto.UserStatus;
import sda.spring.rest.controller.dto.UserWrapper;
import sda.spring.rest.model.User;
import sda.spring.rest.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public ResponseEntity saveUser(@RequestBody User user, UriComponentsBuilder b) {
        User savedUser = userService.save(user);

        UriComponents uriComponents =
                b.path("/users/{id}").buildAndExpand(savedUser.getId());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new UserWrapper()
                        .setUser(user)
                        .setUri("DSAUBDISAUBDISABIDSAUDNAS"));
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long userId) {
        return userService.findById(userId);
    }

    @PatchMapping("/users/{id}")
    public User updateStatus(@PathVariable("id") Long userId,
                             @RequestBody @Valid UserStatus userStatus) {
        return userService.updateStatus(userId, userStatus.getStatus());
    }

}

package sda.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sda.spring.rest.controller.dto.UserStatus;
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
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
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

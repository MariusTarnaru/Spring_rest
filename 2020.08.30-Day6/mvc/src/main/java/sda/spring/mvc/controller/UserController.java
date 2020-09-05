package sda.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sda.spring.mvc.service.UserService;
import sda.spring.mvc.service.dto.UserDTO;

import javax.validation.Valid;
import java.util.List;


/**
 * Paths:
 * "/"
 * "/signup"
 * "/adduser"
 * "/edit/{id}"
 * "/update/{id}"
 * "/delete/{id}"
 */
@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String listAll(Model model) {
        List<UserDTO> users = userService.getAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/signup")
    public String signup(UserDTO user){
        return "user-add";
    }

    @PostMapping(path = "/adduser")
    public String addUser(@Valid UserDTO user, BindingResult result, Model model){
        if (result.hasErrors()){
            return "user-add";
        }
        userService.save(user);
        model.addAttribute("users", userService.getAll());
        return "index";
    }

}

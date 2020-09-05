package sda.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
 * "/edit/{id}" -- GET
 * "/update/{id}" -- POST/PUT
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
    public String signup(UserDTO user) {
        return "user-add";
    }

    @PostMapping(path = "/adduser")
    public String addUser(@Valid UserDTO user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user-add";
        }
        userService.save(user);
        model.addAttribute("users", userService.getAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long userId, Model model) {
        model.addAttribute("user", userService.findById(userId));
        return "user-edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long userId, @ModelAttribute("user") @Valid UserDTO user,
                         Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "user-edit";
        }

        userService.update(user.setId(userId));

        model.addAttribute("users", userService.getAll());

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long userId, Model model) {
        userService.deleteById(userId);
        model.addAttribute("users", userService.getAll());
        return "redirect:/";
    }

}

package org.example.mvcspringboot.controller;
import lombok.RequiredArgsConstructor;
import org.example.mvcspringboot.entity.User;
import org.example.mvcspringboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping
    public String listUsers(ModelMap modelMap) {
        List<User> userList = userService.findAll();
        modelMap.addAttribute("userList", userList);
        return "user_list";
    }

    @GetMapping("/users/add")
    public String showAddUserForm() {
        return "user_form";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditUserForm(@PathVariable int id, ModelMap modelMap) {
        Optional<User> userById = userService.findById(id);
        userById.ifPresent(user -> modelMap.addAttribute("user", user));
        return "user_form_edit";
    }

    @PostMapping("/users/edit")
    public String editUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable int id) {
         userService.deleteById(id);
        return "redirect:/";
    }
}
	

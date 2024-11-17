package com.example.its.web;

import com.example.its.domain.auth.UserService;
import com.example.its.web.user.UserForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserService userService;

    @GetMapping
    public String index() {
        return "index";
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    @GetMapping("/logout")
    public String showLogoutForm() {
        return "logout";
    }
    @PostMapping("/signin")
    public String processLoginForm(@ModelAttribute UserForm userForm) {
        userService.create(userForm.getUsername(), userForm.getPassword(), userForm.getAuthority());
        return "redirect:/index";
    }
}

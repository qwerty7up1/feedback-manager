package com.project.controller;

import com.project.UserService;
import com.project.view.RegistrationForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@Validated @Valid RegistrationForm form) {
        userService.registerUser(form);
        return "redirect:/profile";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}

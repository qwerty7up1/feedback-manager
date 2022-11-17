package com.project.controller;

import com.project.LoggedUser;
import com.project.UserService;
import com.project.view.UserView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoggedUser loggedUser;

    @GetMapping("/admin")
    public String admin(Model model) {
        long id = loggedUser.getLoggedUser().getId();
        UserView userView = userService.getUser(id);
        model.addAttribute("user", userView);
        return "admin";
    }
}

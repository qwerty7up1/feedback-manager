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
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoggedUser loggedUser;

    @GetMapping("/profile")
    public String profile(Model model) {
        long id = loggedUser.getLoggedUser().getId();
        UserView userView = userService.getUser(id);
        model.addAttribute("user", userView);
        return "profile";
    }

    @PostMapping("/profile/new-message")
    public String addMessage(@ModelAttribute("text") String text, Model model) {
        long accountId = loggedUser.getLoggedUser().getId();
        userService.addMessage(text, accountId);
        return profile(model);
    }

    @PostMapping("/profile/delete-message/{messageId}")
    public String deleteMessage(@PathVariable Long messageId,
                             Model model) {
        userService.deleteMessage(messageId);
        return profile(model);
    }

    @PostMapping("/profile/edit-message/{messageId}")
    public String editMessage(@PathVariable Long messageId,
                           @ModelAttribute("text") String text,
                           Model model) {
        userService.updateMessage(messageId, text);
        return profile(model);
    }
}

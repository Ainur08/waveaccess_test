package ru.waveaccess.conference.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.waveaccess.conference.services.ConfirmationService;

@Controller
public class ConfirmationController {
    @Autowired
    private ConfirmationService confirmationService;


    @GetMapping("/confirm/{token}")
    public String confirm(@PathVariable String token) {
        confirmationService.checkConfirmation(token);
        return "redirect:/signIn";
    }
}

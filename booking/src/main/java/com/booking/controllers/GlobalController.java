package com.booking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalController {
    private final String action = "home";
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("action", action);
        return "index";
    }
}

package com.booking.controllers;

import com.booking.models.BookingUser;
import com.booking.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private final String action = "users";
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("action", action);
        return "users/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new BookingUser());
        model.addAttribute("action", action);
        return "users/create";
    }
    @PostMapping("/create")
    public String create(BookingUser user) {
        userRepository.save(user);
        return "redirect:/users/";
    }
    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        var user = userRepository.findById(id);
        if(user.isEmpty()) return "redirect:/users/";
        model.addAttribute("user", user.get());
        model.addAttribute("action", action);
        return "users/detail";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable(name = "id") Long id) {
        var user = userRepository.findById(id);
        if(user.isEmpty()) return "redirect:/users/";
        model.addAttribute("user", user.get());
        model.addAttribute("action", action);
        return "users/edit";
    }
    @PostMapping("/{id}/edit")
    public String edit(BookingUser user) {
        userRepository.save(user);
        return "redirect:/users/";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable(name = "id") Long id) {
        var user = userRepository.findById(id);
        if(user.isEmpty()) return "redirect:/users/";
        userRepository.delete(user.get());
        return "redirect:/users/";
    }

}

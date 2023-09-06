package com.booking.controllers;

import com.booking.models.Rent;
import com.booking.repo.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rents")
public class RentController {
    @Autowired
    private RentRepository rentRepository;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("rents", rentRepository.findAll());
        return "rents/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("rent", new Rent());
        return "rents/create";
    }
    @PostMapping("/create")
    public String create(Rent rent) {
        rentRepository.save(rent);
        return "redirect:/rents/";
    }
    @GetMapping("/{id}")
    public String details(Model model, @PathVariable(name="id") Long id) {
        var rent = rentRepository.findById(id);
        if (rent.isEmpty()) return "redirect:/rents/";
        model.addAttribute("rent", rent.get());
        return "rents/detail";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable(name="id") Long id) {
        var rent = rentRepository.findById(id);
        if (rent.isEmpty()) return "redirect:/rents/";
        model.addAttribute("rent", rent.get());
        return "rents/edit";
    }
    @PostMapping("/{id}/edit")
    public String edit(Rent rent) {
        rentRepository.save(rent);
        return "redirect:/rents/";
    }
    @PostMapping("/{id}/delete")
    public String delete(Model model, @PathVariable(name="id") Long id) {
        var rent = rentRepository.findById(id);
        if (rent.isEmpty()) return "redirect:/rents/";
        model.addAttribute("rent", rent.get());
        return "redirect:/rents/";
    }
}

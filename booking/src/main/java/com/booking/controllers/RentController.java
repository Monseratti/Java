package com.booking.controllers;

import com.booking.models.Rent;
import com.booking.models.Room;
import com.booking.repo.RentRepository;
import com.booking.repo.RoomRepository;
import com.booking.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/rents")
public class RentController {
    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;
    private final String action = "rents";
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("rents", rentRepository.findAll());
        model.addAttribute("action", action);
        return "rents/index";
    }
    @GetMapping("/setDates")
    public String create(Model model) {
        model.addAttribute("action", action);
        return "rents/setDates";
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
        model.addAttribute("action", action);
        return "rents/detail";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable(name="id") Long id) {
        var rent = rentRepository.findById(id);
        if (rent.isEmpty()) return "redirect:/rents/";
        model.addAttribute("rent", rent.get());
        model.addAttribute("action", action);
        return "rents/edit";
    }
    @PostMapping("/{id}/edit")
    public String edit(Rent rent) {
        rentRepository.save(rent);
        return "redirect:/rents/";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable(name="id") Long id) {
        var rent = rentRepository.findById(id);
        if (rent.isEmpty()) return "redirect:/rents/";
        rentRepository.delete(rent.get());
        return "redirect:/rents/";
    }

    @GetMapping("/create")
    public String freeRoom(@RequestParam String startDate, @RequestParam String endDate, Model model) {
        var rent = new Rent();
        rent.setStartDate(LocalDate.parse(startDate));
        rent.setEndDate(LocalDate.parse(endDate));
        var rents = rentRepository.findAll();
        var rooms = roomRepository.findAll();
        var freeRooms = new ArrayList<Room>();
        for (Room room : rooms) {
            boolean isFree = true;
            for (Rent r : rents) {
                if (r.getRoom().getId() == room.getId()) {
                    if (r.getStartDate().isBefore(rent.getStartDate()) && r.getEndDate().isAfter(rent.getStartDate())) {
                        isFree = false;
                    }
                    if (r.getStartDate().isBefore(rent.getEndDate()) && r.getEndDate().isAfter(rent.getEndDate())) {
                        isFree = false;
                    }
                    if (r.getStartDate().isAfter(rent.getStartDate()) && r.getEndDate().isBefore(rent.getEndDate())) {
                        isFree = false;
                    }
                }
            }
            if (isFree) {
                freeRooms.add(room);
            }
        }
        var tenants = userRepository.findAll();
        var freeTenants = new ArrayList<>();
        for (var tenant : tenants) {
            boolean isFree = true;
            for (var r : rents) {
                if (r.getTenant().getId() == tenant.getId()) {
                    if (r.getStartDate().isBefore(rent.getStartDate()) && r.getEndDate().isAfter(rent.getStartDate())) {
                        isFree = false;
                    }
                    if (r.getStartDate().isBefore(rent.getEndDate()) && r.getEndDate().isAfter(rent.getEndDate())) {
                        isFree = false;
                    }
                    if (r.getStartDate().isAfter(rent.getStartDate()) && r.getEndDate().isBefore(rent.getEndDate())) {
                        isFree = false;
                    }
                }
            }
            if (isFree && tenant.getRole().equals("tenant")) {
                freeTenants.add(tenant);
            }
        }
        model.addAttribute("rent", rent);
        model.addAttribute("rooms", freeRooms);
        model.addAttribute("tenants", freeTenants);
        model.addAttribute("action", action);
        return "rents/create";
    }
}

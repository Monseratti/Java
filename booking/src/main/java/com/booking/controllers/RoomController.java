package com.booking.controllers;

import com.booking.models.BookingUser;
import com.booking.models.Room;
import com.booking.repo.RoomRepository;
import com.booking.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;
    private final String action = "rooms";

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("rooms", roomRepository.findAll());
        model.addAttribute("action", action);
        return "rooms/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        var users = userRepository.findAll();
        var owners = new ArrayList<BookingUser>();
        users.forEach(user -> {
            if(user.getRole().equals("owner")) owners.add(user);
        });
        model.addAttribute("room", new Room());
        model.addAttribute("owners", owners);
        model.addAttribute("action", action);
        return "rooms/create";
    }

    @PostMapping("/create")
    public String create(Room room) {
        roomRepository.save(room);
        return "redirect:/rooms/";
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        var room = roomRepository.findById(id);
        if (room.isEmpty()) return "redirect:/rooms/";
        model.addAttribute("room", room.get());
        model.addAttribute("action", action);
        return "rooms/detail";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable(name = "id") Long id) {
        var room = roomRepository.findById(id);
        if (room.isEmpty()) return "redirect:/rooms/";
        model.addAttribute("room", room.get());
        model.addAttribute("action", action);
        return "rooms/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(Room room) {
        roomRepository.save(room);
        return "redirect:/rooms/";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable(name = "id") Long id) {
        var room = roomRepository.findById(id);
        if (room.isEmpty()) return "redirect:/rooms/";
        roomRepository.delete(room.get());
        return "redirect:/rooms/";
    }
}

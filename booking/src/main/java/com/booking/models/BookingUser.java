package com.booking.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class BookingUser {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    @OneToMany(mappedBy = "owner")
    private List<Room> rooms;
    @OneToMany(mappedBy = "tenant")
    private List<Rent> rents;

    public BookingUser() {
    }

    public BookingUser(String name, String email, String password, String role, List<Room> rooms, List<Rent> rents) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.rooms = rooms;
        this.rents = rents;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }
}

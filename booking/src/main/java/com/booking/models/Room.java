package com.booking.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false, insertable = false, updatable = false)
    private BookingUser userId;
    @OneToMany(mappedBy = "room")
    private List<Rent> rents;

    public Room() {
    }

    public Room(String name, String description, BookingUser userId, List<Rent> rents) {
        this.name = name;
        this.description = description;
        this.userId = userId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BookingUser getUserId() {
        return userId;
    }

    public void setUserId(BookingUser owner) {
        this.userId = owner;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }
}

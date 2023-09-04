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
    @JoinColumn(name = "id", nullable = false)
    private User owner;
    @OneToMany
    private List<Rent> rents;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

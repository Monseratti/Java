package com.booking.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Rent {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private User tenant;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rent() {
    }

    public Rent(User tenant, Room room, LocalDate startDate, LocalDate endDate) {
        this.tenant = tenant;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getTenant() {
        return tenant;
    }

    public void setTenant(User tenant) {
        this.tenant = tenant;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

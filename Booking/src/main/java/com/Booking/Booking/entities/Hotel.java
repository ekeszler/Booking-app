package com.Booking.Booking.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Hotel {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String hotelName;

    @OneToMany(mappedBy = "hotel_id", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("hotel-room")
    List<Room> rooms;

    @ManyToMany
    @JoinTable(
            name = "hotel-user",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;

    public Hotel() {
    }

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        rooms = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}

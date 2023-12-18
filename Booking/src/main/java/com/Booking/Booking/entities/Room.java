package com.Booking.Booking.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonBackReference("room-hotel")
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToMany(mappedBy = "rooms")
    private List<Reservartion> reservations;

    private Integer roomNumber;
    private Integer price;
    private Integer personsNumber;

    public Room() {
    }

    public Room(Hotel hotel, List<Reservartion> reservations, Integer roomNumber, Integer price, Integer personsNumber) {
        this.hotel = hotel;
        this.roomNumber = roomNumber;
        this.price = price;
        this.personsNumber = personsNumber;
        reservations = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Reservartion> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservartion> reservations) {
        this.reservations = reservations;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPersonsNumber() {
        return personsNumber;
    }

    public void setPersonsNumber(Integer personsNumber) {
        this.personsNumber = personsNumber;
    }
}

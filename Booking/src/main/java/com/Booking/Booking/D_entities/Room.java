package com.Booking.Booking.D_entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(mappedBy = "room",  cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("roomreservation-room")
    List<RoomReservation> roomReservationList;

    private Integer roomNumber;
    private Integer price;
    private Integer personsNumber;

    public Room(Integer roomNumber, Integer price, Integer personsNumber, Hotel hotel) {
    }

    public Room(Hotel hotel, Integer roomNumber, Integer price, Integer personsNumber) {
        this.hotel = hotel;
        this.roomNumber = roomNumber;
        this.price = price;
        this.personsNumber = personsNumber;
        roomReservationList = new ArrayList<>();
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

    public List<RoomReservation> getRoomReservationList() {
        return roomReservationList;
    }

    public void setRoomReservationList(List<RoomReservation> roomReservationList) {
        this.roomReservationList = roomReservationList;
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

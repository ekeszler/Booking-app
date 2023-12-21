package com.Booking.Booking.D_entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Reservartion {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonBackReference("user-reservation")
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "reservation",  cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("reservation-roomreservation")
    private List<RoomReservation> roomReservationList;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    public Reservartion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<RoomReservation> getRoomReservationList() {
        return roomReservationList;
    }

    public void setRoomReservationList(List<RoomReservation> roomReservationList) {
        this.roomReservationList = roomReservationList;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }
}

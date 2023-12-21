package com.Booking.Booking.D_entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class RoomReservation {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonBackReference("roomreservation-room")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    @JsonBackReference("reservation-roomreservation")
    private Reservartion reservartion;

    public RoomReservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservartion getReservartion() {
        return reservartion;
    }

    public void setReservartion(Reservartion reservartion) {
        this.reservartion = reservartion;
    }
}

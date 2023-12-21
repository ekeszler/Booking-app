package com.Booking.Booking.controllers;

import com.Booking.Booking.Service.HotelService;
import com.Booking.Booking.dtos.RoomRequestDTO;
import com.Booking.Booking.entities.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/{name}")
    public ResponseEntity<Hotel> addHotel(@PathVariable String name) {
        return ResponseEntity.ok(hotelService.createHotel(name));
    }

    @PostMapping("/{hotelId}")
    public ResponseEntity<?> addRoomToHotel(@RequestBody RoomRequestDTO roomRequestDTO, @PathVariable Long hotelId) {
        return ResponseEntity.ok(hotelService.addRoomToHotel(roomRequestDTO, hotelId));
    }

}

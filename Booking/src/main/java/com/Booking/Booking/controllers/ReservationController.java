package com.Booking.Booking.controllers;

import com.Booking.Booking.Service.ReservartionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    ReservartionService reservartionService;

    @Autowired
    public ReservationController(ReservartionService reservartionService) {
        this.reservartionService = reservartionService;
    }
}

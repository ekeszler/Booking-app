package com.Booking.Booking.A_controllers;

import com.Booking.Booking.B_service.ReservartionService;
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

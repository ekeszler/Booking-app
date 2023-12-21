package com.Booking.Booking.B_service;

import com.Booking.Booking.C_repositories.HotelRepository;
import com.Booking.Booking.C_repositories.RoleRepository;
import com.Booking.Booking.C_repositories.RoomRepository;
import com.Booking.Booking.C_repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;
    RoomRepository roomRepository;
    HotelRepository hotelRepository;
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoomRepository roomRepository, HotelRepository hotelRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
        this.roleRepository = roleRepository;
    }


}

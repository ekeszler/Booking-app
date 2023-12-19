package com.Booking.Booking.Service;

import com.Booking.Booking.Repositories.HotelRepository;
import com.Booking.Booking.Repositories.RoleRepository;
import com.Booking.Booking.Repositories.RoomRepository;
import com.Booking.Booking.Repositories.UserRepository;
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

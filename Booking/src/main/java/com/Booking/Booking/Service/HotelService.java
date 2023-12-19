package com.Booking.Booking.Service;

import com.Booking.Booking.Repositories.HotelRepository;
import com.Booking.Booking.Repositories.RoomRepository;
import com.Booking.Booking.dtos.RoomRequestDTO;
import com.Booking.Booking.entities.Hotel;
import com.Booking.Booking.entities.Room;
import com.Booking.Booking.exceprions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {
    HotelRepository hotelRepository;
    RoomRepository roomRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    @Transactional
    public Hotel createHotel(String hotelName){
        Hotel hotel = new Hotel(hotelName);
        return hotelRepository.save(hotel);
    }

    @Transactional
    public Room addRoomToHotel(RoomRequestDTO roomRequestDTO, Long hotelId){
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotel does not found"));
        Room room = new Room(
                roomRequestDTO.getRoomNumber(),
                roomRequestDTO.getPrice(),
                roomRequestDTO.getPersonsNumber(),
                hotel
        );
        return roomRepository.save(room);
    }

    @Transactional
    public Hotel removeRoomFromHotel(RoomRequestDTO roomRequestDTO, Long hotelId){
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotel doesn not found"));
        Room roomToBeRemoved = hotel.getRooms().stream()
                .filter(room -> room.getId().equals(roomRequestDTO.getId()))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFoundException("Room not found"));

        hotel.getRooms().remove(roomToBeRemoved);
        return hotelRepository.save(hotel);
    }


}

package com.Booking.Booking.B_service;

import com.Booking.Booking.C_repositories.HotelRepository;
import com.Booking.Booking.C_repositories.RoomRepository;
import com.Booking.Booking.E_dtos.RoomRequestDTO;
import com.Booking.Booking.D_entities.Hotel;
import com.Booking.Booking.D_entities.Room;
import com.Booking.Booking.G_exceprions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

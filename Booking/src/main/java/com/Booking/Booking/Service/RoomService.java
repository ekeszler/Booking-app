package com.Booking.Booking.Service;

import com.Booking.Booking.Repositories.HotelRepository;
import com.Booking.Booking.Repositories.RoomRepository;
import com.Booking.Booking.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.StyleSheet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    private List<Room> findAvailableRooms(LocalDateTime checkIn, LocalDateTime checkOut, Integer numberOfPersons){
        List<Room> foundRooms = roomRepository.findAllByGuestNumber(numberOfPersons);
        return foundRooms.stream()
                .filter(room -> isAvailable(room, checkIn, checkOut))
                .collect(Collectors.toList());

    }

    private boolean isAvailable(Room room, LocalDateTime checkIn, LocalDateTime checkOut){
        return room.getRoomReservationList().stream()
                .map(roomReservation -> roomReservation.getReservartion())
                .noneMatch(reservartion ->
                        reservartion.getCheckIn().isBefore(checkIn) && reservartion.getCheckOut().isAfter(checkOut)
                || reservartion.getCheckOut().isAfter(checkIn) && reservartion.getCheckIn().isBefore(checkOut)
                || reservartion.getCheckIn().isEqual(checkIn) || reservartion.getCheckOut().isEqual(checkOut));
    }


}

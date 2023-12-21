package com.Booking.Booking.Repositories;

import com.Booking.Booking.entities.Room;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    List<Room> findAllByGuestNumber(Integer numberOfPersons);
}

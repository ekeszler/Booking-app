package com.Booking.Booking.Repositories;

import com.Booking.Booking.entities.Reservartion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervationRepository extends JpaRepository<Reservartion,Long> {
}

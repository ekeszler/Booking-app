package com.Booking.Booking.C_repositories;

import com.Booking.Booking.D_entities.Reservartion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervationRepository extends JpaRepository<Reservartion,Long> {
}

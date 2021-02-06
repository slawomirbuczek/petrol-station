package com.pl.petrolstationcarwashreservation.repositories;

import com.pl.petrolstationcarwashreservation.entities.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface ReservationsRepository extends JpaRepository<Reservations, Long> {

    List<Reservations> findAllByDate(Date date);

    Optional<Reservations> findByDateAndTime(Date date, Time time);

}

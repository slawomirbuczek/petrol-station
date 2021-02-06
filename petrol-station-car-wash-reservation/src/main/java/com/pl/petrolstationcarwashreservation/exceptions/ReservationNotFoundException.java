package com.pl.petrolstationcarwashreservation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.Date;
import java.sql.Time;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException(Date date, Time time) {
        super("Reservation with date " + date.toString() + " " + time.toString() + " not found.");
    }
}

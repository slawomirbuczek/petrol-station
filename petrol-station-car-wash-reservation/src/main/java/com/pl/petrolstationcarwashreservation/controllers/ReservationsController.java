package com.pl.petrolstationcarwashreservation.controllers;

import com.pl.petrolstationcarwashreservation.dtos.ReservationDto;
import com.pl.petrolstationcarwashreservation.models.RequestDate;
import com.pl.petrolstationcarwashreservation.models.ReservationsList;
import com.pl.petrolstationcarwashreservation.services.ReservationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {

    private final ReservationsService reservationsService;

    public ReservationsController(ReservationsService reservationsService) {
        this.reservationsService = reservationsService;
    }

    @GetMapping
    public ResponseEntity<ReservationsList> getReservations(@RequestBody RequestDate requestDate) {
        return ResponseEntity.ok(reservationsService.getReservations(requestDate));
    }

    @PostMapping
    public ResponseEntity<ReservationDto> reserve(@RequestBody ReservationDto reservationDto) {
        return ResponseEntity.ok(reservationsService.reserve(reservationDto));
    }

    @PutMapping
    public ResponseEntity<ReservationDto> cancelReservation(@RequestBody ReservationDto reservationDto) {
        return ResponseEntity.ok(reservationsService.cancelReservation(reservationDto));
    }

}

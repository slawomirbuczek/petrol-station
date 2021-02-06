package com.pl.petrolstationcarwashreservation.services;

import com.pl.petrolstationcarwashreservation.dtos.ReservationDto;
import com.pl.petrolstationcarwashreservation.entities.Reservations;
import com.pl.petrolstationcarwashreservation.exceptions.ReservationIsAlreadyTakenException;
import com.pl.petrolstationcarwashreservation.exceptions.ReservationNotFoundException;
import com.pl.petrolstationcarwashreservation.models.RequestDate;
import com.pl.petrolstationcarwashreservation.models.ReservationsList;
import com.pl.petrolstationcarwashreservation.repositories.ReservationsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;


    public ReservationsService(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    public ReservationsList getReservations(RequestDate date) {
        List<Reservations> reservations =
                reservationsRepository.findAllByDate(date.getDate());

        if (reservations.isEmpty()) {
            return createNewReservationsForTheWholeDay(date.getDate());
        }


        return new ReservationsList(
                reservations.stream().map(this::mapToDto).collect(Collectors.toList())
        );
    }

    public ReservationDto reserve(ReservationDto reservationDto) {
        Reservations reservation = getReservationByDateAndTime(
                reservationDto.getDate(),
                reservationDto.getTime()
        );

        if (Objects.nonNull(reservation.getCustomerId())) {
            throw new ReservationIsAlreadyTakenException(
                    reservationDto.getDate(),
                    reservationDto.getTime()
            );
        }

        reservation.setWashingType(reservationDto.getWashingType());
        reservation.setCustomerId(reservationDto.getCustomerId());

        return mapToDto(reservationsRepository.save(reservation));
    }

    public ReservationDto cancelReservation(ReservationDto reservationDto) {
        Reservations reservation = getReservationByDateAndTime(
                reservationDto.getDate(),
                reservationDto.getTime()
        );

        reservation.setCustomerId(null);
        reservation.setWashingType(null);
        return mapToDto(reservationsRepository.save(reservation));
    }

    private Reservations getReservationByDateAndTime(Date date, Time time) {
        Optional<Reservations> optionalReservation =
                reservationsRepository.findByDateAndTime(date, time);

        return optionalReservation.orElseThrow(
                () -> new ReservationNotFoundException(date, time)
        );
    }

    private ReservationsList createNewReservationsForTheWholeDay(Date date) {
        List<Reservations> reservations = new ArrayList<>();

        long interval = 30 * 60 * 1_000L;

        Time time = Time.valueOf("06:00:00");
        for (int i = 0; i < 34; i++) {
            reservations.add(reservationsRepository.save(createNewReservation(
                    date,
                    new Time(time.getTime() + i * interval)
            )));
        }

        return new ReservationsList(
                reservations.stream().map(this::mapToDto).collect(Collectors.toList())
        );
    }

    private Reservations createNewReservation(Date date, Time time) {
        Reservations reservations = new Reservations();
        reservations.setDate(date);
        reservations.setTime(time);
        return reservations;
    }

    private ReservationDto mapToDto(Reservations reservation) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(reservation, ReservationDto.class);
    }
}

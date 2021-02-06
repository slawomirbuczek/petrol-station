package com.pl.petrolstationcarwashreservation.entities;

import com.pl.petrolstationcarwashreservation.enums.WashingType;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "timetable")
public class Reservations {

    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    private Time time;

    @Enumerated(EnumType.STRING)
    private WashingType washingType;

    private Long customerId;

    public Reservations() {
    }

    public Reservations(Long id, Date date, Time time, Long customerId, WashingType washingType) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.customerId = customerId;
        this.washingType = washingType;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public WashingType getWashingType() {
        return washingType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setWashingType(WashingType washingType) {
        this.washingType = washingType;
    }
}

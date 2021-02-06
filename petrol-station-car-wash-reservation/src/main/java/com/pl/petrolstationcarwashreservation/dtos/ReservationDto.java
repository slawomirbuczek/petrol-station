package com.pl.petrolstationcarwashreservation.dtos;

import com.pl.petrolstationcarwashreservation.enums.WashingType;

import java.sql.Date;
import java.sql.Time;

public class ReservationDto {

    private Date date;

    private Time time;

    private WashingType washingType;

    private Long customerId;

    public ReservationDto() {
    }

    public ReservationDto(Date date, Time time, WashingType washingType, Long customerId) {
        this.date = date;
        this.time = time;
        this.washingType = washingType;
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public WashingType getWashingType() {
        return washingType;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setWashingType(WashingType washingType) {
        this.washingType = washingType;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

}

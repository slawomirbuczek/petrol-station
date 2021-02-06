package com.pl.petrolstationcarwashreservation.models;

import java.sql.Date;

public class RequestDate {

    private Date date;

    public RequestDate() {
    }

    public RequestDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

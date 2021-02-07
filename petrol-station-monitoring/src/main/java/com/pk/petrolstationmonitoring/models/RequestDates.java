package com.pk.petrolstationmonitoring.models;

import java.sql.Date;

public class RequestDates {

    private Date from;

    private Date to;

    public RequestDates() {
    }

    public RequestDates(Date from, Date to) {
        this.from = from;
        this.to = to;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}

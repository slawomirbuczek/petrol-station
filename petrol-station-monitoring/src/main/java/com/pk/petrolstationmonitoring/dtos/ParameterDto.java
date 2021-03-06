package com.pk.petrolstationmonitoring.dtos;

import java.sql.Date;
import java.sql.Time;

public class ParameterDto {

    private Date date;

    private Time time;

    private int pressure;

    private int temperature;

    private int level;

    public ParameterDto() {
    }

    public ParameterDto(Date date, Time time, int pressure, int temperature, int level) {
        this.date = date;
        this.time = time;
        this.pressure = pressure;
        this.temperature = temperature;
        this.level = level;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public int getPressure() {
        return pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getLevel() {
        return level;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

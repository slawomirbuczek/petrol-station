package com.pk.petrolstationmonitoring.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pk.petrolstationmonitoring.entities.On;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CurrentOn {

    PRESSURE(0),
    TEMPERATURE(0),
    LEVEL(0);

    private int value;

    CurrentOn(int value) {
        this.value = value;
    }

    public String getName() {
        return name().toLowerCase();
    }

    public static void updateValue(On on) {
        PRESSURE.setValue(on.getPressure());
        TEMPERATURE.setValue(on.getTemperature());
        LEVEL.setValue(on.getLevel());
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

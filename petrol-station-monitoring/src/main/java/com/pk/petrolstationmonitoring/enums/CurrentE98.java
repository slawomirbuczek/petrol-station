package com.pk.petrolstationmonitoring.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pk.petrolstationmonitoring.entities.E98;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CurrentE98 {

    PRESSURE(0),
    TEMPERATURE(0),
    LEVEL(0);

    private int value;

    CurrentE98(int value) {
        this.value = value;
    }

    public String getName() {
        return name().toLowerCase();
    }

    public static void updateValue(E98 e98) {
        PRESSURE.setValue(e98.getPressure());
        TEMPERATURE.setValue(e98.getTemperature());
        LEVEL.setValue(e98.getLevel());
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

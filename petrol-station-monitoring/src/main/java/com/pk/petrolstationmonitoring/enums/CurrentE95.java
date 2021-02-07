package com.pk.petrolstationmonitoring.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pk.petrolstationmonitoring.entities.E95;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CurrentE95 {

    PRESSURE(0),
    TEMPERATURE(0),
    LEVEL(0);

    private int value;

    CurrentE95(int value) {
        this.value = value;
    }

    public static void updateValue(E95 e95) {
        PRESSURE.setValue(e95.getPressure());
        TEMPERATURE.setValue(e95.getTemperature());
        LEVEL.setValue(e95.getLevel());
    }

    public String getName() {
        return name().toLowerCase();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

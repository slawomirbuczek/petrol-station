package com.pk.petrolstationmonitoring.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pk.petrolstationmonitoring.entities.Lpg;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CurrentLpg {

    PRESSURE(0),
    TEMPERATURE(0),
    LEVEL(0);

    private int value;

    CurrentLpg(int value) {
        this.value = value;
    }

    public String getName() {
        return name().toLowerCase();
    }

    public static void updateValue(Lpg lpg) {
        PRESSURE.setValue(lpg.getPressure());
        TEMPERATURE.setValue(lpg.getTemperature());
        LEVEL.setValue(lpg.getLevel());
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

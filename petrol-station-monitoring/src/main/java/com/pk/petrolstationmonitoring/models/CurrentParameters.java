package com.pk.petrolstationmonitoring.models;

import com.pk.petrolstationmonitoring.enums.CurrentE95;
import com.pk.petrolstationmonitoring.enums.CurrentE98;
import com.pk.petrolstationmonitoring.enums.CurrentLpg;
import com.pk.petrolstationmonitoring.enums.CurrentOn;

import java.util.Arrays;
import java.util.List;

public class CurrentParameters {

    private final List<CurrentE95> currentE95;

    private final List<CurrentE98> currentE98;

    private final List<CurrentOn> currentOn;

    private final List<CurrentLpg> currentLpg;

    public CurrentParameters() {
        currentE95 = Arrays.asList(CurrentE95.values());
        currentE98 = Arrays.asList(CurrentE98.values());
        currentOn = Arrays.asList(CurrentOn.values());
        currentLpg = Arrays.asList(CurrentLpg.values());
    }

    public List<CurrentE95> getCurrentE95() {
        return currentE95;
    }

    public List<CurrentE98> getCurrentE98() {
        return currentE98;
    }

    public List<CurrentOn> getCurrentOn() {
        return currentOn;
    }

    public List<CurrentLpg> getCurrentLpg() {
        return currentLpg;
    }

}

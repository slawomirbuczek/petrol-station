package com.pk.petrolstationmonitoring.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("monitoring")
public class MonitoringProperties {

    /**
     * Interval between monitoring in milliseconds.
     */
    private int interval;

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}

package com.pk.petrolstationmonitoring.schedule;

import com.pk.petrolstationmonitoring.entities.*;
import com.pk.petrolstationmonitoring.enums.CurrentE95;
import com.pk.petrolstationmonitoring.enums.CurrentE98;
import com.pk.petrolstationmonitoring.enums.CurrentLpg;
import com.pk.petrolstationmonitoring.enums.CurrentOn;
import com.pk.petrolstationmonitoring.repositories.E95Repository;
import com.pk.petrolstationmonitoring.repositories.E98Repository;
import com.pk.petrolstationmonitoring.repositories.LpgRepository;
import com.pk.petrolstationmonitoring.repositories.OnRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

@Configuration
@EnableScheduling
public class ScheduledTask implements SchedulingConfigurer {

    private final E95Repository e95Repository;
    private final E98Repository e98Repository;
    private final OnRepository onRepository;
    private final LpgRepository lpgRepository;
    private int executionTime;

    public ScheduledTask(E95Repository e95Repository,
                         E98Repository e98Repository,
                         OnRepository onRepository,
                         LpgRepository lpgRepository,
                         @Value("${monitoring.interval}") int executionTime) {
        this.e95Repository = e95Repository;
        this.e98Repository = e98Repository;
        this.onRepository = onRepository;
        this.lpgRepository = lpgRepository;
        this.executionTime = executionTime;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                this::scheduledTask,
                triggerContext -> {
                    Calendar nextExecutionTime = new GregorianCalendar();
                    java.util.Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
                    nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new java.util.Date());
                    nextExecutionTime.add(Calendar.MILLISECOND, getNewExecutionTime());
                    return nextExecutionTime.getTime();
                }
        );
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    private int getNewExecutionTime() {
        return executionTime;
    }

    public void scheduledTask() {
        ModelMapper mapper = new ModelMapper();

        E95 e95 = mapper.map(createNewRandomParameter(), E95.class);
        e95Repository.save(e95);
        CurrentE95.updateValue(e95);

        E98 e98 = mapper.map(createNewRandomParameter(), E98.class);
        e98Repository.save(e98);
        CurrentE98.updateValue(e98);

        On on = mapper.map(createNewRandomParameter(), On.class);
        onRepository.save(on);
        CurrentOn.updateValue(on);

        Lpg lpg = mapper.map(createNewRandomParameter(), Lpg.class);
        lpgRepository.save(lpg);
        CurrentLpg.updateValue(lpg);
        System.out.println("Executed, interval: " + executionTime);
    }

    private Parameter createNewRandomParameter() {
        Parameter parameter = new Parameter();
        parameter.setDate(new Date(System.currentTimeMillis()));
        parameter.setTime(Time.valueOf(LocalTime.now()));
        parameter.setTemperature(getRandomTemperature());
        parameter.setPressure(getRandomPressure());
        parameter.setLevel(getRandomLevel());
        return parameter;
    }

    private int getRandomTemperature() {
        return new Random().nextInt(20) + 10;
    }

    private int getRandomPressure() {
        return new Random().nextInt(100) + 100;
    }

    private int getRandomLevel() {
        return new Random().nextInt(100);
    }


}

package com.pk.petrolstationmonitoring.controllers;

import com.pk.petrolstationmonitoring.models.CurrentParameters;
import com.pk.petrolstationmonitoring.models.ParametersList;
import com.pk.petrolstationmonitoring.models.RequestDates;
import com.pk.petrolstationmonitoring.models.RequestInterval;
import com.pk.petrolstationmonitoring.schedule.ScheduledTask;
import com.pk.petrolstationmonitoring.services.ParametersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parameters")
public class ParametersController {

    private final ParametersService parametersService;
    private final ScheduledTask scheduledTask;

    public ParametersController(ParametersService parametersService, ScheduledTask scheduledTask) {
        this.parametersService = parametersService;
        this.scheduledTask = scheduledTask;
    }

    @GetMapping("/current")
    public ResponseEntity<CurrentParameters> getCurrentParameters() {
        return ResponseEntity.ok(parametersService.getCurrentParameters());
    }

    @PostMapping
    public ResponseEntity<ParametersList> getParametersBetween(@RequestBody RequestDates requestDates) {
        return ResponseEntity.ok(parametersService.getParametersFromDateToDate(requestDates));
    }

    @PostMapping("/interval")
    public ResponseEntity<RequestInterval> changeInterval(@RequestBody RequestInterval requestInterval) {
        scheduledTask.setExecutionTime(requestInterval.getInterval());
        return ResponseEntity.ok(requestInterval);
    }

}

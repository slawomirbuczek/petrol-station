package com.pk.petrolstationmonitoring.services;

import com.pk.petrolstationmonitoring.dtos.ParameterDto;
import com.pk.petrolstationmonitoring.entities.*;
import com.pk.petrolstationmonitoring.models.CurrentParameters;
import com.pk.petrolstationmonitoring.models.ParametersList;
import com.pk.petrolstationmonitoring.models.RequestDates;
import com.pk.petrolstationmonitoring.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParametersService {

    private final E95Repository e95Repository;
    private final E98Repository e98Repository;
    private final OnRepository onRepository;
    private final LpgRepository lpgRepository;

    public ParametersService(E95Repository e95Repository, E98Repository e98Repository, OnRepository onRepository, LpgRepository lpgRepository) {
        this.e95Repository = e95Repository;
        this.e98Repository = e98Repository;
        this.onRepository = onRepository;
        this.lpgRepository = lpgRepository;
    }

    public CurrentParameters getCurrentParameters() {
        return new CurrentParameters();
    }

    public ParametersList getParametersFromDateToDate(RequestDates dates) {
        List<E95> e95List = e95Repository.findAllByDateBetween(dates.getFrom(), dates.getTo());
        List<E98> e98List = e98Repository.findAllByDateBetween(dates.getFrom(), dates.getTo());
        List<On> onList = onRepository.findAllByDateBetween(dates.getFrom(), dates.getTo());
        List<Lpg> lpgList = lpgRepository.findAllByDateBetween(dates.getFrom(), dates.getTo());
        return new ParametersList(
                mapParameterListToParameterDtoList(e95List),
                mapParameterListToParameterDtoList(e98List),
                mapParameterListToParameterDtoList(onList),
                mapParameterListToParameterDtoList(lpgList)
        );
    }

    private List<ParameterDto> mapParameterListToParameterDtoList(List<? extends Parameter> parameters) {
        ModelMapper mapper = new ModelMapper();
        return parameters.stream()
                .map(parameter -> mapper.map(parameter, ParameterDto.class))
                .collect(Collectors.toList());
    }

}

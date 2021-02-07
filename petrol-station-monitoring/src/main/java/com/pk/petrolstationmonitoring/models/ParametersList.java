package com.pk.petrolstationmonitoring.models;

import com.pk.petrolstationmonitoring.dtos.ParameterDto;

import java.util.List;

public class ParametersList {

    private List<ParameterDto> e95List;

    private List<ParameterDto> e98List;

    private List<ParameterDto> onList;

    private List<ParameterDto> lpgList;

    public ParametersList() {
    }

    public ParametersList(List<ParameterDto> e95List, List<ParameterDto> e98List, List<ParameterDto> onList, List<ParameterDto> lpgList) {
        this.e95List = e95List;
        this.e98List = e98List;
        this.onList = onList;
        this.lpgList = lpgList;
    }

    public List<ParameterDto> getE95List() {
        return e95List;
    }

    public List<ParameterDto> getE98List() {
        return e98List;
    }

    public List<ParameterDto> getOnList() {
        return onList;
    }

    public List<ParameterDto> getLpgList() {
        return lpgList;
    }

    public void setE95List(List<ParameterDto> e95List) {
        this.e95List = e95List;
    }

    public void setE98List(List<ParameterDto> e98List) {
        this.e98List = e98List;
    }

    public void setOnList(List<ParameterDto> onList) {
        this.onList = onList;
    }

    public void setLpgList(List<ParameterDto> lpgList) {
        this.lpgList = lpgList;
    }

}

package com.waze.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WazeStreetPickerResult {

    private List<String> addressList;

    public WazeStreetPickerResult() {}

    public WazeStreetPickerResult(List<String> addressList) {
        this.addressList = addressList;
    }

}

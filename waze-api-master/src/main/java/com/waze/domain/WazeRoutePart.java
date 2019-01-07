package com.waze.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WazeRoutePart {

    private String latitude; // Y
    private String longitude; // X
    private String instruction;
    private String streetName;
    private Boolean tollRoad;
    private int timeToCrossInSeconds;
    private int timeFromStartInSeconds;
    private int lengthOfPartInMeters;

    public WazeRoutePart(){}

    public WazeRoutePart(String latitude, String longitude, String instruction, String streetName, Boolean tollRoad, int timeToCrossInSeconds, int timeFromStart, int lengthOfPartInMeters) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.instruction = instruction;
        this.streetName = streetName;
        this.tollRoad = tollRoad;
        this.timeToCrossInSeconds = timeToCrossInSeconds;
        this.timeFromStartInSeconds = timeFromStart;
        this.lengthOfPartInMeters = lengthOfPartInMeters;
    }

}

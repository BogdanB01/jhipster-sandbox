package com.waze.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WazeRoute {

    private String routeName;
    private int routeDurationInMinutes;
    private double routeLengthKM;
    private double routeLengthMiles;
    private boolean isToll;

    public WazeRoute(){}

    public WazeRoute(String routeName, int routeDurationInMinutes, boolean isToll, double routeLengthKM, double routeLengthMiles) {
        this.routeName = routeName;
        this.routeDurationInMinutes = routeDurationInMinutes;
        this.isToll = isToll;
        this.routeLengthKM = routeLengthKM;
        this.routeLengthMiles = routeLengthMiles;
    }

}

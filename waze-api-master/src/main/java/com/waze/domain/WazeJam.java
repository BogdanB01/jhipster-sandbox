package com.waze.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WazeJam {

    private int severity;
    private String type;
    private String country;
    private String end;
    private String start;
    private String street;
    private String startLatitude; // Y
    private String startLongitude; // X
    private String endLatitude; // Y
    private String endLongitude; // X
    private int delayInSec;

   public WazeJam(){}

    public WazeJam(int severity, String type, String country, String end, String start, String street, String startLatitude, String startLongitude, String endLatitude, String endLongitude, int delayInSec) {
        this.severity = severity;
        this.type = type;
        this.country = country;
        this.end = end;
        this.start = start;
        this.street = street;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
        this.endLatitude = endLatitude;
        this.endLongitude = endLongitude;
        this.delayInSec = delayInSec;
    }

}

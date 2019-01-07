package com.waze.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WazeAlert {

    private String country;
    private int numOfThumbsUp;
    private String type;
    private String subType;
    private String placeNearBy;
    private String latitude; // Y
    private String longitude; // X

    public WazeAlert(String country, int numOfThumbsUp, String type, String subType, String placeNearBy, String latitude, String longitude) {
        this.country = country;
        this.numOfThumbsUp = numOfThumbsUp;
        this.type = type;
        this.subType = subType;
        this.placeNearBy = placeNearBy;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public WazeAlert() {
    }

}

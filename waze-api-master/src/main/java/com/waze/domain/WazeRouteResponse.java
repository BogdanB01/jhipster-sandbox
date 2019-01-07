package com.waze.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WazeRouteResponse {

    private List<WazeRoute> routes;
    private String startPoint;
    private String endPoint;
    private String startLatitude;
    private String startLongitude;
    private String endLatitude;
    private String endLongitude;

    public WazeRouteResponse() {
    }

    public WazeRouteResponse(List<WazeRoute> routes, String startPoint, String endPoint, String startLatitude, String startLongitude, String endLatitude, String endLongitude) {
        this.routes = routes;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
        this.endLatitude = endLatitude;
        this.endLongitude = endLongitude;
    }
}

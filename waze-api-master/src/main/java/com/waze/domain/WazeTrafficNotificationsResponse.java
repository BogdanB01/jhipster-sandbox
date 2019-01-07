package com.waze.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WazeTrafficNotificationsResponse {

    private List<WazeAlert> alerts;
    private List<WazeJam> jams;

}


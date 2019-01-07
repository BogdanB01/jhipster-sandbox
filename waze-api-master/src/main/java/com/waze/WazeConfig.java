package com.waze;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class WazeConfig extends Configuration {


    private String modelFile = "hi.html";

    public WazeConfig() {}

    @JsonProperty
    public String getModelFile() {
        return modelFile;
    }

    @JsonProperty
    public void setModelFile(String modelFile) {
        this.modelFile = modelFile;
    }
}

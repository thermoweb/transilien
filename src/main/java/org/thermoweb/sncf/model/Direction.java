package org.thermoweb.sncf.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Direction {
    private StopArea stopArea;
    private String name;
    private String id;

    public StopArea getStopArea() {
        return stopArea;
    }

    public void setStopArea(StopArea stopArea) {
        this.stopArea = stopArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
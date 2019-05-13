package org.thermoweb.sncf.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Route {
    private Direction direction;
    private String name;
    private List<Link> links;
    @JsonProperty("physical_modes")
    private List<PhysicalMode> physicalModes;
    @JsonProperty("is_frequence")
    private String isFrequence;
    private Object geojson;
    @JsonProperty("direction_type")
    private String directionType;
    private Line line;
    private String id;

    public String getIsFrequence() {
        return isFrequence;
    }

    public void setIsFrequence(String isFrequence) {
        this.isFrequence = isFrequence;
    }

    public Object getGeojson() {
        return geojson;
    }

    public void setGeojson(Object geojson) {
        this.geojson = geojson;
    }

    public String getDirectionType() {
        return directionType;
    }

    public void setDirectionType(String directionType) {
        this.directionType = directionType;
    }

    public Object getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<PhysicalMode> getPhysicalModes() {
        return physicalModes;
    }

    public void setPhysicalModes(List<PhysicalMode> physicalModes) {
        this.physicalModes = physicalModes;
    }
}
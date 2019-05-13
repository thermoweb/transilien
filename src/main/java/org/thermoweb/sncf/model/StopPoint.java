package org.thermoweb.sncf.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPoint {
    private String name;
    private List<Link> links;

    @JsonProperty("physical_modes")
    private List<PhysicalMode> physicalModes;
    private Object coord;
    private String label;
    private List<Object> equipments;
    @JsonProperty("administrative_regions")
    private List<Object> administrativeRegions;
    @JsonProperty("fare_zone")
    private Object fareZone;
    private String id;
    @JsonProperty("stop_area")
    private StopArea stopArea;

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

    public Object getCoord() {
        return coord;
    }

    public void setCoord(Object coord) {
        this.coord = coord;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Object> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Object> equipments) {
        this.equipments = equipments;
    }

    public List<Object> getAdministrativeRegions() {
        return administrativeRegions;
    }

    public void setAdministrativeRegions(List<Object> administrativeRegions) {
        this.administrativeRegions = administrativeRegions;
    }

    public Object getFareZone() {
        return fareZone;
    }

    public void setFareZone(Object fareZone) {
        this.fareZone = fareZone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getStopArea() {
        return stopArea;
    }

    public void setStopArea(StopArea stopArea) {
        this.stopArea = stopArea;
    }
}
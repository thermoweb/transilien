package org.thermoweb.sncf.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Departures {

    @JsonProperty("display_informations")
    private Object displayInformations;

    @JsonProperty("stop_point")
    private StopPoint stopPoint;

    private Route route;
    private List<Link> links;

    @JsonProperty("stop_date_time")
    private StopDateTime stopDateTime;

    public Object getStopDateTime() {
        return stopDateTime;
    }

    public void setStopDateTime(StopDateTime stopDateTime) {
        this.stopDateTime = stopDateTime;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Object getStopPoint() {
        return stopPoint;
    }

    public void setStopPoint(StopPoint stopPoint) {
        this.stopPoint = stopPoint;
    }

    public Object getDisplayInformations() {
        return displayInformations;
    }

    public void setDisplayInformations(Object displayInformations) {
        this.displayInformations = displayInformations;
    }
}
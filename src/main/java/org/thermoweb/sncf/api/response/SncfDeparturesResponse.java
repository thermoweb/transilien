package org.thermoweb.sncf.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.thermoweb.sncf.model.Departures;
import org.thermoweb.sncf.model.Link;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SncfDeparturesResponse {

    private Object pagination;
    private List<Link> links;
    private List<Departures> departures;

    public List<Departures> getDepartures() {
        return departures;
    }

    public void setDepartures(List<Departures> departures) {
        this.departures = departures;
    }

    public Object getPagination() {
        return pagination;
    }

    public void setPagination(Object pagination) {
        this.pagination = pagination;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}

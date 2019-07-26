package org.thermoweb.sncf.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopDateTime {

    @JsonProperty("arrival_date_time")
    private String arrivalDateTime;
    @JsonProperty("departure_date_time")
    private String departureDateTime;
    @JsonProperty("base_arrival_date_time")
    private String baseArrivalDateTime;
    @JsonProperty("base_departure_date_time")
    private String baseDepartureDateTime;
    @JsonProperty("data_freshness")
    private String dataFreshnesss;

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public String getBaseArrivalDateTime() {
        return baseArrivalDateTime;
    }

    public void setBaseArrivalDateTime(String baseArrivalDateTime) {
        this.baseArrivalDateTime = baseArrivalDateTime;
    }

    public String getBaseDepartureDateTime() {
        return baseDepartureDateTime;
    }

    public void setBaseDepartureDateTime(String baseDepartureDateTime) {
        this.baseDepartureDateTime = baseDepartureDateTime;
    }

    public String getDataFreshnesss() {
        return dataFreshnesss;
    }

    public void setDataFreshnesss(String dataFreshnesss) {
        this.dataFreshnesss = dataFreshnesss;
    }
}
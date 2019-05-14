package org.thermoweb.sncf.api;

import org.thermoweb.sncf.utils.SncfProperties;

public class SncfApi extends BaseApi {

    private static String apiUrl = "https://api.sncf.com/v1/coverage/sncf/";

    public SncfApi() {
        super(apiUrl);
        SncfProperties properties= SncfProperties.getInstance();
        this.setLogin(properties.getProperty("sncf.api.key"));
        String path = "stop_areas/stop_area:OCE:SA:87381137/departures";
    }

    public String nextDepartures(String stopArea) { // stop_area:OCE:SA:87381137
        return this.doGet("stop_areas/" + stopArea + "/departures");
    }

}
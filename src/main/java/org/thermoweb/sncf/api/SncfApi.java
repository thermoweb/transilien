package org.thermoweb.sncf.api;

import org.thermoweb.sncf.utils.SncfProperties;

public class SncfApi extends BaseApi {

    private static String apiUrl = "https://api.sncf.com/v1/coverage/sncf/";
    private static String departuresPath = "stop_areas/{stop_area_id}/departures";
    private static String vehicleJourneyPath = "vehicle_journeys/{vehicle_journey_id}";

    public SncfApi() {
        super(apiUrl);
        this.setLogin(SncfProperties.getInstance().getProperty("sncf.api.key"));
    }

    public String nextDepartures(String stopArea) {
        String url = departuresPath.replace("{stop_area_id}",stopArea);
        return this.doGet(url);
    }

    public String vehicleJourney(String vehicleJourneyId) {//vehicle_journey:OCE:SN133522F01001
       String url = vehicleJourneyPath.replace("{vehicle_journey_id}", vehicleJourneyId);
       return this.doGet(url);
    }

}
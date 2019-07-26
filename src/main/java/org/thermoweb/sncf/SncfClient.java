package org.thermoweb.sncf;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.thermoweb.sncf.api.SncfApi;
import org.thermoweb.sncf.api.response.SncfDeparturesResponse;
import org.thermoweb.sncf.model.Departures;
import org.thermoweb.sncf.model.StopArea;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SncfClient {

    private SncfApi api;
    private static Logger logger = Logger.getLogger(SncfClient.class);

    public SncfClient() {
        this.api = new SncfApi();
    }

    public List<Departures> getNextDepartures(StopArea stopArea) {
        String result = this.api.nextDepartures(stopArea.getId());
        SncfDeparturesResponse sncfResponse = readValue(result, SncfDeparturesResponse.class);
        if(sncfResponse == null) {
            return new ArrayList<>();
        }
        return sncfResponse.getDepartures();
    }

    public void getVehicleJourney(String vehicleJourneyId) {
        String result = this.api.vehicleJourney(vehicleJourneyId);
    }

    private static <T> T readValue(String result, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        T response;
        try {
            response = mapper.readValue(result, type);
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }

        return response;
    }
}
package org.thermoweb.sncf;

import org.apache.log4j.Logger;
import org.thermoweb.sncf.model.Departures;
import org.thermoweb.sncf.model.StopArea;

import java.util.List;

public class SncfExample {
    private static Logger logger = Logger.getLogger(SncfExample.class);

    public static void main(String[] args) {

        SncfClient client = new SncfClient();
        List<Departures> nextDepartures = client.getNextDepartures(new StopArea("stop_area:OCE:SA:87381137"));

        logger.info(nextDepartures);
    }
}

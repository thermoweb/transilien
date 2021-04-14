package org.thermoweb.transilien;

import org.apache.log4j.Logger;
import org.thermoweb.sncf.api.TransilienApi;
import org.thermoweb.sncf.model.Passages;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class TransilienClient {

    private final TransilienApi api;
    private static final Logger logger = Logger.getLogger(TransilienClient.class);

    public TransilienClient() {
        this.api = new TransilienApi();
    }

    public Passages nextTrain(String gareId) {
        String result = this.api.nextTrain(gareId);

        return this.unMarshalPassages(result);
    }

    public Passages nextTrain(String startStationId, String arrivalStationId) {
        String result = this.api.nextTrainTo(startStationId, arrivalStationId);

        return this.unMarshalPassages(result);
    }

    private Passages unMarshalPassages(String response) {
        try {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Passages.class);


            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Passages) unmarshaller.unmarshal(new StringReader(response));
        } catch (JAXBException e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}

package org.thermoweb.sncf.api;

import org.apache.log4j.Logger;
import org.thermoweb.sncf.utils.SncfProperties;

public class TransilienApi extends BaseApi {

    private static String apiUrl = "https://api.transilien.com";
    private static Logger logger = Logger.getLogger(TransilienApi.class);

    public TransilienApi() {
        super(apiUrl);

        SncfProperties properties= SncfProperties.getInstance();
        this.setLogin(properties.getProperty("sncf.login"));
        this.setPassword(properties.getProperty("sncf.password"));
    }

    public String nextTrain(String gareId) {
        return this.doGet("/gare/" + gareId);
    }

    public String nextTrainTo(String fromGareId, String toGareId) {
        return this.doGet("/gare/" + fromGareId + "/depart/" + toGareId);
    }

}

package org.thermoweb.transilien;

import org.apache.log4j.Logger;
import org.thermoweb.sncf.model.Passages;

public class TransilienExample {

    private static Logger logger = Logger.getLogger(TransilienExample.class);

    public static void main(String[] args) {

        TransilienClient client = new TransilienClient();
        Passages passages = client.nextTrain("87381137", "87384008");

        logger.info(passages);
    }
}

package org.thermoweb.sncf.utils;


import java.io.IOException;
import java.util.Properties;

public class SncfProperties {
    private static Properties props;

    private SncfProperties() {
        props = new Properties();
        try {
            props.load(getClass().getResourceAsStream("/sncf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get a hold of the instance to access properties.
     * @return
     */
    public static SncfProperties getInstance() {
        return Holder.instance;
    }
    private static class Holder {
        static SncfProperties instance = new SncfProperties();
    }

    public String getProperty(String key) {
        return props.getProperty(key);
    }
    public String getProperty(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

}
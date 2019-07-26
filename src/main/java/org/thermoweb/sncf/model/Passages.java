package org.thermoweb.sncf.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="passages")
public class Passages {

    @XmlElement(name = "gare")
    private String gare;

    @XmlElement(name = "train")
    private List<Train> trains;

    public String getGare() {
        return gare;
    }

    public void setGare(String gare) {
        this.gare = gare;
    }

    public void add(Train train) {
        this.trains.add(train);
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    @Override
    public String toString() {
        return this.trains.toString();
    }
}

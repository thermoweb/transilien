package org.thermoweb.sncf.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="train")
public class Train {

    @XmlElement(name="num")
    private Long id;

    @XmlElement(name="miss")
    private String mission;

    @XmlElement(name="date")
    private TrainDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public TrainDate getDate() {
        return date;
    }

    public void setDate(TrainDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.date.toString();
    }
}

package org.thermoweb.sncf.model;

import org.thermoweb.sncf.utils.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="date")
public class TrainDate {

    public enum TrainDateMode {
        REAL, THEORICAL
    }

    @XmlAttribute(name="mode")
    public String mode;

    @XmlValue
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date value;

    public TrainDateMode getMode() {
        if(mode.equalsIgnoreCase("R")) return TrainDateMode.REAL;
        else if(mode.equalsIgnoreCase("T")) return TrainDateMode.THEORICAL;
        else return null;
    }

    @Override
    public String toString() {
        return "("+this.value+" / " + this.getMode() + ")";
    }
}

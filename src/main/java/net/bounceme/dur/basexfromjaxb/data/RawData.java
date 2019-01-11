package net.bounceme.dur.basexfromjaxb.data;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id", "item"})
@XmlAccessorType(XmlAccessType.FIELD)
public class RawData {

    private static final Logger LOG = Logger.getLogger(RawData.class.getName());

    @XmlAttribute
    private int id;

    @XmlElement
    private List<String> items = new ArrayList<>();

    public RawData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    

}

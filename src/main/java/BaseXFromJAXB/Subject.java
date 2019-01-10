package BaseXFromJAXB;

import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"uniqueID"})
public class Subject {

    private static final Logger LOG = Logger.getLogger(Subject.class.getName());

    @XmlAttribute(name = "unique_id")
    private String uniqueID;

    public Subject() {
        uniqueID = "ggggrrrrr";
    }

    public Subject(String uniqueID) {
        this.uniqueID = uniqueID;
    }

}

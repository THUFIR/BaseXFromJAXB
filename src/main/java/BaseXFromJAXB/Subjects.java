package BaseXFromJAXB;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"uniqueID", "subjects"})
public class Subjects {

    private static final Logger LOG = Logger.getLogger(Subjects.class.getName());

    @XmlAttribute
    private String uniqueID;

    @XmlElement
    private List<Subject> subjects = new ArrayList<>();

    public Subjects() {
    }

    public Subjects(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    void add(Subject subject) {
        subjects.add(subject);
    }

}

package BaseXFromJAXB;

import java.util.Date;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"uniqueID", "name", "born", "died"})
public class Author {

    private static final Logger LOG = Logger.getLogger(Author.class.getName());

    @XmlAttribute(name = "unique_id")
    private String uniqueID;

    @XmlElement(name = "name")
    private String name;

    @XmlAttribute(name = "first")
    private String first;

    @XmlAttribute(name = "last")
    private String last;

    @XmlElement(name = "born")
    private String born;

    @XmlAttribute(name = "date_of_birth")
    private Date dateOfBirth;

    @XmlAttribute(name = "date_of_death")
    private Date dateOfDeath;

    @XmlAttribute(name = "died")
    private String died;

    @XmlAttribute(name = "place_of_birth")
    private String placeOfBirth;

    @XmlAttribute(name = "place_of_death")
    private String placeOfDeath;

    private Author() {
    }

    public Author(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }

    public void populate() {
        Utils u = new Utils();
        first = u.newRandomString(RandomSalts.LOWER.getSalt());
        dateOfBirth = u.randomDate();
    }

}

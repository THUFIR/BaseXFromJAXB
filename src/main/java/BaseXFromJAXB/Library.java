package BaseXFromJAXB;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Library {

    private static final Logger LOG = Logger.getLogger(Library.class.getName());

    private String name = null;
    private List<Endowment> endowments = new ArrayList<>();

    public Library() {
    }

    public Library(String name) {
        this.name = name;
    }

    public List<Endowment> getEndowments() {
        return endowments;
    }

    public void setEndowments(List<Endowment> endowment) {
        endowments = endowment;
    }

    public void add(Endowment e) {
        endowments.add(e);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Endowment e : endowments) {
            str.append(e.toString());
        }
        return str.toString();
    }

}

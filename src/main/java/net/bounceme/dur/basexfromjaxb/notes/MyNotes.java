package net.bounceme.dur.basexfromjaxb.notes;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "notes_collection")
public class MyNotes {

    private static final Logger LOG = Logger.getLogger(MyNotes.class.getName());

    private String name = null;
    private List<MyNote> myNotes = new ArrayList<>();

    private MyNotes() {
    }

    public MyNotes(String name) {
        this.name = name;
    }

    public List<MyNote> getEndowments() {
        return myNotes;
    }

    @XmlElement(name = "endowment")
    public void setMyNotes(List<MyNote> endowment) {
        myNotes = endowment;
    }

    public void add(MyNote e) {
        myNotes.add(e);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (MyNote e : myNotes) {
            str.append(e.toString());
        }
        return str.toString();
    }

}

package net.bounceme.dur.basexfromjaxb.books;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Endowment {

    private static final Logger LOG = Logger.getLogger(Endowment.class.getName());

    private String donor = null;
    private final List<Book> books = new ArrayList<>();

    private Endowment() {
    }

    public Endowment(String donor) {
        this.donor = donor;
    }

    public void add(Book b) {
        books.add(b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(new String(""));
        books.forEach((b) -> {
            sb.append(b.toString());
        });
        return sb.toString();
    }
}

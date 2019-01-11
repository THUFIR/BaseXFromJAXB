package net.bounceme.dur.basexfromjaxb.data;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.bounceme.dur.basexfromjaxb.books.Author;
import net.bounceme.dur.basexfromjaxb.books.Subjects;

@XmlType(propOrder = {"isbn", "title", "authors", "subjects"})
@XmlAccessorType(XmlAccessType.FIELD)
public class RawData {

    private static final Logger LOG = Logger.getLogger(RawData.class.getName());

    @XmlAttribute
    private String isbn;

    @XmlElement
    private String title;

    @XmlElement
    private List<Author> authors = new ArrayList<>();

    @XmlElement
    private Subjects subjects = null;

    private RawData() {
    }

    public RawData(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return getTitle() + getIsbn();
    }

    void add(Author author) {
        getAuthors().add(author);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Subjects getSubjects() {
        return subjects;
    }

    public void setSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

}

package net.bounceme.dur.basexfromjaxb.books;

import net.bounceme.dur.basexfromjaxb.RandomSalts;
import net.bounceme.dur.basexfromjaxb.Utils;
import java.util.Random;
import java.util.logging.Logger;

public class Builder {

    public static final Logger LOG = Logger.getLogger(Builder.class.getName());

    public String alpha = "abcdefghijklmnopqrstuvwyz";
    public String numeric = "0123456789";
    Utils u = new Utils();

    public Builder() {
    }

    public Subjects newFakeSubjects() {
        Subjects s = new Subjects(newRandomString(alpha));
        return s;
    }

    public Subject newFakeSubject() {
        Subject s = new Subject(newRandomString(alpha));
        return s;
    }

    public Author newFakeRandomAuthor() throws Exception {
        Author a = new Author(newRandomString(numeric));
        a.setFirst(newRandomString(alpha));
        a.setLast(newRandomString(alpha));
        return a;
    }

    public Book newFakeRandomBook() throws Exception {
        Book b = new Book(newRandomString(numeric));
        b.setTitle(newRandomString(alpha));
        return b;
    }

    public String newRandomString(String saltChars) {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public Library newLib() {
        Library l = new Library(u.newRandomString(RandomSalts.NUMERIC.getSalt()));
        return l;
    }

    public Endowment newEndow() {
        Endowment l = new Endowment(u.newRandomString(RandomSalts.NUMERIC.getSalt()));
        return l;
    }

    public Book newBook() {
        Book l = new Book(u.newRandomString(RandomSalts.NUMERIC.getSalt()));
        return l;
    }

    public Author newAuthor() {
        Author l = new Author(u.newRandomString(RandomSalts.NUMERIC.getSalt()));
        return l;
    }

    public Subjects newSubjects() {
        Subjects l = new Subjects(u.newRandomString(RandomSalts.NUMERIC.getSalt()));
        return l;
    }

    public Subject newSubject() {
        Subject l = new Subject(u.newRandomString(RandomSalts.NUMERIC.getSalt()));
        return l;
    }

}

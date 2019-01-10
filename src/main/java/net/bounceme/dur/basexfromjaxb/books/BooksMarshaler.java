package net.bounceme.dur.basexfromjaxb.books;

import java.io.File;
import java.net.URI;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class BooksMarshaler {

    private static final Logger LOG = Logger.getLogger(BooksMarshaler.class.getName());

    private Builder builder = new Builder();

    public BooksMarshaler() {
    }

    public Library createNewLibraryFromScratch(int authorMax, int bookMax, int EndowmentMax) throws Exception {
        Book book = null;
        Endowment endowment = null;
        Author author = null;
        Subjects subjects = null;
        Subject subject = null;

        Library l = builder.newLib();
        for (int j = 0; j < EndowmentMax; j++) {
            endowment = builder.newEndow();
            for (int i = 0; i < bookMax; i++) {
                book = builder.newBook();
                for (int k = 0; k < authorMax; k++) {
                    author = builder.newAuthor();
                    book.add(author);
                }
                for (int k = 0; k < authorMax; k++) {
                    subjects = builder.newSubjects();
                    for (int x = 0; x < authorMax; x++) {
                        subject = builder.newSubject();
                        subjects.add(subject);
                    }
                    book.setSubjects(subjects);
                }
                LOG.fine(book.toString());
                endowment.add(book);
            }
            LOG.fine(endowment.toString());
            l.add(endowment);
        }
        return l;
    }

    public void marshal(Library library, URI uri) throws Exception {
        LOG.info(library.toString());
        JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(library, new File(uri));
        jaxbMarshaller.marshal(library, System.out);
    }

    public Library unmarshal(URI uri) throws Exception {
        LOG.info(uri.toString());
        File file = new File(uri);
        Library library = JAXB.unmarshal(file, Library.class);
        return library;
    }

}

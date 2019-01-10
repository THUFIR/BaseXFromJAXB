package BaseXFromJAXB;

import java.net.URI;
import java.util.Properties;
import java.util.logging.Logger;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private Properties properties = new Properties();

    public static void main(final String... args) throws Exception {
        new App().readBooksFromFile();
    }

    private void readBooksFromFile() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/jaxb.xml"));
        URI outputURI = new URI(properties.getProperty("output"));
        URI unmarshalFromURI = new URI(properties.getProperty("output_books_file_to_uri"));
        BooksMarshaler bm = new BooksMarshaler();
        Library library = bm.unmarshal(unmarshalFromURI);
        bm.marshal(library, outputURI);
    }

    private void writeBooks() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/jaxb.xml"));
        URI inputURI = new URI(properties.getProperty("input_books_file_to_uri"));
        URI outputURI = new URI(properties.getProperty("output_books_file_to_uri"));
        BooksMarshaler booksMarshaller = new BooksMarshaler();
        Library library = booksMarshaller.createNewLibraryFromScratch(2, 3, 4);
        booksMarshaller.marshal(library, outputURI);
    }

}

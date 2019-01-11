package net.bounceme.dur.basexfromjaxb;

import java.io.File;
import net.bounceme.dur.basexfromjaxb.books.BooksMarshaler;
import net.bounceme.dur.basexfromjaxb.books.Library;
import java.net.URI;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
import net.bounceme.dur.basexfromjaxb.csv.ReaderForCSV;
import net.bounceme.dur.basexfromjaxb.data.RawDataHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class App {

    private static final Logger LOG = Logger.getLogger(App.class.getName());
    private Properties properties = new Properties();
    private File f;

    public static void main(final String... args) throws Exception {
        new App().rawData();
    }

    private void rawData() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/jaxb.xml"));
        URI inputURI = new URI(properties.getProperty("input_data_xml"));
        RawDataHandler rdh = new RawDataHandler();
        Document doc = rdh.getDoc(inputURI);
        List<Element> elements = rdh.traverseDocument(doc);
        rdh.documentToJaxb(doc);
    }

    private void marshalCSV() throws Exception {
        properties.loadFromXML(App.class.getResourceAsStream("/jaxb.xml"));
        URI inputURI = new URI(properties.getProperty("input_csv"));
        URI outputURI = new URI(properties.getProperty("output"));
        ReaderForCSV csvReader = new ReaderForCSV();
        List<String> strings = csvReader.readFile(inputURI);
        for (String s : strings) {
            LOG.info(s);
        }
        csvReader.unmarshal(inputURI);
        csvReader.printMap();
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

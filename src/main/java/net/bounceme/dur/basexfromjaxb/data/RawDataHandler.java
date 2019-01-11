package net.bounceme.dur.basexfromjaxb.data;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class RawDataHandler {

    private static final Logger LOG = Logger.getLogger(RawDataHandler.class.getName());

    public RawDataHandler() {
    }

    public Document getDoc(URI uri) throws Exception {
        LOG.info(uri.toASCIIString());
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(uri));
        return doc;
    }

    public RawData unmarshal(URI uri) throws Exception {
        RawData data = JAXB.unmarshal((new File(uri)), RawData.class);
        return data;
    }

    public void marshal(URI uri) throws Exception {
        JAXB.marshal((new RawData()), (new File(uri)));
    }

    public List<Element> traverseDocument(Document document) throws Exception {
        List<Element> elements = new ArrayList<>();
        Element element = null;
        NodeList entries = document.getElementsByTagName("*");
        for (int i = 0; i < entries.getLength(); i++) {
            element = (Element) entries.item(i);
            elements.add(element);
        }
        return elements;
    }

    public void documentToJaxb(Document document) throws Exception {
        List<Element> elements = traverseDocument(document);
    }
}

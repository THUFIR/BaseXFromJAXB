package net.bounceme.dur.basexfromjaxb.data;

import java.io.File;
import java.net.URI;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class RawDataHandler {

    private static final Logger LOG = Logger.getLogger(RawDataHandler.class.getName());

    public RawDataHandler() {
    }

    
    /*
    
parser = new DOMParser();
xmlDoc = parser.parseFromString(text,"text/xml");

// documentElement always represents the root node
x = xmlDoc.documentElement.childNodes;
for (i = 0; i < x.length ;i++) {
    txt += x[i].nodeName + ": " + x[i].childNodes[0].nodeValue + "<br>";
}
document.getElementById("demo").innerHTML = txt;
    */
    
    public Document getDoc(URI uri) throws Exception {
        LOG.info(uri.toASCIIString());
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(uri));
        return doc;
    }

    public void unmarshal(URI uri) throws Exception {
        RawData data = JAXB.unmarshal((new File(uri)), RawData.class);
    }

    public void printDoc(Document doc) {
        
    }

}

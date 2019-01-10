package net.bounceme.dur.basexfromjaxb.csv;

import java.io.File;
import java.net.URI;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;

public class C {

    private static final Logger LOG = Logger.getLogger(C.class.getName());

    public C() {
    }

    public void unmarshal(URI inputURI) {
        File file = new File(inputURI);
        Foo foo = JAXB.unmarshal(file, Foo.class);
    }
}

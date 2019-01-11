package net.bounceme.dur.basexfromjaxb.data;

import java.io.File;
import java.net.URI;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;

public class RawDataHandler {

    private static final Logger LOG = Logger.getLogger(RawDataHandler.class.getName());

    public RawDataHandler() {
    }

    public void unmarshal(URI uri) throws Exception {
        RawData data = JAXB.unmarshal((new File(uri)), RawData.class);
    }

}

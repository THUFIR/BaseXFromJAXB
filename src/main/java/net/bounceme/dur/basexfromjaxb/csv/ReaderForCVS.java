package net.bounceme.dur.basexfromjaxb.csv;

import com.opencsv.CSVReaderHeaderAware;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Logger;

public class ReaderForCVS {

    private static final Logger LOG = Logger.getLogger(ReaderForCVS.class.getName());
    private Map<String, String> values;

    public ReaderForCVS() {
    }

    public void unmarshal(URI inputURI) throws Exception {
        FileReader f = new FileReader(new File(inputURI));
        values = new CSVReaderHeaderAware(f).readMap();
    }

    public void printMap() {

        Collection<String> foo = values.values();

        for (String s : foo) {
            LOG.info(s);
        }

        for (Map.Entry<String, String> item : values.entrySet()) {
            String key = item.getKey();
            String value = item.getValue();
            LOG.info(value);
        }

    }
}

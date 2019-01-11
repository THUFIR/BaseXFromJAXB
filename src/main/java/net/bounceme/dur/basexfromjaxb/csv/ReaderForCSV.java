package net.bounceme.dur.basexfromjaxb.csv;

import com.opencsv.CSVReaderHeaderAware;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ReaderForCSV {

    private static final Logger LOG = Logger.getLogger(ReaderForCSV.class.getName());
    private Map<String, String> values;

    public ReaderForCSV() {
    }

    public void jfdkl(URI uri) throws Exception {
        InputStream in = getClass().getResourceAsStream(uri.toString());
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        
    }

    public List<String> readFile(URI uri) throws Exception {
        LOG.info(uri.toString());
        List<String> listOfLines = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(uri)));
        String line;
        while ((line = reader.readLine()) != null) {
            listOfLines.add(line);
        }
        reader.close();
        return listOfLines;
    }

    public void unmarshal(URI inputURI) throws Exception {
        FileReader f = new FileReader(new File(inputURI));
        values = new CSVReaderHeaderAware(f).readMap();
    }

    public void printMap() {
        Collection<String> stringValues = values.values();
        for (String s : stringValues) {
            LOG.info(s);
        }

        for (Map.Entry<String, String> item : values.entrySet()) {
            String key = item.getKey();
            String value = item.getValue();
            LOG.info(key);
            LOG.info(value);
        }
    }
}

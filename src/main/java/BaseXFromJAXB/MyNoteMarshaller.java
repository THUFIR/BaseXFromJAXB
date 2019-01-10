package BaseXFromJAXB;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.net.URI;
import java.util.Random;
import java.util.logging.Logger;
import javax.xml.bind.Unmarshaller;

public class MyNoteMarshaller {

    private static final Logger LOG = Logger.getLogger(MyNoteMarshaller.class.getName());
    private int min = 1;
    private int max = 999;

    public MyNoteMarshaller() {
    }

    public MyNotes createMyNotes(int max) throws Exception {
        MyNotes myNotes = new MyNotes("abc");
        MyNote myNote = null;
        for (int i = 0; i < max; i++) {
            myNote = newFakeRandomMyNote();
            myNotes.add(myNote);
        }
        return myNotes;
    }

    private MyNote newFakeRandomMyNote() throws Exception {
        MyNote note = new MyNote();
        note.setBody(randomString());
        note.setFrom(randomString());
        note.setHeading(randomString());
        note.setTo(randomString());
        return note;
    }

    private String randomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public MyNotes unmarshallMyNotesFromFile(URI uri) throws Exception {
        File file = new File(uri);
        JAXBContext jaxbContext = JAXBContext.newInstance(MyNotes.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        MyNotes myNotes = (MyNotes) jaxbUnmarshaller.unmarshal(file);
        return myNotes;
    }

    public void marshallMyNotesAndWriteToFile(Library notes, URI uri) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(notes, new File(uri));
        jaxbMarshaller.marshal(notes, System.out);
    }
}

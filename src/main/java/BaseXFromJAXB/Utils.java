package BaseXFromJAXB;

import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

public class Utils {

    public static final Logger LOG = Logger.getLogger(Utils.class.getName());

    public String alpha = "abcdefghijklmnopqrstuvwyz";
    private String numeric = "0123456789";

    public Utils() {
    }

    public Date randomDate() {
        Random random = new Random();
        long milliseconds = -946771200000L + (Math.abs(random.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        Date date = new Date(milliseconds);
        return date;
    }

    public String newRandomString(String saltChars) {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}

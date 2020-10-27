package example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat(DATETIME_FORMAT);
        Date date = new Date();
        return dateFormat.format(date);
    }
}

package Kek.Thredz;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Dimbo on 14-Jan-16.
 */
public class ThreadCheckerTwo implements Runnable {
    @Override
    public void run() {
        Date now = new Date();
        Locale locale = new Locale("bn");
        DateFormatter formatter = new DateFormatter();
        if (now.getTime() % 2 == 0) {
            System.out.println("now is even time");
        } else System.out.println("now is odd time");
    }
}

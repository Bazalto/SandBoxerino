package Kek.Thredz;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dimbo on 14-Jan-16.
 */
public class Threadz {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor top = new ScheduledThreadPoolExecutor(4);
        top.scheduleAtFixedRate(new ThreadCheckerOne("RAM"), 2000, 1200, TimeUnit.MILLISECONDS);
        top.scheduleAtFixedRate(new ThreadCheckerTwo(), 0, (long) (1200 * Math.random()), TimeUnit.MILLISECONDS);
        top.scheduleAtFixedRate(new ThreadCheckerOne("Something"), 0, 7, TimeUnit.SECONDS);
        System.out.println("Num of threads: " + top.getActiveCount());
    }
}

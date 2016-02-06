package Kek.Thredz;

/**
 * Created by Dimbo on 14-Jan-16.
 */
public class ThreadCheckerOne implements Runnable {
    String checkingThing;

    ThreadCheckerOne(String checkinThing) {
        this.checkingThing = checkinThing;
    }

    @Override
    public void run() {
        System.out.println("Checking " + checkingThing);
    }
}

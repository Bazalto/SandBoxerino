package Kek;

import Kek.Thredz.ThreadCheckerOne;

/**
 * Created by Dimbo on 15-Jan-16.
 */

class TestOne implements Runnable {
    String toCheck = "";
    int delay = 0;
    int times = 10;

    TestOne(String toCheck) {
        this.toCheck = toCheck;
    }

    TestOne(String toCheck, int delay) {
        this(toCheck);
        this.delay = delay;
    }

    TestOne(String toCheck, int delay, int times) {
        this(toCheck, delay);
        this.times = times;
    }


    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println("Running " + toCheck + " check");
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ignored) {
            }
        }
    }
}

class TestTwo extends TestOne{
//    TestTwo(String toCheck) {
//        super(toCheck);
//    }
//
    TestTwo(String toCheck, int delay) {
        super(toCheck, delay);
    }
//
//    TestTwo(String toCheck, int delay, int times) {
//        super(toCheck, delay, times);
//    }

    @Override
    public void run() {
        super.run();
    }
}
public class MultiTopKek {
    public static void main(String[] args) {
        //new Thread(new TestOne("Ram")).start();
//        new Thread(new TestOne("Ram",1000)).start();
        new Thread(new TestOne("Ram",500,4)).start();
    }
}

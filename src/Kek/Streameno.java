package Kek;


import java.util.concurrent.RunnableFuture;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Created by Dimbo on 15-Feb-16.
 */
public class Streameno {
  public static boolean isPrime(int num) {
    return num > 1 &&
        IntStream.range(2, num)
                 .noneMatch(i -> num % i == 0);

  }

  static private class InnerThread implements Runnable {
    String threadName;

    InnerThread(String line) {
      threadName = line;
      new Thread(this, threadName).start();
    }


    public void run() {
      for (int i = 0; i < 10; i++) {
        try {
          System.out.println(threadName + " thread " + i);
          Thread.sleep(500);
        } catch (InterruptedException e) {
          System.out.println("interrupted");
        }
      }
    }
  }

  public static void main(String[] args) {
    Thread t = Thread.currentThread();
    t.setPriority(1);
    System.out.println("Thread: " + t);

    new InnerThread("porara");

    try {


      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    new InnerThread("Urara");

    for (int i = 0; i < 5; i++) {
      try {
        System.out.println("main : " + i);
        Thread.sleep(300);
      } catch (InterruptedException ex) {
      }

    }
    System.out.println("main hangin");

  }
}

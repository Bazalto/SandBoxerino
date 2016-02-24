package Kek;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class EpamLel {
  public static void main(String[] args) {
    int len = 100000;
    int[] ara = new int[len];
    Random rnd = new Random();

    for (int i = 0; i < ara.length; i++) {
      ara[i] = rnd.nextInt(7);
    }
    System.out.println(ara.length);
    ara = removeElements(ara, 3);
    System.out.println(ara.length);
    System.out.println(Arrays.toString(ara));
  }

  public static int[] removeElements(int[] arr, int n) {
    System.out.println(new Date().getTime());
    int[] resultArr;
    int resultArrLength = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != n) resultArrLength++;
    }

    System.out.println(new Date().getTime());
    resultArr = new int[resultArrLength];


    int counter = 0;
    for (int elem : arr) {
      if (elem != n) resultArr[counter++] = elem;
    }
    System.out.println(new Date().getTime());
    
    return resultArr;
  }
}

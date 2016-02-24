package Cryptingu;

import java.math.BigInteger;


public class RSADawgs {
  static int[] getDividers(int number, boolean show) {

    int last = 0, preLast = 0;
    for (int i = 1; i < number; i++) {
      if (number % i == 0) {
        //   System.out.println(i);
        preLast = last;
        last = i;
      }
    }

    if (show) System.out.println("res: " + preLast + "*" + last + " = " + (last * preLast));
    return new int[]{preLast, last};
  }

  static boolean isMutuallySimple(int one, int another) {
    int smaller = (one < another) ? one : another;
    boolean result = true;
    for (int i = 2; i < smaller; i++) {
      if (one % i == 0 && another % i == 0) {
        result = false;
        break;
      }
    }
    return result;
  }

  public static void main(String[] args) {

    int n = 667, e = 17, c = 219;          //std
    //int n = 1073, e = 37, c = 174        //mine
    //int n = 437, e = 17, c = 383;        //kasyak


    int pq[] = getDividers(n, false);
    int eiler = (pq[0] - 1) * (pq[1] - 1);

    System.out.println("Eiler= " + eiler);

    // secret key 'd'
    // ed=1 mod eiler
    System.out.println(e + "d=1 mod " + eiler);


    int D = find(e, pq[0], pq[1], n);
    System.out.println("\nD: " + D);


    int M = BigInteger.valueOf(c)
                      .pow(D)
                      .mod(BigInteger.valueOf(n))
                      .intValue();
    System.out.println("\nM: " + M);

    int C = BigInteger.valueOf(M)
                      .pow(e)
                      .mod(BigInteger.valueOf(n))
                      .intValue();
    System.out.println("\nC: " + C);


    int sign = BigInteger.valueOf(M)
                         .pow(D)
                         .mod(BigInteger.valueOf(n))
                         .intValue();
    System.out.println("\nSing: " + sign);

    //sign check
    int signCheck = BigInteger.valueOf(sign)
                              .pow(e)
                              .mod(BigInteger.valueOf(n))
                              .intValue();
    System.out.println("Sign check: " + (signCheck == M ? "Valid" : "Invalid"));

  }

  static int find(int a, int b, int c, int n) {
    for (int i = 0; i < n; i++) {
      if ((a * i) % ((b - 1) * (c - 1)) == 1) {
        return i;
      }
    }
    return 0;
  }


}

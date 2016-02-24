package Cryptingu;

import java.util.Scanner;

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

        int n = 667, e = 17, c = 219;      //std
        //int n = 1073, e = 37, c = 174        //mine

        int pq[] = getDividers(n, false);
        int eiler = (pq[0] - 1) * (pq[1] - 1);

        System.out.println(eiler);
        System.out.println(isMutuallySimple(n, eiler));

        // secret key 'd'
        // ed=1 mod eiler
        System.out.println(e + "d=1 mod " + eiler);

        int[] evklidus = new int[20];


        System.out.println(evklidus[0] = e % eiler);

        System.out.println(evklidus[1] = eiler % evklidus[0]);
        System.out.println(evklidus[2] = e % evklidus[1]);
        System.out.println(evklidus[3] = eiler % evklidus[2]);



        System.out.println();

    }


}

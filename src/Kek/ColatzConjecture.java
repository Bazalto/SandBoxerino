package Kek;

import java.util.Scanner;

/**
 * Created by Dimbo on 10-Jan-16.
 */
public class ColatzConjecture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0, counter = 0;

        while (n < 2) {
            System.out.print("Enter n (>1), starting number>> ");
            n = scanner.nextInt();
        }

        while (n != 1) {
            if (n % 2 == 0) n /= 2;
            else n = n * 3 + 1;

            System.out.println("N: "+n);
            counter++;
        }
        System.out.println("Number of steps required: " + counter);

    }
}

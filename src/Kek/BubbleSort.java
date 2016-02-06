package Kek;

import java.util.Arrays;

/**
 * Created by Dimbo on 10-Jan-16.
 */
interface HadoukenOne{
    default void Hadouken(String smth) {
        System.out.printf("kek");
    }
    void method();
}

interface HadoukenTwo{
//    default void Hadouken(String smth) {
//        System.out.println("nana");
//    }

    void method();
}

public class BubbleSort implements HadoukenOne, HadoukenTwo{
    public void method(){
        System.out.println("hi");
    }

    public static void main(String[] args) {
        int array[] = {1, 7, 3, 8, 4, 2, 8, -1, -4, 3, 0, -6};
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
        System.out.println("Result array: " + Arrays.toString(array));

    }

}

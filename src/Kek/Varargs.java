package Kek;

import java.util.Objects;

/**
 * Created by Dimbo on 12-Jan-16.
 */
public class Varargs {
    void vararg(String msg, Object... v) {
        System.out.println("len of " + msg + "is: " + v.length);
        for (Object x : v) {
            System.out.println(x + " ");
        }

    }

    void vararg(String msg, int ... kek){
        System.out.println("ambiguity dummy");
    }


    public static void main(String[] args) {
        Varargs vr = new Varargs();
        vr.vararg("msg1 ", 1, 3, true, 3.2);
        System.out.println();
        vr.vararg("msg2 ", 1, 2, 4, "32");

    }
}

package Cryptingu;

import java.util.Map;
import java.util.StringJoiner;

public class Curiputu {
    static Elem[] table = new Elem[15];

    private static void mapFill(Map table) {
        table.put("a1", 0010);
        table.put("a2", 0100);
        table.put("a3", 1000);
        table.put("a4", 0011);
        table.put("a5", 0110);
        table.put("a6", 1100);
        table.put("a7", 1011);
        table.put("a8", 0101);
        table.put("a9", 1010);
        table.put("a10", 0111);
        table.put("a11", 1110);
        table.put("a12", 1111);
        table.put("a13", 1101);
        table.put("a14", 1001);
        table.put("a15", 0001);
    }

    private static void tableFill(Elem[] arr) {
        arr[0] = new Elem(1, 14, 2, "x");
        arr[1] = new Elem(2, 13, 4, "x2");
        arr[2] = new Elem(3, 12, 8, "x3");
        arr[3] = new Elem(4, 11, 3, "x+1");
        arr[4] = new Elem(5, 10, 6, "x2+x");
        arr[5] = new Elem(6, 9, 12, "x3+x2");
        arr[6] = new Elem(7, 8, 11, "x3+x+1");
        arr[7] = new Elem(8, 7, 5, "x2+1");
        arr[8] = new Elem(9, 6, 10, "x3+x");
        arr[9] = new Elem(10, 5, 7, "x2+x+1");
        arr[10] = new Elem(11, 4, 14, "x3+x2+x");
        arr[11] = new Elem(12, 3, 15, "x3+x2+x+1");
        arr[12] = new Elem(13, 2, 13, "x3+x2+1");
        arr[13] = new Elem(14, 1, 9, "x3+1");
        arr[14] = new Elem(15, 15, 1, "1");
    }

    static Elem byA(int a) {
        for (Elem e : table) {
            if (e.a == a) return e;
        }
        return null;
    }

    static Elem byDec(int dec) {
        for (Elem e : table) {
            if (e.dec == dec) {
                return e;
            }
        }
        return null;
    }

    static Elem byRev(int rev) {
        for (Elem e : table) {
            if (e.rev == rev) return e;
        }
        return null;
    }

    static void binShow(int dec) {
        String string = Integer.toString(dec, 2);
        while (string.length() < 4) string = "0" + string;
        System.out.println(string);
    }

    public static void main(String[] args) throws NullPointerException{

        int i = 7, k = 3, Px = 7, P1x = 6;
        double Cx[] = {1, 13};
        tableFill(table);
        //JOptionPane.showMessageDialog(null, Integer.toString(table[11].dec, 2));
        int K[] = new int[4];

        //K 0
        K[0] = byDec(i).a + byDec(2).a + byRev(byDec(3).a).a;
        K[0] %= 15;
        binShow(byA(K[0]).dec);
        //System.out.println(Integer.toString(K[0]));

        //K 1
        K[1] = byDec(byDec(i).dec ^ byDec(k).dec).a +
                byRev(byDec(7).a).a;
        K[1] %= 15;
        binShow(byA(K[1]).dec);

        //K 2
        K[2] = byDec(byA(byDec(3).a + byDec(i).a).dec ^ byDec(2).dec).a+
                byRev(byDec(k).a).a;
        K[2] %=15;
        binShow(byA(K[2]).dec);


        //binShow(byA(K[2]).dec);

    }
}

package Cryptingu;

import java.util.Arrays;

public class Curiputu {
    static Elem[] table = new Elem[15];
    static int[][] S;

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
        if (a > 15) a %= 15;
        for (Elem e : table) {
            if (e.a == a) return e;
        }
        return null;
    }

    static Elem byDec(int dec) {
        if (dec > 15) dec %= 15;
        for (Elem e : table) {
            if (e.dec == dec) {
                return e;
            }
        }
        return null;
    }

    static Elem byRev(int rev) {
        if (rev > 15) rev %= 15;
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

    static int[] sbMatrix(int[] matrix) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < S.length; j++) {
                if (S[j][2] == matrix[i]) {
                    result[i] = S[j][0];
                    break;
                }
            }
        }

        return result;
    }

    static int[] reverseMatrix(int[] matrix) {
        return new int[]{matrix[1], matrix[0]};
    }

    static int[] shiftMatrix(int[] matrix) {
        int[] result = new int[matrix.length];
        System.arraycopy(matrix, 0, result, 0, matrix.length);
        int tmp = result[1];
        result[1] = result[3];
        result[3] = tmp;
        return result;
    }


    static int[] sumMatrixByA(int[] matrix) {
        int[] result = new int[matrix.length / 2];
        for (int i = 0; i < matrix.length; i += 2) {
            result[i] = byA(matrix[i]).dec ^ byA(matrix[i + 1]).dec;
        }
        return result;
    }

    public static void main(String[] args) throws NullPointerException {
        int i = 7, k = 1, Px = 7, P1x = 6;
        //int i = 26, k = 3, Px = 12, P1x = 3;
        int Cx[] = {1, 13};

        tableFill(table);

        int K[] = new int[4];
        i %= 15;
        if (i == 0) i = 1;
        //K 0
        K[0] = byDec(i).a + byDec(2).a + byRev(byDec(3).a).a;
        K[0] %= 15;
        if (K[0] == 0) K[0] = 1;
        K[0] = byA(K[0]).dec;


        //K 1
        K[1] = byDec(byDec(i).dec ^ byDec(k).dec).a +
                byRev(byDec(7).a).a;
        K[1] %= 15;
        if (K[1] == 0) K[1] = 1;
        K[1] = byA(K[1]).dec;


        //K 2
        K[2] = byDec(byA(byDec(3).a + byDec(i).a).dec ^ byDec(2).dec).a +
                byRev(byDec(k).a).a;
        K[2] %= 15;
        if (K[2] == 0) K[2] = 1;
        K[2] = byA(K[2]).dec;


        //K 3
        K[3] = i ^ 7;
        System.out.println("K");
        binShow(K[0]);
        binShow(K[1]);
        binShow(K[2]);
        binShow(K[3]);


        System.out.println();
        int P[] = new int[4];


        P[0] = byDec(5).a + byDec(i).a + byRev(byDec(i).a).a;
        P[0] = byA(P[0]).dec;

        P[1] = byA(byDec(7).a + byDec(k).a).dec ^ byDec(9).dec;

        P[2] = byA(byDec(8).a + byDec(i).a).dec ^ byDec(14).dec;

        int gg = 6 ^ i;
        int gg1 = byA(byDec(5).a + byDec(i).a).dec ^ k;

        if (gg == 0 || gg1 == 0) P[3] = 0;
        else {
            P[3] = byDec(gg).a + byRev(byDec(gg1).a).a;
            P[3] = byA(P[3]).dec;
        }

        System.out.println("P");
//        binShow(P[0]);
//        binShow(P[1]);
//        binShow(P[2]);
//        binShow(P[3]);

        S = new int[16][3];

        int px = byDec(Px).a;
        int p1x = byDec(P1x).a;
        //System.out.println(px + "\n" + p1x);

        //S(x)=x^(-1)*p+p1
        System.out.println();

        S[0][0] = byA(p1x).dec;
        S[0][1] = S[0][2] = 0;

        for (int j = 0; j < S.length; j++) {
            if (j > 0) {
                S[j][0] = byA(byA(j).rev + px).dec ^ byA(p1x).dec;
                S[j][1] = j;
                S[j][2] = byA(j).dec;
            }

            String strS = Integer.toString(S[j][0], 2);
            while (strS.length() < 4) strS = "0" + strS;

            String strBin = Integer.toString(S[j][2], 2);
            while (strBin.length() < 4) strBin = "0" + strBin;

            //   System.out.printf("S[%4s] = a^%2d = %4s\n", strS, S[j][1], strBin);
        }

        //C

        int[][] C = new int[9][2];

        C[2][0] = 2;
        C[2][1] = 0;

        C[8][0] = 8;
        C[8][1] = 0;

        C[6][0] = 6;
        C[6][1] = 0;


        // W

        int W[][] = new int[7][2];

        W[0] = new int[]{K[0], K[1]};
        W[1] = new int[]{K[2], K[3]};

        W[2] = sumMatrix(sumMatrix(W[0], sbMatrix(reverseMatrix(W[1]))), C[2]);

        W[3] = sumMatrix(W[2], W[1]);

        W[4] = sumMatrix(sumMatrix(sbMatrix(reverseMatrix(W[3])), W[2]), C[8]);

        W[5] = sumMatrix(W[3], W[4]);

        W[6] = sumMatrix(sumMatrix(W[4], sbMatrix(reverseMatrix(W[5]))), C[6]);


        int[] arrHelper = concatArrays(W[0], W[1]);

        int[] X = sumMatrix(P, arrHelper);
        System.out.println("Start: " + Arrays.toString(X));

        X = sbMatrix(X);
        System.out.println("Sub: " + Arrays.toString(X));

        X = shiftMatrix(X);
        System.out.println("Shift: " + Arrays.toString(X));

        int[] y = new int[4];

        y[0] = Cx[0];
        y[1] = Cx[1];
        y[2] = Cx[1];
        y[3] = Cx[0];
        System.out.println("Y: " + Arrays.toString(y));


        int[] mixOne = sumMatrix(y, new int[]{X[0], X[1]});
        System.out.println("Mix first: " + Arrays.toString(mixOne));

        int[] mixTwo = sumMatrix(y, new int[]{X[2], X[3]});
        System.out.println("Mix second: " + Arrays.toString(mixTwo));

        X = concatArrays(mixOne, mixTwo);
        System.out.println("X mix: " + Arrays.toString(X));


    }

    static int[] concatArrays(int[] arrOne, int[] arrTwo) {
        int[] result = new int[arrOne.length + arrTwo.length];
        System.arraycopy(arrOne, 0, result, 0, arrOne.length);
        System.arraycopy(arrTwo, 0, result, arrOne.length, arrTwo.length);
        return result;
    }

    static int[] sumMatrix(int[] matr1, int[] matr2) {
        int resultMatr[] = new int[matr1.length];
        int resMatr[] = new int[matr2.length];


        if (matr2.length < matr1.length) {
            for (int i = 0; i < matr1.length; i += 2) {
                int sumA = byDec(matr1[i]).a + byDec(matr2[0]).a;
                sumA %= 15;
                if (sumA == 0) sumA = 1;
                resultMatr[i] = sumA;

                int sumB = byDec(matr1[i + 1]).a + byDec(matr2[1]).a;
                sumB %= 15;
                if (sumB == 0) sumB = 1;
                resultMatr[i + 1] = sumB;
            }
            resMatr[0] = byA(resultMatr[0]).dec ^ byA(resultMatr[1]).dec;
            resMatr[1] = byA(resultMatr[2]).dec ^ byA(resultMatr[3]).dec;
            resultMatr = resMatr;


        } else {
            for (int i = 0; i < matr1.length; i++) {
                resultMatr[i] = matr1[i] ^ matr2[i];
            }
        }
        return resultMatr;
    }


}
